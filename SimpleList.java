package edu.utdallas.cs2336;

public interface SimpleList<T> {
    void set(int index, T value);
    T get(int index);
}

// class with Template T, implements the interface SimpleList<t>
class TwoElementList <T> implements SimpleList<T> {
    private final T[] elementList ; // final array type T 
    private int count ; // used to index 

    // constructor that initizlies the new Obejct or array 
    // sets count at 0 
    public TwoElementList () {
        elementList = (T[]) new Object [2] ;
        count = 0 ;
    }

    // overrides the original interface function 
    // checks if the index is in bounds, if not then throw an exceptions 
    // if not then add the value to that index 
    // also check for the index and update count so we can retrieve that value later 
    @Override 
    public void set (int index, T value) {
        if (index < 0 || index >= 2) {
            throw new IndexOutOfBoundsException("Out of Bounds") ;
        }
        elementList[index] = value ;
        if (index >= count) {
            count = index + 1 ;
        }
    }

    // overrides original in interface 
    // checks if the index is 0 or 1 , if it is then return the value at that index 
    // if not then throw an exception
    @Override 
    public T get (int index) {
        if (index == 0 || index == 1) {
            return elementList[index] ;
        }
        else {
            throw new IndexOutOfBoundsException("Out of Bounds") ;
        }
    }
}


