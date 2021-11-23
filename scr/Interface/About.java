package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class About extends JFrame implements KeyListener {

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
        search.setLocation(60,50);
        search.addKeyListener(this);
        pane.add(search);

        title = new JLabel("Información de Destinos Disponibles");
        title.setSize(250,20);
        title.setLocation(75, 20);
        title.setFont(font);
        pane.add(this.title);

        bsearch = new JButton("Buscar");
        bsearch.setSize(75, 30);
        bsearch.setLocation(265,50);
        bsearch.addActionListener(new ButtonListener());
        pane.add(bsearch);

        printButtons();

        this.pane.repaint();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

    public void printButtons (){

        int x = 125;
        int y = 100;

        for(int i = 0; i < sortCities.length; i++){

            createButton(sortCities[i], x, y);
            y += 30;

        }

    }

    public void createButton (String city, int x, int y){

        CittyButton nuevo = new CittyButton(this, city, x, y);

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
        }
    }

    static class CittyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {



        }

    }
}
