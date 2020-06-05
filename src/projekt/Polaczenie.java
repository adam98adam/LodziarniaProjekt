package projekt;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie {

    private static  Connection polacz=null;
    private static String baza = "", login ="", haslo = "";

    public static Connection getPolacz() {
        return polacz;
    }

     public static void setPolacz(Connection polacz1) {
        polacz = polacz1;
    }

    public static String getBaza() {
        return baza;
    }

    public static void setBaza(String baza1) {
        baza = baza1;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login1){
        login = login1;
    }

    public static String getHaslo() {
        return haslo;
    }

    public static void setHaslo(String haslo1) {
        haslo = haslo1;
    }

    public static void polaczSie() {
        try{
            polacz = DriverManager.getConnection("" +
                    "databaseName=" + baza  + ";" +
                    "user=" + login +
                    ";password=" + haslo + ";");



        } catch (SQLException throwables) {
            Komunikaty.bladPolaczenia();

        }
    }

}
