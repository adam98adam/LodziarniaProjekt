package projekt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie {

    private Connection polacz=null;
    private String baza;
    private String login;
    private String haslo;

    public Connection getPolacz() {
        return polacz;
    }

    public void setPolacz(Connection polacz) {
        this.polacz = polacz;
    }

    public String getBaza() {
        return baza;
    }

    public void setBaza(String baza) {
        this.baza = baza;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Connection polaczSie() {
        try{
            polacz = DriverManager.getConnection("" +
                    "databaseName=" + baza  + ";" +
                    "user=" + login +
                    ";password=" + haslo + ";");
            System.out.println("Polaczono !!!");
        } catch (SQLException throwables) {
            System.out.println("Blad polaczenia");
        }
        return polacz;
    }

    Polaczenie(){
        polaczSie();
    }

    public static void main(String[] args){
        Polaczenie p = new Polaczenie();
    }

}
