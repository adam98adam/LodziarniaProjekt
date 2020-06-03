package projekt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Uzytkownicy  {
    static private int id;
    static private String konto = "", haslo = "";
    static private boolean administrator;


    static public int getId() {
        return id;
    }

    static public void setId(int id1) {
        id = id1;
    }

    static public String getKonto() {
        return konto;
    }

    static public void setKonto(String konto1) {
        konto = konto1;
    }

    static public String getHaslo() {
        return haslo;
    }

    static public void setHaslo(String haslo1) {
        haslo = haslo1;

    }

    static public boolean getAdministrator() {
        return administrator;
    }

    static public void setAdministrator(boolean administrator1) {
        administrator = administrator1;
    }

    static public ResultSet sprawdzUzytkownika(Statement stmt) throws SQLException {
        String sql = "SELECT CASE WHEN Administrator = 0 THEN 'False' ELSE 'True' END AS Administrator FROM Uzytkownicy WHERE Konto = '" + konto + "' AND Haslo = '" + haslo + "'";
        return stmt.executeQuery(sql);
    }

    static public void ustawUzytkownika(Statement stmt) throws SQLException {
        String sql = "SELECT idUzytkownicy,CASE WHEN Administrator = 0 THEN 'False' ELSE 'True' END AS Administrator FROM Uzytkownicy WHERE Konto = '" + konto + "' AND Haslo = '" + haslo + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            id = rs.getInt("idUzytkownicy");
            administrator = Boolean.parseBoolean(rs.getString("Administrator"));
        }
    }

}



