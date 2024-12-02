package edu.utdallas.cs2336;

public interface Part2ReadingList {

    /**
     * Add an element to the BACK of the list
     * @param element
     */
    void push(Webpage element);

    /**
     * Remoeve an element from the front of the list
     * @return
     */
    Webpage pop();

    /**
     * Get the size of the list
     * @return
     */
    int getSize();
}

class Part2ReadingListImpl extends Part1ListImpl implements Part2ReadingList {

    @Override 
    public void push(Webpage element) {
        addToBack(element);
    }

    @Override 
    public Webpage pop () {
        return removeFront() ;
    }

    @Override 
    public int getSize () {
        return super.getSize() ;
    }
}