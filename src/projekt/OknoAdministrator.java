package projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OknoAdministrator {
    static private JFrame okno;
    static private JLabel witaj, data, godzina;
    static private JButton uzytkownik, osoba,dodajUzytkownika,dodajOsobe;


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

    static public void utworzOkno() {
        witaj = new JLabel("");
        witaj.setBounds(180, 10, 200, 30);
        witaj.setText("Witaj : " + Osoby.getImie());
        witaj.setFont(new Font("Serif", Font.BOLD, 25));
        witaj.setForeground(Color.GREEN);
        data = new JLabel("Data : " + pokazDzien());
        godzina = new JLabel("");
        pokazCzas();
        dodajPrzyciski();
        data.setBounds(160, 50, 200, 30);
        godzina.setBounds(130, 90, 300, 30);
        data.setFont(new Font("Serif", Font.BOLD, 25));
        data.setForeground(Color.GREEN);
        godzina.setFont(new Font("Serif", Font.BOLD, 25));
        godzina.setForeground(Color.GREEN);
        okno = new JFrame("Administrator");
        okno.setVisible(true);
        okno.setSize(500, 500);
        int szer_okna = okno.getSize().width;
        int wys_okna = okno.getSize().height;
        okno.setLocation((Wymiary.getSzer() - szer_okna) / 2, (Wymiary.getWys() - wys_okna) / 2);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.getContentPane().setBackground(Color.black);
        okno.setLayout(null);
        okno.setResizable(false);
        okno.add(witaj);
        okno.add(data);
        okno.add(godzina);
        okno.add(uzytkownik);
        okno.add(osoba);
        okno.add(dodajUzytkownika);
        okno.add(dodajOsobe);


    }

    public static void dodajPrzyciski() {
        uzytkownik = new JButton("Uzytkownik");
        osoba = new JButton("Dane");
        dodajUzytkownika = new JButton("Dodaj Uzytkownika");
        dodajOsobe = new JButton("Dodaj Osobe");
        uzytkownik.setBounds(130, 150, 100, 20);
        osoba.setBounds(280, 150, 100, 20);
        dodajUzytkownika.setBounds(10,200,200,20);
        dodajOsobe.setBounds(250,200,200,20);
        uzytkownik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OknoKlient.oknoUzytkownika();
            }
        });
        osoba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OknoKlient.oknoOsoby();
            }
        });
        dodajUzytkownika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajUzytkownika();


            }
        });
        dodajOsobe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajOsobe();
            }
        });


    }

    public static void dodajUzytkownika(){
        JLabel login = new JLabel("Login : ");
        JLabel haslo = new JLabel("Haslo : ");
        JTextField tlogin = new JTextField("");
        JTextField thaslo = new JTextField("");
        JRadioButton klient = new JRadioButton("Klient");
        JRadioButton administrator = new JRadioButton("Administrator");
        JButton zatwierdz = new JButton("Zatwierdz");

        login.setBounds(20, 30, 100, 50);
        haslo.setBounds(20, 100, 100, 50);
        tlogin.setBounds(100, 45, 150, 20);
        thaslo.setBounds(100, 115, 150, 20);
        klient.setBounds(20,160,100,20);
        administrator.setBounds(130, 160, 150, 20);
        zatwierdz.setBounds(100,200,100,20);

        JDialog uzytkownik = new JDialog();
        uzytkownik.setTitle("Dodaj Uzytkownika");
        uzytkownik.setSize(300, 300);
        int szer_okna = uzytkownik.getSize().width;
        int wys_okna = uzytkownik.getSize().height;
        uzytkownik.setLocation((Wymiary.getSzer() - szer_okna) / 2, (Wymiary.getWys() - wys_okna) / 2);
        uzytkownik.setResizable(false);
        uzytkownik.setVisible(true);
        uzytkownik.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        uzytkownik.add(login);
        uzytkownik.add(haslo);
        uzytkownik.add(tlogin);
        uzytkownik.add(thaslo);
        uzytkownik.add(zatwierdz);
        uzytkownik.add(klient);
        uzytkownik.add(administrator);

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tlogin.getText();
                String haslo = thaslo.getText();
                int admin = 0;
                if(administrator.isSelected())
                    admin = 1;

                if (login.length() <= 4 || login.length() > 20 || haslo.length() <= 4 || haslo.length() > 20)
                    Komunikaty.kryteriaUzytkownik();
                else {
                    try {
                        if (Uzytkownicy.sprawdzKontoAdministrator(login)) {
                            Komunikaty.istniejeUzytkownik();
                        } else {
                            Uzytkownicy.nowyUzytkownik(login,haslo,admin);
                            uzytkownik.dispose();
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


            }
        });
    }

    public static void dodajOsobe() {
        JLabel imie = new JLabel("Imie : ");
        JLabel nazwisko = new JLabel("Nazwisko : ");
        JLabel pesel = new JLabel("Pesel : ");
        JLabel telefon = new JLabel("Telefon : ");
        JTextField timie = new JTextField("");
        JTextField tnazwisko = new JTextField("");
        JTextField tpesel = new JTextField("");
        JTextField ttelefon = new JTextField("");
        JButton zatwierdz = new JButton("Zatwierdz");
        imie.setBounds(20, 10, 100, 50);
        nazwisko.setBounds(20, 50, 100, 50);
        pesel.setBounds(20, 90, 100, 50);
        telefon.setBounds(20, 130, 100, 50);
        timie.setBounds(120, 25, 100, 20);
        tnazwisko.setBounds(120, 65, 100, 20);
        tpesel.setBounds(120, 105, 100, 20);
        ttelefon.setBounds(120, 145, 100, 20);
        zatwierdz.setBounds(100, 200, 100, 20);
        JDialog osoba = new JDialog();
        osoba.setTitle("Osoba");
        osoba.setSize(300, 300);
        int szer_okna = osoba.getSize().width;
        int wys_okna = osoba.getSize().height;
        osoba.setLocation((Wymiary.getSzer() - szer_okna) / 2, (Wymiary.getWys() - wys_okna) / 2);
        osoba.setResizable(false);
        osoba.setVisible(true);
        osoba.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        osoba.add(imie);
        osoba.add(nazwisko);
        osoba.add(pesel);
        osoba.add(telefon);
        osoba.add(timie);
        osoba.add(tnazwisko);
        osoba.add(tpesel);
        osoba.add(ttelefon);
        osoba.add(zatwierdz);

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = timie.getText();
                String nazwisko = tnazwisko.getText();
                String pesel = tpesel.getText();
                String telefon = ttelefon.getText();

                if (imie.length() <= 2 || imie.length() > 20 || nazwisko.length() <= 2 || pesel.length() != 11 || telefon.length() != 9)
                    Komunikaty.kryteriaOsoba();
                else {
                    try {
                        if (Osoby.sprawdzPeselTelefonAdministrator(pesel,telefon)) {
                            Osoby.nowaOsoba(imie, nazwisko, pesel, telefon);
                            osoba.dispose();
                        } else
                            Komunikaty.istniejeOsoba();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }
        });
    }
}


