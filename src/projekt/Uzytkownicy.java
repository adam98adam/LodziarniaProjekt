package projekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Uzytkownicy  {
     private static int id;
     private static  String konto = "", haslo = "";
     private static  boolean administrator;


    public static  int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static  String getKonto() {
        return konto;
    }

    public static void setKonto(String konto1) {
        konto = konto1;
    }

    public static  String getHaslo() {
        return haslo;
    }

    public static  void setHaslo(String haslo1) {
        haslo = haslo1;

    }

    public static boolean getAdministrator() {
        return administrator;
    }

    public static void setAdministrator(boolean administrator1) {
        administrator = administrator1;
    }

    public static ResultSet sprawdzUzytkownika(Statement stmt) throws SQLException {
        String sql = "SELECT CASE WHEN Administrator = 0 THEN 'False' ELSE 'True' END AS Administrator FROM Uzytkownicy WHERE Konto = '" + konto + "' AND Haslo = '" + haslo + "'";
        return stmt.executeQuery(sql);
    }

    public static void ustawUzytkownika(Statement stmt) throws SQLException {
        String sql = "SELECT idUzytkownicy,CASE WHEN Administrator = 0 THEN 'False' ELSE 'True' END AS Administrator FROM Uzytkownicy WHERE Konto = '" + konto + "' AND Haslo = '" + haslo + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            id = rs.getInt("idUzytkownicy");
            administrator = Boolean.parseBoolean(rs.getString("Administrator"));
        }
    }

    public static boolean sprawdzKonto(String s) throws SQLException {
        String a = "";
        int liczba = 0 ;
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT konto FROM Uzytkownicy WHERE konto = '" + s + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            a = rs.getString("konto");
        }
        sql = "SELECT COUNT(*) AS Liczba FROM Uzytkownicy WHERE konto = '" + s + "'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            liczba = rs.getInt("Liczba");
        }

        if(a.equals(getKonto()) || liczba == 0)
            return false;
        else
            return true;

    }

    public static boolean sprawdzKontoAdministrator(String s) throws SQLException {
        int liczba = 0 ;
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT COUNT(*) AS Liczba FROM Uzytkownicy WHERE konto = '" + s + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            liczba = rs.getInt("Liczba");
        }
        if(liczba == 0)
            return false;
        else
            return true;




    }

    public static void zmienUzytkownika(String k,String h) throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "UPDATE Uzytkownicy SET konto = '" + k + "',haslo = '" + h + "' WHERE konto = '" + getKonto() + "'";
        stmt.executeUpdate(sql);
        setKonto(k);
        setHaslo(h);
    }

    public static void usunUzytkownikaKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String usun = "DELETE FROM Uzytkownicy WHERE idUzytkownicy = " + getId();
        stmt.executeUpdate(usun);
    }

    public static void nowyUzytkownik(String login,String haslo,int admin) throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "INSERT INTO Uzytkownicy VALUES ('" + login + "','" + haslo + "'," + admin + ")";
        stmt.executeUpdate(sql);
    }

    public static int maxId() throws SQLException {
        int id=0;
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT MAX(idUzytkownicy) AS Max FROM Uzytkownicy";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            id = rs.getInt("Max");
        }
        return  id;
    }

}



