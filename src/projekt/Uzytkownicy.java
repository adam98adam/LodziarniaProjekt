package projekt;

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
}



