package no.hvl.dat109;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/


import java.util.Random;

// line 30 "model.ump"
// line 72 "model.ump"
public class Terning
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Terning Attributes
    private int antallOyne;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Terning(int aAntallOyne)
    {
        antallOyne = aAntallOyne;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setAntallOyne(int aAntallOyne)
    {
        boolean wasSet = false;
        antallOyne = aAntallOyne;
        wasSet = true;
        return wasSet;
    }

    public int getAntallOyne()
    {
        return antallOyne;
    }

    public void delete()
    {}


    /**
     * implementeres
     */
    // line 35 "model.ump"
    public int trill(){
        Random random = new Random();
        return random.nextInt(antallOyne) + 1;
    }


    public String toString()
    {
        return super.toString() + "["+
                "antallOyne" + ":" + getAntallOyne()+ "]";
    }
}
