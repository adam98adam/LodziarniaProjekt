package projekt;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie {

    static private Connection polacz=null;
    static private String baza = "";
    static private String login = "";
    static private String haslo = "";

    static public Connection getPolacz() {
        return polacz;
    }

     static public void setPolacz(Connection polacz1) {
        polacz = polacz1;
    }

    static public String getBaza() {
        return baza;
    }

    static public void setBaza(String baza1) {
        baza = baza1;
    }

    static public String getLogin() {
        return login;
    }

    static public void setLogin(String login1){
        login = login1;
    }

    static public String getHaslo() {
        return haslo;
    }

    static public void setHaslo(String haslo1) {
        haslo = haslo1;
    }

    static public void polaczSie() {
        JFrame dialog;
        try{
            polacz = DriverManager.getConnection("" +
                    "databaseName=" + baza  + ";" +
                    "user=" + login +
                    ";password=" + haslo + ";");

            dialog = new JFrame();
            JOptionPane.showMessageDialog(dialog,"Polaczono z baza danych");

        } catch (SQLException throwables) {
            dialog = new JFrame();
            JOptionPane.showMessageDialog(dialog,"Brak polaczenia z baza danych","Blad",JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args){ }

}
