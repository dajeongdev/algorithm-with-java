package Java.object2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent occurred!!!");
    }
}
