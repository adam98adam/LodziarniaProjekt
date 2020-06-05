package projekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Zamowienia {
    private static int id, idOsoba;
    private static String data_zamowienia, data_dostarczenia;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static int getIdOsoba() {
        return idOsoba;
    }

    public static void setIdOsoba(int idOsoba1) {
        idOsoba = idOsoba1;
    }

    public static String getData_zamowienia() {
        return data_zamowienia;
    }

    public static void setData_zamowienia(String data_zamowienia1) {
        data_zamowienia = data_zamowienia1;
    }

    public static String getData_dostarczenia() {
        return data_dostarczenia;
    }

    public static void setData_dostarczenia(String data_dostarczenia1) {
        data_dostarczenia = data_dostarczenia1;
    }


    public static void usunZamowieniaKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "DELETE FROM Zamowienia WHERE  idOsoba = " + Osoby.getId();
        stmt.executeUpdate(sql);
    }

    public static void zamowieniaKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "INSERT INTO Zamowienia VALUES (" + Osoby.getId()  + ",NULL,NULL)";
        stmt.executeUpdate(sql);
        sql = "SELECT MAX(idZamowienia) AS MaxId FROM Zamowienia";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Zamowienia.setId(rs.getInt("MaxId"));
        }

    }

    public static void ustawDatyKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();

    }

}
