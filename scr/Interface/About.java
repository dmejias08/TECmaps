package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class About extends JFrame implements KeyListener {

    // es necesario crear una clase button para hacer el manejo de el ActionPerformed

    JPanel pane;
    JTextField search;

    public About() {

        this.setTitle("Información Adicional");
        this.setVisible(true);
        this.setSize(400,600);

        this.pane = new JPanel();
        this.getContentPane().add(this.pane);
        this.pane.setLayout(null);
        this.pane.setBackground(Color.decode("#fff9eb"));
        this.setResizable(false);

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
}
