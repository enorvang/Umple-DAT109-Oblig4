package no.hvl.dat109;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/


import java.util.*;

// line 40 "model.ump"
// line 77 "model.ump"
public class Terningkopp
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Terningkopp Attributes
    private int terningSum;

    //Terningkopp Associations
    private List<Terning> ternings;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Terningkopp(Terning... allTernings)
    {
        terningSum = 0;
        ternings = new ArrayList<Terning>();
        boolean didAddTernings = setTernings(allTernings);
        if (!didAddTernings)
        {
            throw new RuntimeException("Unable to create Terningkopp, must have at least 1 ternings. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setTerningSum(int aTerningSum)
    {
        boolean wasSet = false;
        terningSum = aTerningSum;
        wasSet = true;
        return wasSet;
    }

    public int getTerningSum()
    {
        return terningSum;
    }
    /* Code from template association_GetMany */
    public Terning getTerning(int index)
    {
        Terning aTerning = ternings.get(index);
        return aTerning;
    }

    public List<Terning> getTernings()
    {
        List<Terning> newTernings = Collections.unmodifiableList(ternings);
        return newTernings;
    }

    public int numberOfTernings()
    {
        int number = ternings.size();
        return number;
    }

    public boolean hasTernings()
    {
        boolean has = ternings.size() > 0;
        return has;
    }

    public int indexOfTerning(Terning aTerning)
    {
        int index = ternings.indexOf(aTerning);
        return index;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfTernings()
    {
        return 1;
    }
    /* Code from template association_AddUnidirectionalMStar */
    public boolean addTerning(Terning aTerning)
    {
        boolean wasAdded = false;
        if (ternings.contains(aTerning)) { return false; }
        ternings.add(aTerning);
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeTerning(Terning aTerning)
    {
        boolean wasRemoved = false;
        if (!ternings.contains(aTerning))
        {
            return wasRemoved;
        }

        if (numberOfTernings() <= minimumNumberOfTernings())
        {
            return wasRemoved;
        }

        ternings.remove(aTerning);
        wasRemoved = true;
        return wasRemoved;
    }
    /* Code from template association_SetUnidirectionalMStar */
    public boolean setTernings(Terning... newTernings)
    {
        boolean wasSet = false;
        ArrayList<Terning> verifiedTernings = new ArrayList<Terning>();
        for (Terning aTerning : newTernings)
        {
            if (verifiedTernings.contains(aTerning))
            {
                continue;
            }
            verifiedTernings.add(aTerning);
        }

        if (verifiedTernings.size() != newTernings.length || verifiedTernings.size() < minimumNumberOfTernings())
        {
            return wasSet;
        }

        ternings.clear();
        ternings.addAll(verifiedTernings);
        wasSet = true;
        return wasSet;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addTerningAt(Terning aTerning, int index)
    {
        boolean wasAdded = false;
        if(addTerning(aTerning))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfTernings()) { index = numberOfTernings() - 1; }
            ternings.remove(aTerning);
            ternings.add(index, aTerning);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveTerningAt(Terning aTerning, int index)
    {
        boolean wasAdded = false;
        if(ternings.contains(aTerning))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfTernings()) { index = numberOfTernings() - 1; }
            ternings.remove(aTerning);
            ternings.add(index, aTerning);
            wasAdded = true;
        }
        else
        {
            wasAdded = addTerningAt(aTerning, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        ternings.clear();
    }


    /**
     * implementeres
     */
    // line 47 "model.ump"
    public boolean erSyv(){
        return terningSum == 7;
    }

    /**
     * implementeres
     */
    // line 53 "model.ump"
    public void trillTerninger(){
        terningSum = ternings.stream()
                .map(t -> t.trill())
                .reduce(0, (a, b) -> a+b);

        System.out.println("Sum av terninger: " + terningSum);

    }


    public String toString()
    {
        return super.toString() + "["+
                "terningSum" + ":" + getTerningSum()+ "]";
    }
}






