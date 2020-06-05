package projekt;

import javax.swing.*;
import java.sql.*;

public class Cennik {
    private static int id;
    private static float pojemnosc_ml,cena;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static  float getPojemnosc_ml() {
        return pojemnosc_ml;
    }

    public static void setPojemnosc_ml(float pojemnosc_ml1) {
        pojemnosc_ml = pojemnosc_ml1;
    }

    public static float getCena() {
        return cena;
    }

    public static void setCena(float cena1) {
        cena = cena1;
    }

    public static void pobierzPojemnosci(JComboBox j) throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String s = "SELECT pojemnosc_ml FROM Cennik";
        ResultSet rs = stmt.executeQuery(s);
        while (rs.next()){
            j.addItem(rs.getString("pojemnosc_ml"));
        }
    }
}

