package projekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Osoby {
    private static  int id,idUzytkownicy;
    private static String imie,nazwisko;
    private static char[] pesel,telefon = new char[11];


    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id=id1;
    }

    public static int getIdUzytkownicy() {
        return idUzytkownicy;
    }

    public static void setIdUzytkownicy(int idUzytkownicy1) {
        idUzytkownicy = idUzytkownicy1;

    }

    public static  String getImie() {
        return imie;
    }

    public static void setImie(String imie1) {
        imie = imie1;
    }

    public static String getNazwisko() {
        return  nazwisko;
    }

    public static void setNazwisko(String nazwisko1) {
        nazwisko = nazwisko1;
    }

    public static char[] getPesel() {
        return pesel;
    }

    public static void setPesel(char[] pesel1) {
        pesel = pesel1;
    }

    public static char[] getTelefon() {
        return telefon;
    }

    public static void setTelefon(char[] telefon1) {
        telefon = telefon1;
    }

    public static void ustawOsobe(Statement stmt) throws SQLException {
            String sql = "SELECT O.idOsoby,O.imie,O.nazwisko,O.pesel,O.telefon FROM Osoby O WHERE O.idUzytkownicy = " + Uzytkownicy.getId();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt("idOsoby");
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                pesel = rs.getString("pesel").toCharArray();
                telefon = rs.getString("telefon").toCharArray();
            }

    }

}
