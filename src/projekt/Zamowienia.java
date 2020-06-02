package projekt;

public class Zamowienia {
    private int id;
    private int idOsoba;
    private String data_zamowienia;
    private String data_dostarczenia;

    public int getId() {
        return id;
    }

    public void setId(int id1) {
        id = id1;
    }

    public int getIdOsoba() {
        return idOsoba;
    }

    private void setIdOsoba(int idOsoba1) {
        idOsoba = idOsoba1;
    }

    private String getData_zamowienia() {
        return data_zamowienia;
    }

    private void setData_zamowienia(String data_zamowienia1) {
        data_zamowienia = data_zamowienia1;
    }

    private String getData_dostarczenia() {
        return  data_dostarczenia;
    }

    private void setData_dostarczenia(String data_dostarczenia1) {
        data_dostarczenia = data_dostarczenia1;
    }
}
