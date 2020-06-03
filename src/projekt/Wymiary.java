package projekt;

import java.awt.*;

public class Wymiary {
     private static int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
     private static int wys= Toolkit.getDefaultToolkit().getScreenSize().height;

     public static int getSzer() {
        return szer;
    }

    public static  int getWys() {
        return wys;
    }

}
