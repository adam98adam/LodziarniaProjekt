package projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OknoKlient implements ActionListener {
    static private JFrame okno;
    static private JLabel witaj,data,godzina;

    static public void utworzOkno() {

        witaj = new JLabel("");
        witaj.setBounds(180,10,200,30);
        witaj.setText("Witaj : " + Osoby.getImie());
        witaj.setFont(new Font("Serif", Font.BOLD, 25));
        witaj.setForeground(Color.MAGENTA);
        data = new JLabel("Data : " + pokazDzien());
        godzina = new JLabel("");
        pokazCzas();
        data.setBounds(160,50,200,30);
        godzina.setBounds(130,90,300,30);
        data.setFont(new Font("Serif", Font.BOLD, 25));
        data.setForeground(Color.MAGENTA);
        godzina.setFont(new Font("Serif", Font.BOLD, 25));
        godzina.setForeground(Color.MAGENTA);
        okno = new JFrame("Klient");
        okno.setVisible(true);
        okno.setSize(500,500);
        int szer_okna=okno.getSize().width;
        int wys_okna=okno.getSize().height;
        okno.setLocation((Wymiary.getSzer()-szer_okna)/2,(Wymiary.getWys()-wys_okna)/2);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.setLayout(null);
        okno.setResizable(false);
        okno.add(witaj);
        okno.add(data);
        okno.add(godzina);

    }

    public static String pokazDzien() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return s.format(d);
    }

    public static void pokazCzas() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                godzina.setText("Godzina : " + s.format(d));
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
