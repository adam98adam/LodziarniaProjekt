package projekt;

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
}
