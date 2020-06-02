package projekt;

public class Osoby {
    private int id;
    private int idUzytkownicy;
    private String imie;
    private String nazwisko;
    private char[] pesel = new char[11];
    private char[] telefon = new char [11];

    public int getId() {
        return id;
    }

    public void setId(int id1) {
        id=id1;
    }

    public int getIdUzytkownicy() {
        return idUzytkownicy;
    }

    public void setIdUzytkownicy(int idUzytkownicy1) {
        idUzytkownicy = idUzytkownicy1;

    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie1) {
        imie = imie1;
    }

    public String getNazwisko() {
        return  nazwisko;
    }

    public void setNazwisko(String nazwisko1) {
        nazwisko = nazwisko1;
    }

    public char[] getPesel() {
        return pesel;
    }

    public void setPesel(char[] pesel1) {
        pesel = pesel1;
    }

    public char[] getTelefon() {
        return telefon;
    }

    public void setTelefon(char[] telefon1) {
        telefon = telefon1;
    }



}
