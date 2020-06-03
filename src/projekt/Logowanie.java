package projekt;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Logowanie extends JDialog implements MenuListener, ActionListener {
    private JLabel labelkonto,labelhaslo;
    private JTextField textkonto,texthaslo;
    private JButton zaloguj;
    private JMenuBar mb;
    private JMenu menu;
    private JFrame komunikat;

    public JTextField getTextkonto() {
        return  textkonto;
    }

    public void setTextkonto(JTextField textkonto) {
        this.textkonto = textkonto;
    }

    public JTextField getTexthaslo() {
        return texthaslo;

    }

    public void setTexthaslo(JTextField texthaslo) {
        this.texthaslo = texthaslo;
    }

    public JLabel getLabelkonto() {
        return labelkonto;
    }

    public void setLabelkonto(JLabel labelkonto) {
        this.labelkonto = labelkonto;
    }

    public JLabel getLabelhaslo() {
        return  labelhaslo;
    }

    public void setLabelhaslo(JLabel labelhaslo) {
        this.labelhaslo = labelhaslo;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == zaloguj) {
            Uzytkownicy.setKonto(textkonto.getText());
            Uzytkownicy.setHaslo(texthaslo.getText());
            if (Uzytkownicy.getKonto().length() <= 4 || Uzytkownicy.getKonto().length() > 20 || Uzytkownicy.getHaslo().length() <= 4 || Uzytkownicy.getHaslo().length() > 20) {
                komunikat = new JFrame();
                JOptionPane.showMessageDialog(komunikat, "Login lub haslo nie spelniaja kryteriow :(" + "\nWskazowka : Login i haslo musi zawierac wiecej niz 4 znaki i max 20", "Komunikat", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Statement stmt = Polaczenie.getPolacz().createStatement();
                    ResultSet rs = Uzytkownicy.sprawdzUzytkownika(stmt);
                    int rowCount = 0;
                    while (rs.next()) {
                        Uzytkownicy.setAdministrator(Boolean.parseBoolean(rs.getString("Administrator")));
                        rowCount++;
                    }
                    if (rowCount != 0) {
                        if (Uzytkownicy.getAdministrator()) {
                            Uzytkownicy.ustawUzytkownika(stmt);
                            System.out.println("Id : " + Uzytkownicy.getId() + " Konto : " + Uzytkownicy.getKonto() + " Haslo : " + Uzytkownicy.getHaslo() + " Adminitrator : " + Uzytkownicy.getAdministrator());
                        } else {
                            Uzytkownicy.ustawUzytkownika(stmt);
                            System.out.println("Id : " + Uzytkownicy.getId() + " Konto : " + Uzytkownicy.getKonto() + " Haslo : " + Uzytkownicy.getHaslo() + " Adminitrator : " + Uzytkownicy.getAdministrator());
                            dispose();
                            OknoKlient.utworzOkno();
                        }

                    } else {
                        System.out.println("Nie ma tekigo uzytkownika");
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        Object zrodlo = e.getSource();

        if(zrodlo == menu) {
            Polaczenie.polaczSie();
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    Logowanie() {
        mb = new JMenuBar();
        menu = new JMenu("Polacz");
        menu.addMenuListener(this);
        mb.add(menu);
        setJMenuBar(mb);
        labelkonto = new JLabel("Login : ");
        labelhaslo = new JLabel("Haslo : ");
        labelkonto.setBounds(50,50,50,50);
        labelhaslo.setBounds(50,100,50,50);
        add(labelkonto);
        add(labelhaslo);
        textkonto = new JTextField("");
        texthaslo = new JTextField("");
        textkonto.setBounds(120,65,150,20);
        texthaslo.setBounds(120,115,150,20);
        add(textkonto);
        add(texthaslo);
        zaloguj = new JButton("Zaloguj");
        zaloguj.setBounds(110,180,80,20);
        zaloguj.addActionListener(this);
        add(zaloguj);
        setSize(300,300);
        int szer_okna=getSize().width;
        int wys_okna=getSize().height;
        setLocation((Wymiary.getSzer()-szer_okna)/2,(Wymiary.getWys()-wys_okna)/2);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Logowanie");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Logowanie l = new Logowanie();
    }
}
