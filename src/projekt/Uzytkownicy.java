package projekt;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uzytkownicy extends JFrame implements MenuListener,ActionListener {
    private int id;
    private String konto;
    private String haslo;
    private boolean administrator;
    private JLabel labelkonto,labelhaslo;
    private JTextField textkonto,texthaslo;
    private JButton zaloguj;
    private JMenuBar mb;
    private JMenu menu;



    public int getId() {
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKonto() {
        return  konto;
    }

    public void setKonto(String konto) {
        this.konto = konto;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

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




    Uzytkownicy() {

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
        int szer=Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys= Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(300,300);
        int szer_okna=getSize().width;
        int wys_okna=getSize().height;
        setLocation((szer-szer_okna)/2,(wys-wys_okna)/2);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();


        if(zrodlo == zaloguj) {

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

    public static void main(String[] args) {
        Uzytkownicy u = new Uzytkownicy();
    }
}
