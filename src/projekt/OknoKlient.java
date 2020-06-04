package projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OknoKlient implements ActionListener {
    static private JFrame okno;
    static private JLabel witaj,data,godzina;
    static private JButton uzytkownik,osoba,usun;

    static public void utworzOkno() {

        witaj = new JLabel("");
        witaj.setBounds(180,10,200,30);
        witaj.setText("Witaj : " + Osoby.getImie());
        witaj.setFont(new Font("Serif", Font.BOLD, 25));
        witaj.setForeground(Color.GREEN);
        data = new JLabel("Data : " + pokazDzien());
        godzina = new JLabel("");
        pokazCzas();
        data.setBounds(160,50,200,30);
        godzina.setBounds(130,90,300,30);
        data.setFont(new Font("Serif", Font.BOLD, 25));
        data.setForeground(Color.GREEN);
        godzina.setFont(new Font("Serif", Font.BOLD, 25));
        godzina.setForeground(Color.GREEN);
        dodajPrzyciski();
        okno = new JFrame("Klient");
        okno.setVisible(true);
        okno.setSize(500,500);
        int szer_okna=okno.getSize().width;
        int wys_okna=okno.getSize().height;
        okno.setLocation((Wymiary.getSzer()-szer_okna)/2,(Wymiary.getWys()-wys_okna)/2);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.getContentPane().setBackground(Color.black);
        okno.setLayout(null);
        okno.setResizable(false);
        okno.add(witaj);
        okno.add(data);
        okno.add(godzina);
        okno.add(uzytkownik);
        okno.add(osoba);
        okno.add(usun);

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

    public static void  dodajPrzyciski() {
        uzytkownik = new JButton("Uzytkownik");
        osoba = new JButton("Dane");
        usun = new JButton("Usun Konto");
        uzytkownik.setBounds(50,150,100,20);
        osoba.setBounds(200,150,100,20);
        usun.setBounds(350,150,100,20);
        uzytkownik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             oknoUzytkownika();
            }
        });
        osoba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oknoOsoby();
            }
        });
        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }


    public static void oknoUzytkownika() {

        JLabel login = new JLabel("Login : ");
        JLabel haslo = new JLabel("Haslo : ");
        JTextField tlogin = new JTextField(Uzytkownicy.getKonto());
        JTextField thaslo = new JTextField(Uzytkownicy.getHaslo());
        JButton zatwierdz = new JButton("Zatwierdz");
        JButton przywroc = new JButton("Przywroc");
        login.setBounds(20,50,100,50);
        haslo.setBounds(20,120,100,50);
        tlogin.setBounds(100,65,150,20);
        thaslo.setBounds(100,135,150,20);
        zatwierdz.setBounds(50,200,100,20);
        przywroc.setBounds(160,200,100,20);
        JDialog uzytkownik = new JDialog();
        uzytkownik.setTitle("Uzytkownik");
        uzytkownik.setSize(300,300);
        int szer_okna=uzytkownik.getSize().width;
        int wys_okna=uzytkownik.getSize().height;
        uzytkownik.setLocation((Wymiary.getSzer()-szer_okna)/2,(Wymiary.getWys()-wys_okna)/2);
        uzytkownik.setResizable(false);
        uzytkownik.setVisible(true);
        uzytkownik.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        uzytkownik.add(login);
        uzytkownik.add(haslo);
        uzytkownik.add(tlogin);
        uzytkownik.add(thaslo);
        uzytkownik.add(zatwierdz);
        uzytkownik.add(przywroc);

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tlogin.getText();
                String haslo = thaslo.getText();

                if (login.length() <= 4 || login.length() > 20 || haslo.length() <= 4 || haslo.length() > 20)
                    Komunikaty.kryteriaUzytkownik();
                else {
                    try {
                        if(Uzytkownicy.sprawdzKonto(login)){
                            Komunikaty.istniejeUzytkownik();
                        }
                        else {
                            Uzytkownicy.zmienUzytkownika(login,haslo);
                            uzytkownik.dispose();
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }



            }
        });

        przywroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tlogin.setText(Uzytkownicy.getKonto());
                thaslo.setText(Uzytkownicy.getHaslo());
            }
        });



    }

    public static void oknoOsoby() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
