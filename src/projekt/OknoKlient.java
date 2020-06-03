package projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoKlient implements ActionListener {
    static private JFrame okno;

    static public void utworzOkno() {
        int szer= Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys= Toolkit.getDefaultToolkit().getScreenSize().height;
        okno = new JFrame("Klient");
        okno.setVisible(true);
        okno.setSize(300,300);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
