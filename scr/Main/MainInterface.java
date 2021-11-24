package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Interface.About;
import Interface.Places;
import Interface.SortSearch;

public class MainInterface extends JFrame implements ActionListener, KeyListener, MouseListener {
    public static String[] places = Edge.cities.toArray(new String[0]);
    public static About about;
    public JPanel pane;
    public JButton calculate;
    public JButton additional;
    public JComboBox start;
    public JComboBox end;
    public JLabel lStart;
    public JLabel lEnd;
    public JLabel lDetail;
    public JLabel lDistance;
    public JLabel lTime;
    public JLabel lDelay;
    public JLabel map;
    public JTextField delay;
    public ImageIcon mapPic;
    private Graph graph;

    public MainInterface() {
        this.setTitle("TEC Maps");
        this.setVisible(true);
        this.setSize(1100, 730);
        this.setResizable(false);
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#fff9eb"));

        mapPic= new ImageIcon("assets/map.png");
        map = new JLabel(mapPic);
        map.setSize(823,650);
        map.setLocation(0,80);
        pane.add(map);

        calculate = new JButton("");
        calculate.setSize(125,40);
        calculate.setLocation(600, 20);
        calculate.addActionListener( this::actionPerformed);
        calculate.setFont(new Font("Girassol",Font.PLAIN,20));
        calculate.setIcon(new ImageIcon("assets/goButton.png"));
        calculate.addMouseListener(this);
        calculate.setBorder(null);

        pane.add(calculate);

        additional = new JButton("");
        additional.setSize(200,150);
        additional.setLocation(850,500);
        additional.addActionListener( this::actionPerformed);
        additional.setIcon(new ImageIcon("assets/adButton.png"));
        additional.addMouseListener(this);
        additional.setBorder(null);
        pane.add(additional);

        lStart = new JLabel("Inicio:");
        lStart.setSize(60,40);
        lStart.setLocation(25, 20);
        lStart.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lStart);

        lEnd = new JLabel("Final:");
        lEnd.setSize(60,40);
        lEnd.setLocation(225, 20);
        lEnd.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lEnd);

        lDelay = new JLabel("Atraso:");
        lDelay.setSize(60,40);
        lDelay.setLocation(425, 20);
        lDelay.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lDelay);

        lDetail = new JLabel("DETALLES DE VIAJE");
        lDetail.setSize(200,40);
        lDetail.setLocation(850, 100);
        lDetail.setFont(new Font("Girassol",Font.HANGING_BASELINE ,18));
        pane.add(lDetail);

        lDistance = new JLabel("Recorrido:");
        lDistance.setSize(200,250);
        lDistance.setLocation(850, 150);
        lDistance.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lDistance);

        lTime = new JLabel("Tiempo:");
        lTime.setSize(200,40);
        lTime.setLocation(850, 400);
        lTime.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lTime);

        start = new JComboBox(places);
        start.setSize(125,30);
        start.setLocation(75, 25);
        start.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(start);

        end = new JComboBox(places);
        end.setSize(125,30);
        end.setLocation(275, 25);
        end.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(end);

        delay = new JTextField();
        delay.setSize(75,30);
        delay.setLocation(490, 25);
        delay.setFont(new Font("Girassol",Font.PLAIN,16));
        delay.addKeyListener(this);
        pane.add(delay);

        pane.repaint();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        System.out.println("Iniciando...");

        try {
            this.graph = new Graph(Edge.createEdgeList());
            System.out.println("Iniciado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculate){
            String strt, fnal;
            int dlay;
            strt = start.getSelectedItem().toString();
            fnal = end.getSelectedItem().toString();
            if (!strt.isEmpty() && !fnal.isEmpty()){
                if (delay.getText().equals("")){
                    dlay=0;
                    delay.setText("0");
                } else {
                    dlay = Integer.parseInt(delay.getText());
                }
                if (graph != null) {
                    int startPlace = Edge.getCode(strt);
                    int endPlace = Edge.getCode(fnal);
                    System.out.println(startPlace);
                    System.out.println(endPlace);
                    System.out.println(dlay);

                    String[] result = graph.dijkStra(startPlace, endPlace, dlay);

//                    System.out.println(result[0] + " " + result[1] + " " + result [2]);

                    lDistance.setText("<html>Recorrido: " + result[2].replace(" ", "</p><p>->") +"</p></html>");
                    lTime.setText("Tiempo: " + result[1]);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Por favor espere, trabajamos en ello");
                }


//                System.out.println(strt);
//                System.out.println(fnal);
//                System.out.println(dlay);

            }

        } else if (e.getSource() == additional){
            About about = new About();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (key>47 && key<58) {
        } else {
            e.consume();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(calculate)){
            calculate.setIcon(new ImageIcon("assets/goButtonHover.png"));
        }
        if (e.getSource().equals(additional)){
           additional.setIcon(new ImageIcon("assets/adButtonHover.png"));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(calculate)){
            calculate.setIcon(new ImageIcon("assets/goButton.png"));
        }
        if (e.getSource().equals(additional)){
            additional.setIcon(new ImageIcon("assets/adButton.png"));
        }
    }
}
