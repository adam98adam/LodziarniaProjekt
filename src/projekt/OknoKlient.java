package projekt;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OknoKlient implements ActionListener {
    static private JFrame okno;
    static private JTable table;
    static private JLabel witaj,data,godzina,zamowienia;
    static private JButton uzytkownik,osoba,usun,zamow;
    static private JScrollPane sp;
    //pobieranie wybranych kolumn do jedenj listy; wszystkie atrybuty przyjmuje jako String
    static public java.util.List<String[]> lista = new ArrayList<String[]>();


    static public void utworzOkno() throws SQLException {

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
        zamowienia = new JLabel();
        zamowienia.setText("Moje Zamowienia :");
        zamowienia.setBounds(50,230,250,30);
        zamowienia.setFont(new Font("Serif", Font.BOLD, 25));
        zamowienia.setForeground(Color.GREEN);
        tabela();
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
        okno.add(zamowienia);
        okno.add(uzytkownik);
        okno.add(osoba);
        okno.add(usun);
        okno.add(zamow);
        okno.add(sp);

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
        zamow = new JButton("Zamow");
        uzytkownik.setBounds(50,150,100,20);
        osoba.setBounds(200,150,100,20);
        usun.setBounds(350,150,100,20);
        zamow.setBounds(370,280,100,20);
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
                oknoUsun();

            }
        });
        zamow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    oknoZamow();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


    }

    public static void tabela() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String idZamowienia = "SELECT idZamowienia FROM Zamowienia WHERE idOsoba = " + Osoby.getId();
        String sql = "SELECT smak,pojemnosc_mL,cena FROM ((Lacznik L INNER JOIN Cennik C ON L.idCennik = C.idCennik) INNER JOIN Lody Lo ON L.idLody = Lo.idLody) WHERE L.idZamowienia IN (" + idZamowienia + ")";
        stmt.executeQuery(sql);
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData wynik = rs.getMetaData();
        int ile_kolumn = wynik.getColumnCount();
        //pobranie wybranych kolumn do jednej listy
        while (rs.next()) {
            String[] t = {rs.getString("smak"), rs.getString("pojemnosc_mL"), rs.getString("cena")};
            lista.add(t);
        }

        //konwersja listy do tablicy na potrzeby JTable
        String array[][]=new String[lista.size()][];
        for (int i=0;i<array.length;i++){
            String[] row=lista.get(i);
            array[i]=row;
        }

        String[] columns={"Smak","pojemnosc_ml","Cena"};
        table = new JTable(array,columns);
        sp = new JScrollPane(table);
        sp.setBounds(30,280,300,100);

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
        JLabel imie = new JLabel("Imie : ");
        JLabel nazwisko = new JLabel("Nazwisko : ");
        JLabel pesel = new JLabel("Pesel : ");
        JLabel telefon = new JLabel("Telefon : ");
        JTextField timie = new JTextField(Osoby.getImie());
        JTextField tnazwisko = new JTextField(Osoby.getNazwisko());
        JTextField tpesel = new JTextField(String.valueOf(Osoby.getPesel()));
        JTextField ttelefon = new JTextField(String.valueOf(Osoby.getTelefon()));
        JButton zatwierdz = new JButton("Zatwierdz");
        JButton przywroc = new JButton("Przywroc");
        imie.setBounds(20, 10, 100, 50);
        nazwisko.setBounds(20, 50, 100, 50);
        pesel.setBounds(20, 90, 100, 50);
        telefon.setBounds(20, 130, 100, 50);
        timie.setBounds(120, 25, 100, 20);
        tnazwisko.setBounds(120, 65, 100, 20);
        tpesel.setBounds(120, 105, 100, 20);
        ttelefon.setBounds(120, 145, 100, 20);
        zatwierdz.setBounds(50, 200, 100, 20);
        przywroc.setBounds(160, 200, 100, 20);
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
        osoba.add(przywroc);

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
                        if (Osoby.sprawdzPeselTelefon(pesel, telefon)) {
                            Osoby.zmienOsobe(imie, nazwisko, pesel, telefon);
                            witaj.setText("Witaj : " + Osoby.getImie());
                            osoba.dispose();
                        } else
                            Komunikaty.istniejeOsoba();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }
        });

        przywroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timie.setText(Osoby.getImie());
                tnazwisko.setText(Osoby.getNazwisko());
                tpesel.setText(String.valueOf(Osoby.getPesel()));
                ttelefon.setText(String.valueOf(Osoby.getTelefon()));
            }
        });
    }

    public static void oknoUsun(){
        JLabel tekst = new JLabel();
        tekst.setText("Czy na pewno chcesz usunac konto ?");
        JButton tak = new JButton("Tak");
        JButton nie = new JButton("Nie");
        tekst.setForeground(Color.RED);
        tekst.setFont(new Font("Serif", Font.BOLD, 25));
        tekst.setBounds(50,20,400,100);
        tak.setBounds(50,120,150,20);
        nie.setBounds(290,120,150,20);


        JDialog usun = new JDialog();
        usun.setSize(500,200);
        int szer_okna = usun.getSize().width;
        int wys_okna = usun.getSize().height;
        usun.setLocation((Wymiary.getSzer() - szer_okna) / 2, (Wymiary.getWys() - wys_okna) / 2);
        usun.setLayout(null);
        usun.setResizable(false);
        usun.setVisible(true);
        usun.add(tekst);
        usun.add(tak);
        usun.add(nie);

        tak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DodatkiZamowienia.usunDodatkiLacznikKlient();
                    NapojeZamowienia.usunNapojeZamowieniaKlient();
                    Lacznik.usunZamowieniaLacznikKlient();
                    Zamowienia.usunZamowieniaKlient();
                    Osoby.usunOsobeKlient();
                    Uzytkownicy.usunUzytkownikaKlient();
                    System.exit(0);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        nie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usun.dispose();
            }
        });

    }

    public static void oknoZamow() throws SQLException {
        JComboBox smak = new JComboBox();
        JComboBox pojemonsc = new JComboBox();
        JLabel wybierzSmak = new JLabel("Wybierz smak:");
        JLabel wybierzPojemnosc = new JLabel("Wybierz pojemnosc(mL):");
        JLabel cenaLod = new JLabel("Cena:");
        JTextField cenaPojemnosc = new JTextField("");



        JTextField tcenaLod= new  JTextField("");
        JButton zatwierdz = new JButton("Zatwierdz");
        wybierzSmak.setBounds(20,50,100,20);
        smak.setBounds(110,50,100,20);
        wybierzPojemnosc.setBounds(240,50,160,20);
        pojemonsc.setBounds(390,50,100,20);
        cenaLod.setBounds(520,50,100,20);
        cenaPojemnosc.setBounds(600,50,100,20);
        Lody.pobierzSmaki(smak);
        Cennik.pobierzPojemnosci(pojemonsc);

        JDialog zamowienie = new JDialog();
        zamowienie.setSize(800,400);
        int szer_okna = zamowienie.getSize().width;
        int wys_okna = zamowienie.getSize().height;
        zamowienie.setLocation((Wymiary.getSzer() - szer_okna) / 2, (Wymiary.getWys() - wys_okna) / 2);
        zamowienie.setVisible(true);
        zamowienie.setLayout(null);
        zamowienie.add(smak);
        zamowienie.add(wybierzSmak);
        zamowienie.add(pojemonsc);
        zamowienie.add(wybierzPojemnosc);
        zamowienie.add(cenaLod);
        zamowienie.add(cenaPojemnosc);
        zamowienie.setTitle("Zamowienie");

        pojemonsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmt = Polaczenie.getPolacz().createStatement();
                    String p = (String) pojemonsc.getSelectedItem();
                    String sql = "SELECT cena FROM Cennik WHERE pojemnosc_mL = " + p;
                    ResultSet rs = stmt.executeQuery(sql);
                    while(rs.next()){
                        cenaPojemnosc.setText(rs.getString("cena"));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });



    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
