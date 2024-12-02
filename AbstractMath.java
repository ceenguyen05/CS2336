package edu.utdallas.cs2336;

public abstract class AbstractMath {
    protected int runningTotal;

    public AbstractMath(int initialValue) {
        runningTotal = initialValue;
    }

    public int incrementBy(int value) {
        runningTotal += value;
        return runningTotal;
    }

    public abstract int decrementBy(int value);

    public abstract int multiplyBy(int value);

    public abstract int toThisPower(int value);

    public abstract boolean greaterThan(AbstractMath other);

    public abstract boolean lessThan(AbstractMath other);
}

// class to override the abstract framework 
// extends the Abstract class 
class ConcreteMath extends AbstractMath {

    // defualt constructor 
    public ConcreteMath () {
        super(0) ;// super used to get method from abstract class 
    }
    // second constrcutor to get the initial value 
    public ConcreteMath (int initialValue) {
        super(initialValue) ;
    }
    // overrided methid 
    @Override 
    public int decrementBy (int value) {
        return runningTotal -= value ; // subtracts from the runningtotal 
    }
    // overrided method 
    @Override 
    public int multiplyBy(int value) {
        runningTotal = runningTotal * value ;
        return runningTotal ; // updates runningtotal by multiplying 
    }
    // overrided method 
    @Override 
    public int toThisPower(int value) {

        double result = Math.pow (runningTotal , value) ; // makes the runningtotal get to the power of value 
        return (int) result ; // casts an int
    }
    // overrided method 
    @Override 
    public boolean greaterThan(AbstractMath other) {
        return this.runningTotal > other.runningTotal ; // true if it is greater 
    }
    // overrided method 
    @Override 
    public boolean lessThan(AbstractMath other) {
       return this.runningTotal < other.runningTotal ; // true if it is smaller 
    }
    // overrided the Object class 
    @Override 
    public boolean equals (Object obj) {
        if (this == obj) {
            return true; // true if this is the same as obj 
        }
        if (!(obj instanceof AbstractMath)) {
            return false; // false if it is an instance of AbtractMath
        }
        AbstractMath other = (AbstractMath) obj; // sets value

        return this.runningTotal == other.runningTotal; // returns true if they are the same 
    }

    // hashcode ? vscode generated it , said i needed 
    @Override
    public int hashCode() {
        return Integer.hashCode(runningTotal);
    }
}