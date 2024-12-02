package edu.utdallas.cs2336;

public enum Units {
    INCHES,
    CENTEMETERS;

    public static final double CM_PER_INCH = 2.54;
    public static final double INCH_PER_CM = 1 / 2.54;
}

 class ShirtMeasurements {

    // private member variables 
    private  final Units units ;
    private  int neck ;
    private  int arm ;
    private  int chest ;

    // constructor , initializes variables 
    public ShirtMeasurements(Units units , int neck , int arm , int chest) {
        this.units = units ;
        this.neck =  neck ;
        this.arm = arm ;
        this.chest = chest ;
    }

    // getter for units 
    public Units getUnits () {
        return units ;
    }

    // setter for neck 
    public void setNeck (int neck) {
        this.neck = neck ;
    }

    // getter for neck 
    public int getNeck () {
        return neck ;
    }

    // setter for arm 
    public void setArms (int arm){
        this.arm = arm ;
    }

      // getter for arm
      public int getArms () {
        return arm ;
    }

    // setter for chest 
    public void setChest (int chest) {
        this.chest = chest ;
    }

      // getter for chest
      public int getChest () {
        return chest ;
    }

    // get the converted measurement for the neck 
    public double getNeck(Units requested) {
        return convert(neck, requested);
    }
    // get the converted measurement for the arm 
    public double getArms(Units requested) {
        return convert (arm , requested);
    }
    // get the converted measurement for the chest 
    public double getChest(Units requested) {
        return convert(chest, requested);
    }
    // adds up the measurements and returns 
    public int combined () {
        return neck + arm + chest ;
    }

    // helper method to convert to either inches or cm 
    // returns the converted measurement 
    private double convert (int measurement , Units requested ) {
        if (units == requested) // if the requested units is the correct unit, no need to do anything 
        {
            return measurement ;
        }
        else if (units == Units.INCHES && requested == Units.CENTEMETERS)  // if it is cm , turn to cm from in 
        {
            return measurement * Units.CM_PER_INCH;

        } 
        else // if it is in , turn in from cm (this is the only option left after the if and else if )
        {
            return measurement * Units.INCH_PER_CM;
        }
    }
}
