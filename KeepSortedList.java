package edu.utdallas.cs2336;

// imports to use lists 
import java.util.ArrayList;
import java.util.List;

public class KeepSortedList <T extends Comparable <T>> {
    private final List<T> valueList ; // creates a list named valueList with type T 

    // construtor 
    public KeepSortedList () {
        valueList = new ArrayList<>() ; // initializes the new ArrayList to hold values 
    }

    // uses a for loop to get the current number in the list 
    // compares that number to the value that is being passed 
    // uses compareTo method to see what number it returns 
    // if it is greater than 0 (means returned 1), then the current value in the list is greater than what is being passed in 
    // if that happens then add the newValue in the spot where the currentValue was 
    // return the void 
    public void add (T newValue) {
        for (int count = 0 ; count < valueList.size() ; count++ ) {
            T currentNumber = valueList.get(count) ;
            if (currentNumber.compareTo(newValue) > 0) {
                valueList.add(count , newValue) ;
                return ;
            }
        }
        valueList.add(newValue) ; // if the newValue is greater than all the values in the list , add to the end 
    }

    // takes in a List of T variables 
    // nested for loop inside a for loop 
    // outer for loop runs through the elements in the passed in list 
    // inner for loop checks if the currentElement in the list is greater than element from the passed list 
    // also has a flag to seeif an element is already in the list 
    public void add (List<T> newElements) {
        for (T newValue : newElements) {
            boolean isAdded = false ;
            for (int count = 0; count < valueList.size() ; count++) {
                T currentNumber = valueList.get(count) ;
                if (currentNumber.compareTo(newValue) > 0) {
                    valueList.add(count , newValue) ;
                    isAdded = true ;
                    break ;
                }
            }
            // if it is false then add the newValue to the end of the list 
            if (!isAdded) {
                valueList.add(newValue) ;
            }
        }
    }

    // simply returns the list
    public List<T> getBackingList () {
        return valueList ;
    }
}
