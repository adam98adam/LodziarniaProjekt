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

    public static boolean sprawdzPeselTelefon(String p,String t) throws SQLException {
        int liczba = 0;

        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT COUNT (*) AS 'Liczba' FROM Osoby WHERE pesel = '" + p + "' OR telefon = '" + t + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            liczba = rs.getInt("Liczba");
        }

        if((liczba == 0) || (p.equals(String.valueOf(getPesel())) && t.equals(String.valueOf(getTelefon()))))
            return true;
        else
            return  false;

    }

    public static boolean sprawdzPeselTelefonAdministrator(String p,String t) throws SQLException {
        int liczba = 0;

        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT COUNT (*) AS 'Liczba' FROM Osoby WHERE pesel = '" + p + "' OR telefon = '" + t + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            liczba = rs.getInt("Liczba");
        }

        if((liczba == 0))
            return true;
        else
            return  false;

    }

    public static void nowaOsoba(String imie,String nazwisko,String pesel,String telefon) throws SQLException {
        int maxId=Uzytkownicy.maxId();
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "INSERT INTO Osoby VALUES (" + maxId + ",'" + imie + "','" + nazwisko + "','" + pesel + "','" + telefon + "')";
        stmt.executeUpdate(sql);
    }

    public static void zmienOsobe(String i,String n,String p,String t) throws SQLException {
        String imie = i;
        String nazwisko = n;
        String pesel = p;
        String telefon = t;
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "UPDATE Osoby SET imie = '" + imie + "',nazwisko = '" + nazwisko + "',pesel = '" + pesel + "',telefon = '" + telefon + "' WHERE pesel = '" + String.valueOf(getPesel()) + "'";
        stmt.executeUpdate(sql);
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel.toCharArray());
        setTelefon(telefon.toCharArray());

    }

    public static void usunOsobeKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String usun = "DELETE FROM Osoby WHERE idOsoby = " + Osoby.getId();
        stmt.executeUpdate(usun);
    }

}
