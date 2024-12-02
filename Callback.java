package edu.utdallas.cs2336;
import java.util.ArrayList ;
import java.util.List ;

public interface Callback {
    int callbackHappened();
}

// created Callbacker class 
class Callbacker {

    private final List <Callback> callBackList ; // created a list of Callback objects 

    // constructor , passing a Callback object 
    // also adds the object to the list 
    public Callbacker (Callback callBackObject) {
        callBackList = new ArrayList<>() ;
        callBackList.add(callBackObject) ;
    }

    // Method to add a Callback to the list
    public void addCallback(Callback callback) {
        callBackList.add(callback); // Adds the new callback to the list
    }

    // Method to remove a Callback from the list
    public void removeCallback(Callback callback) {
        callBackList.remove(callback); // Removes the specified callback from the list
    }
    // method to add up the sum of the callbacks 
    // keeps looping for every item in the callBackList 
    // returns the sum 
    public int doCallbacks () {
        int sum = 0 ;
        for (Callback callBack : callBackList) {
            sum += callBack.callbackHappened() ;
        }
        return sum ;
    }
}
