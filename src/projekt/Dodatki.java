package projekt;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dodatki {
    private static   int id;
    private static String nazwa;
    private static float cena;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static String getNazwa() {
        return nazwa;
    }

    public static void setNazwa(String nazwa1) {
        nazwa = nazwa1;
    }

    public static float getCena() {
        return cena;
    }

    public static void setCena(float cena1) {
        cena = cena1;
    }

    public static void pobierzDodatki(JComboBox j) throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT nazwa FROM Dodatki";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            j.addItem(rs.getString("nazwa"));
        }
        j.addItem("Brak");
    }
}


