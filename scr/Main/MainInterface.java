package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainInterface extends JFrame implements ActionListener{
    public static String[] places = {"Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "Tres Rios", "Curridabat", "Desamparados", "San Pedro", "San Jose", "Santa Ana","Ciudad Colon", "Alajuela", "Heredia"};
    public JPanel pane;
    public JButton calculate;
    public JButton additional;
    public JComboBox start;
    public JComboBox end;
    public JLabel lStart;
    public JLabel lEnd;
    public JLabel lDistance;
    public JLabel lTime;
    public JLabel lDelay;
    public JLabel map;
    public JTextField delay;
    public ImageIcon mapPic;

    public MainInterface() {
        setTitle("TEC Maps");
        setVisible(true);
        setSize(800, 600);
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
        calculate.setLocation(700,25);
        calculate.addActionListener( this::actionPerformed);
        pane.add(calculate);

        additional = new JButton("Info Adicional");
        additional.setSize(150,30);
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

        pane.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
