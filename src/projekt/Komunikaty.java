package projekt;

import javax.swing.*;

public class Komunikaty {


    public static void bladPolaczenia() {
        JFrame komunikat = new JFrame();
        JOptionPane.showMessageDialog(komunikat,"Brak polaczenia z baza danych","Blad",JOptionPane.ERROR_MESSAGE);

    }

    public static void kryteriaUzytkownik() {
        JFrame komunikat = new JFrame();
        JOptionPane.showMessageDialog(komunikat, "Login lub haslo nie spelniaja kryteriow :(" + "\nWskazowka : Login i haslo musi zawierac wiecej niz 4 znaki i max 20", "Komunikat", JOptionPane.WARNING_MESSAGE);
    }

    public static void istniejeUzytkownik() {
        JFrame komunikat = new JFrame();
        JOptionPane.showMessageDialog(komunikat, "Istnieje osoba o takim logine, przykro mi :(", "Komunikat", JOptionPane.WARNING_MESSAGE);

    }

}
