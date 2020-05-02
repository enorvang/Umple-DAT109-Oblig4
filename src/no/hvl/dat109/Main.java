package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int ANTALL_OYNE = 6;

    public static void main(String[] args){
        Terningkopp terningkopp = new Terningkopp(new Terning(ANTALL_OYNE), new Terning(ANTALL_OYNE));

        Craps craps = new Craps(terningkopp);
        craps.spill();


    }

}
