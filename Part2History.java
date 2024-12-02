package edu.utdallas.cs2336;

public interface Part2History {
    /**
     * Add an element to the FRONT of the list
     * @param element
     */
    void push(Webpage element);

    /**
     * Remove an element from the front of the list
     * @return
     */
    Webpage pop();

    /**
     * Get the size of the list
     * @return
     */
    int getSize();
}

class Part2HistoryImpl extends Part1ListImpl implements Part2History {

    @Override 
    public void push(Webpage element) {
        addToFront(element);
    }

    @Override 
    public Webpage pop() {
        return removeFront() ;
    }

    @Override
    public int getSize() {
        return super.getSize() ;
    }
}