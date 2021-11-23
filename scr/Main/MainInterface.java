package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Interface.About;
import Interface.Places;
import Interface.SortSearch;

public class MainInterface extends JFrame implements ActionListener, KeyListener {
    public static String[] places = {"Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia"};
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

    public MainInterface() {
        this.setTitle("TEC Maps");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
        pane = new JPanel();
        this.getContentPane().add(pane);
        pane.setLayout(null);
        pane.setBackground(Color.decode("#fff9eb"));

        mapPic= new ImageIcon("assets/map.png");
        map = new JLabel(mapPic);
        map.setSize(540,426);
        map.setLocation(10,100);
        pane.add(map);

        calculate = new JButton("Calcular");
        calculate.setSize(80,30);
        calculate.setLocation(600, 30);
        calculate.addActionListener( this::actionPerformed);
        pane.add(calculate);

        additional = new JButton("Info Adicional");
        additional.setSize(125,30);
        additional.setLocation(600,500);
        additional.addActionListener( this::actionPerformed);
        pane.add(additional);

        lStart = new JLabel("Inicio:");
        lStart.setSize(60,40);
        lStart.setLocation(25, 25);
        lStart.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lStart);

        lEnd = new JLabel("Final:");
        lEnd.setSize(60,40);
        lEnd.setLocation(225, 25);
        lEnd.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lEnd);

        lDelay = new JLabel("Atraso:");
        lDelay.setSize(60,40);
        lDelay.setLocation(425, 25);
        lDelay.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lDelay);

        lDetail = new JLabel("DETALLES DE VIAJE");
        lDetail.setSize(300,40);
        lDetail.setLocation(575, 150);
        lDetail.setFont(new Font("Girassol",Font.HANGING_BASELINE ,18));
        pane.add(lDetail);

        lDistance = new JLabel("Distancia:");
        lDistance.setSize(300,40);
        lDistance.setLocation(575, 225);
        lDistance.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lDistance);

        lTime = new JLabel("Tiempo:");
        lTime.setSize(300,40);
        lTime.setLocation(575, 300);
        lTime.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(lTime);

        start = new JComboBox(places);
        start.setSize(125,30);
        start.setLocation(75, 30);
        start.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(start);

        end = new JComboBox(places);
        end.setSize(125,30);
        end.setLocation(275, 30);
        end.setFont(new Font("Girassol",Font.PLAIN,16));
        pane.add(end);

        delay = new JTextField();
        delay.setSize(75,30);
        delay.setLocation(490, 30);
        delay.setFont(new Font("Girassol",Font.PLAIN,16));
        delay.addKeyListener(this);
        pane.add(delay);

        pane.repaint();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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
                //Aqui se llama al algoritmo que calcula distancia y tiempo
                System.out.println(strt);
                System.out.println(fnal);
                System.out.println(dlay);

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
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
