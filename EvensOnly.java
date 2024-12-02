package edu.utdallas.cs2336;

public class EvensOnly {
    private int value;

    // uses % to see if there is any remainder when dividing by 0, if there is then it is odd, throw OddException
    public EvensOnly (int integer) {
        if (integer % 2 == 0) {
            setValue (integer) ;
        }
        else {
            throw new OddException("This is an Odd Number.") ; // call it by passin a string message 
        }
    }

    public int getValue() {
        return value;
    }

    // created a setter for the value , takes an integer 
    // adds another even check to see what kind of number is being passed 
    // throws OddException if odd ( % 2 is not 0)
    public void setValue (int value) {
        if (value % 2 == 0)
        {
            this.value = value ;
        }
        else {
            throw new OddException("This is an Odd Number.") ;
        }
    }
}

// this exception receives a string message and passes it to the parent class 
class OddException extends NumberFormatException {
    public OddException (String string) {
        super(string) ;
    }
}