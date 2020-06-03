package projekt;

public class Zamowienia {
    private static int id,idOsoba;
    private static String data_zamowienia,data_dostarczenia;

    public static int getId() {
        return id;
    }

    public static void setId(int id1) {
        id = id1;
    }

    public static int getIdOsoba() {
        return idOsoba;
    }

    private static void setIdOsoba(int idOsoba1) {
        idOsoba = idOsoba1;
    }

    private static String getData_zamowienia() {
        return data_zamowienia;
    }

    private static void setData_zamowienia(String data_zamowienia1) {
        data_zamowienia = data_zamowienia1;
    }

    private static  String getData_dostarczenia() {
        return  data_dostarczenia;
    }

    private static void setData_dostarczenia(String data_dostarczenia1) {
        data_dostarczenia = data_dostarczenia1;
    }
}
