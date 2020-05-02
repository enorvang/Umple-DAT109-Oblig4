package no.hvl.dat109;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/



// line 2 "model.ump"
// line 61 "model.ump"
// line 66 "model.ump"
public class Craps
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Craps State Machines
    public enum State { spiller, vinn, tap }
    private State state;

    //Craps Associations
    private Terningkopp terningkopp;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Craps(Terningkopp aTerningkopp)
    {
        if (!setTerningkopp(aTerningkopp))
        {
            throw new RuntimeException("Unable to create Craps due to aTerningkopp. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        setState(State.spiller);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public String getStateFullName()
    {
        String answer = state.toString();
        return answer;
    }

    public State getState()
    {
        return state;
    }

    public boolean spill()
    {
        boolean wasEventProcessed = false;

        State aState = state;
        switch (aState)
        {
            case spiller:
                if (getTerningkopp().erSyv())
                {
                    setState(State.vinn);
                    wasEventProcessed = true;
                    break;
                }
                if (!(getTerningkopp().erSyv()))
                {
                    setState(State.tap);
                    wasEventProcessed = true;
                    break;
                }
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    private void setState(State aState)
    {
        state = aState;

        // entry actions and do activities
        switch(state)
        {
            case spiller:
                // line 7 "model.ump"
                getTerningkopp().trillTerninger();
                break;
            case vinn:
                // line 13 "model.ump"
                vinner();
                break;
            case tap:
                // line 16 "model.ump"
                taper();
                break;
        }
    }
    /* Code from template association_GetOne */
    public Terningkopp getTerningkopp()
    {
        return terningkopp;
    }
    /* Code from template association_SetUnidirectionalOne */
    public boolean setTerningkopp(Terningkopp aNewTerningkopp)
    {
        boolean wasSet = false;
        if (aNewTerningkopp != null)
        {
            terningkopp = aNewTerningkopp;
            wasSet = true;
        }
        return wasSet;
    }

    public void delete()
    {
        terningkopp = null;
    }


    /**
     * implementeres
     */
    // line 22 "model.ump"
    public void vinner(){
        System.out.println("Gratulerer, du vant!");
    }

    // line 25 "model.ump"
    public void taper(){
        System.out.println("Beklager, du tapte!");
    }

}



