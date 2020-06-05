package projekt;

import java.sql.SQLException;
import java.sql.Statement;

public class Lacznik {
    private static int id,idZamowienia,idCennik,idLody;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static int getIdZamowienia() {
        return idZamowienia;
    }

    public static void setIdZamowienia(int idZamowienia1) {
        idZamowienia = idZamowienia1;
    }

    public static int getIdCennik() {
        return idCennik;
    }

    public static void setIdCennik(int idCennik1) {
        idCennik = idCennik1;
    }

    public static int getIdLody() {
        return idLody;
    }

    public static void setIdLody(int idLody1) {
        idLody = idLody1;
    }

    public static void usunZamowieniaLacznikKlient() throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String idZamowienia = "SELECT idZamowienia FROM Zamowienia WHERE idOsoba = " + Osoby.getId();
        String usun = "DELETE FROM Lacznik WHERE idZamowienia IN (" + idZamowienia + ")";
        stmt.executeUpdate(usun);
    }
}
