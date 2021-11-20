package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CittyButton implements ActionListener {

    JButton button;
    About screen;
    String place;

    public CittyButton(About screen, String place, int x, int y) {

        this.screen = screen;
        this.place = place;
        this.button = new JButton(place);
        this.button.setSize(150,20);
        this.button.setLocation(x, y);
        this.button.addActionListener(this);
        this.screen.pane.add(this.button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {click();}

    public void click(){
        String text = this.place;
        Places.getInfo(text);
    }
}
