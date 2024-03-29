package projekt;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lody {
    private static int id;
    private static String smak;
    private static float pojemnosc_L;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static String getSmak() {
        return smak;
    }

    public static void setSmak(String smak1) {
        smak = smak1;
    }

    public static float getPojemnosc_L() {
        return pojemnosc_L;
    }

    public static void setPojemnosc_L(float pojemnosc_L1) {
        pojemnosc_L = pojemnosc_L1;
    }

    public static void pobierzSmaki(JComboBox j) throws SQLException {
        Statement stmt = Polaczenie.getPolacz().createStatement();
        String sql = "SELECT smak FROM Lody";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            j.addItem(rs.getString("smak"));
        }
    }
}
