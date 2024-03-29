package projekt;

import java.sql.SQLException;
import java.sql.Statement;

public class NapojeZamowienia {
    private static  int idZamowienia,idNapoje;

    public static int getIdZamowienia() {
        return idZamowienia;
    }

    public static void setIdZamowienia(int idZamowienia1) {
        idZamowienia = idZamowienia1;
    }

    public static int getIdNapoje() {
        return idNapoje;
    }

    public static void setIdNapoje(int idNapoje1) {
        idNapoje = idNapoje1;
    }

    public static void usunNapojeZamowieniaKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String idZamowienia = "SELECT idZamowienia FROM Zamowienia WHERE idOsoba = " + Osoby.getId();
        String usun = "DELETE FROM NapojeZamowienia WHERE idZamowienia IN (" + idZamowienia + ")";
        stmt.executeUpdate(usun);
    }

}
