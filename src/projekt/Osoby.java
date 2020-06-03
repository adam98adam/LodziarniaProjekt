package projekt;

public class Osoby {
    static private int id,idUzytkownicy;
    static private String imie,nazwisko;
    static private char[] pesel,telefon = new char[11];


    static public int getId() {
        return id;
    }

    static public void setId(int id1) {
        id=id1;
    }

    static public int getIdUzytkownicy() {
        return idUzytkownicy;
    }

    static public void setIdUzytkownicy(int idUzytkownicy1) {
        idUzytkownicy = idUzytkownicy1;

    }

    static public String getImie() {
        return imie;
    }

    static public void setImie(String imie1) {
        imie = imie1;
    }

    static public String getNazwisko() {
        return  nazwisko;
    }

    static public void setNazwisko(String nazwisko1) {
        nazwisko = nazwisko1;
    }

    static public char[] getPesel() {
        return pesel;
    }

    static public void setPesel(char[] pesel1) {
        pesel = pesel1;
    }

    static public char[] getTelefon() {
        return telefon;
    }

    static public void setTelefon(char[] telefon1) {
        telefon = telefon1;
    }





}
