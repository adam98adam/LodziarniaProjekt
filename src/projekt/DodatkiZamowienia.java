package projekt;

import java.sql.SQLException;
import java.sql.Statement;

public class DodatkiZamowienia {
    private static  int idZamowienia,idDodatki;

    public static int getIdZamowienia() {
        return idZamowienia;
    }

    public static void setIdZamowienia(int idZamowienia1) {
        idZamowienia = idZamowienia1;
    }

    public static int getIdDodatki() {
        return idDodatki;
    }

    public static void setIdDodatki(int idDodatki1) {
        idDodatki = idDodatki1;
    }

    public static void usunDodatkiLacznikKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String idZamowienia = "SELECT idZamowienia FROM Zamowienia WHERE idOsoba = " + Osoby.getId();
        String usun = "DELETE FROM DodatkiZamowienia WHERE idZamowienia IN (" + idZamowienia + ")";
        stmt.executeUpdate(usun);
    }
}
