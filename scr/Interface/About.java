package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class About extends JFrame implements KeyListener {

    // es necesario crear una clase button para hacer el manejo de el ActionPerformed

    public String[] sortCities = SortSearch.getSortedList();
    public JPanel pane;
    static JTextField search;
    public JLabel title;
    static JButton bsearch;
    Font font = new Font("Times New Roman", Font.PLAIN, 16);

    public About() {

        this.setTitle("Información Adicional");
        this.setVisible(true);
        this.setSize(400,600);
        this.setResizable(false);

        pane = new JPanel();
        pane.setLayout(null);
        pane.setBackground(Color.decode("#fff9eb"));

        this.getContentPane().add(this.pane);

        search = new JTextField();
        search.setSize(200,30);
        search.setLocation(40,50);
        search.addKeyListener(this);
        pane.add(search);

        title = new JLabel("Información de Destinos Disponibles");
        title.setSize(250,20);
        title.setLocation(50, 20);
        title.setFont(font);
        pane.add(this.title);

        bsearch = new JButton("Buscar");
        bsearch.setSize(75, 30);
        bsearch.setLocation(245,50);
        bsearch.addActionListener(new ButtonListener());
        pane.add(bsearch);

        this.pane.repaint();
        this.setDefaultCloseOperation(3);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    static class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String place = search.getText();
            System.out.println(place);
            System.out.println(SortSearch.linelSearch(place));

            if(SortSearch.linelSearch(place) == "found"){
                Places.getInfo(place);
            }else {
                JOptionPane.showMessageDialog(null, "Lugar no encontrado");
            }
            //aquí se hace la búsqueda
        }
    }
}
