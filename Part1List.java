package edu.utdallas.cs2336;

/**
 * Interface for a singly-linked list
 * @param <T>
 */
public interface Part1List {
    void addToFront(Webpage newFirst); // done 
    void addToBack(Webpage newLast); // done 

    /**
     * Add an item at the specified index
     * @param newItem Item to add
     * @param index Index to add it
     */
    void addAt(Webpage newItem, final int index); // done 

    /**
     * Get the first node
     * @return The first node, or null if the list is empty
     */
    Webpage getFirst(); // done 

    /**
     * Get the last node
     * @return The last node, or null if the list is empty
     */
    Webpage getLast(); // done 

    /**
     * Get the size of the list
     * @return Size of the list
     */
    int getSize(); // done 

    /**
     * Get the node at this index
     * @param index Index to check
     * @return Node at that index
     */
    Webpage getAt(int index); // done 

    /**
     * Remove the first node
     * @return The removed node (if any)
     */
    Webpage removeFront(); // done 

    /**
     * Remove the last node
     * @return The removed node (if any)
     */
    Webpage removeBack(); // done 

    /**
     * Remove the node at this index
     * @param index The index to remove
     * @return The removed node
     */
    Webpage removeAt(int index); // done 
}

// linked list to make all functions 
class Part1ListImpl implements Part1List {
    // head , tail references and size incremator declared 
    protected Webpage head ;
    protected Webpage tail ;
    protected int size ;
    
    // constructor , head and tail is set to null and size is set to 0 
    Part1ListImpl () {
        this.head = null ;
        this.tail = null ;
        this.size = 0 ;
    }

    @Override 
    public void addToFront(Webpage newFirst) {
        Webpage newNode = new Webpage (newFirst) ; // creates a new node and sends to constructor the data  
        // if the list is empty , newFirst becomes the head and tail.
        if (head == null) {
            head = tail = newNode ;
        } else { // else add it to the front of the list 
            newNode.setRightNode(head) ; // points the reference to current head 
            head = newNode ; // makes the newNode the new head 
        }
        size ++ ; // increment size no matter what 
    }

    @Override 
    public void addToBack(Webpage newLast) {
        Webpage newNode = new Webpage (newLast) ; // creates new node 
        if (head == null) { // if the list is empty, make head and tail the newNode 
            head = tail = newNode ;
        } else { // else add to the back of the list 
            tail.setRightNode(newNode) ; // point the current tail to the new node 
            tail = newNode ; // make the new node the tail
        }
        size ++ ; // increment size no matter what 
    }

    @Override 
    public void addAt(Webpage newItem, final int index) {
        // if the index is a negative number or if it is greater than the linked list , throw the exception
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException() ;
        }
        // if the index is 0 , just call addToFront 
        if (index == 0) {
            addToFront(newItem) ;
            return ; // exit 
        }
        // if the index is equal to the size of the list , just call addToBack
        if (index == size) {
            addToBack(newItem);
            return ;
        }

        Webpage newNode = new Webpage (newItem) ; // creates newNode 
        Webpage current = head ; // to go through the list 
        // this for loop gets the node that is one position before the index we want to addAt
        for (int count = 0 ; count < index - 1 ; count++) {
            current = current.getRightNode() ;
        }
        Webpage nextNode = current.getRightNode();
        newNode.setRightNode(nextNode); // point the newNode to the previous node in that position
        current.setRightNode(newNode) ; // point the previous node to the newNode 
        size++ ; // increment 
    }

    @Override 
    public Webpage getFirst() {
        if (head == null) {
            return head ;
        }
        return head ; // return the data of the head, which is the first element in the list 
    }

    @Override 
    public Webpage getLast() {
        if (head == null) {
            return head ;
        }
        return tail ; // return the data of the tail , which is the last element in the list 
    }

    @Override 
    public int getSize() {
        return size ; // getter for the size of the list 
    }

    @Override
    public Webpage getAt(int index) {
        // error handling 
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException () ;
        }
        
        // to go over list, starting from the head  
        Webpage current = head ;
        // reiterate loop all the one to the index desired 
        // update current with the next node 
        for (int count = 0 ; count < index ; count++) {
            current = current.getRightNode() ;
        }
        return current ; // return the current node's data
    }

    @Override 
    public Webpage removeFront() {
        // if attempts to remove from an empty list
        if (head == null) {
            return head ;
        }
        // remove the head simply by making the next node the head 
        Webpage removedNode = head ;
        head = head.getRightNode() ;
        // if there is only one element in the list 
        if (head == null) {
            tail = null ;
        }
        size -- ; // decrement from list
        removedNode.setRightNode(null); // garbage collection
        return removedNode ;
    }

    @Override 
    public Webpage removeBack() {
        // if attempts to remove from an empty list
        if (head == null) {
            return head ;
        }
        Webpage removedNode = tail ;
        // if only one element in list 
        if (head == tail) {
            head = tail = null ;
        } else {
            Webpage current = head ; // to go over 
            while (current.getRightNode() != tail) { // goes to the node before the tail
                current = current.getRightNode() ;
            }
            tail = current ; // make the previous element the tail
            tail.setRightNode(null) ; // point the last element to null
        }
        size -- ;
        removedNode.setRightNode(null); // Help with garbage collection
        return removedNode ;
    }

    @Override 
    public Webpage removeAt(int index) {
        // error handling 
        if ((index < 0) || index >= size) {
            throw new IndexOutOfBoundsException() ;
        }
        // if index is 0 , just remove the front
        if (index == 0) {
            return removeFront() ;
        }
        // if index is at the end, just remove the end 
        if (index == size - 1) {
            return removeBack() ;
        }

        Webpage current = head ; // to go thru the list 
        for (int count = 0 ; count < index - 1 ; count++) { // get the node before the index desired 
            current = current.getRightNode() ;
        }
        Webpage removedNode = current.getRightNode() ; // get the removed node 
        current.setRightNode(removedNode.getRightNode()) ; // point to the node two spots over 
        // If the node after the removed node exists, update its leftNode pointer
        if (removedNode.getRightNode() != null) {
            removedNode.getRightNode().setLeftNode(current);
        }
        removedNode.setRightNode(null); // Help with garbage collection
        size -- ;
        return removedNode ;
    }
}

class Part2SavedLinks extends Part1ListImpl {

    @Override 
    public void addToFront(Webpage newFirst) {
        Webpage newNode = new Webpage (newFirst) ; // create the new node 
        newNode.setLeftNode(null); // set the newNode leftnode to null
        super.addToFront(newFirst); // call the original method to handle the rightnode

        // checks if the list is not empty 
        if (head != null && head != newNode) {
            head.setLeftNode(null); // set the head to null
            newNode.setRightNode(head); // the newnode is the newhead so point the rightnode to the old head 
        }
    }

    @Override 
    public void addToBack(Webpage newLast) {
        Webpage newNode = new Webpage (newLast) ; // newNode 
        newNode.setLeftNode(tail); // assign the newnode leftnode to the tail 
        super.addToBack(newLast); // call parent method to handle rightnode 

        // checks if the tail is not null
        if (tail != null) {
            tail.setLeftNode(newNode);  // if not null then set the tail leftnode to the newnode 
        }
    }

    @Override 
    public void addAt (Webpage newItem, final int index) {
        super.addAt(newItem, index); // call the parent class to handle the right node

        // transverse the list 
        Webpage current = head ;
        for (int count = 0 ; count < index - 1 ; count++) {
            current = current.getRightNode() ;
        }

        // assign the rightnodes 
        Webpage newNode = current.getRightNode();  
        Webpage nextNode = newNode.getRightNode(); 

        // assign the leftnode 
        newNode.setLeftNode(current);  
        if (nextNode != null) {
         nextNode.setLeftNode(newNode); 
        }
    }

    // all getters are the same as the parent class 
    @Override 
    public Webpage getFirst () {
        return super.getFirst() ; 
    }

    @Override 
    public Webpage getLast() {
        return super.getLast() ; 
    }

    @Override 
    public int getSize() {
        return super.getSize() ; 
    }

    @Override
    public Webpage getAt(int index) {
        return super.getAt(index) ;
    }

    // get the removed node from the parent method 
    @Override 
    public Webpage removeFront() {
        Webpage removedNode = super.removeFront();
        // if the list is not empty 
        if (head != null) {
            head.setLeftNode(null); // set the leftnode to null 
        }
        return removedNode ; // return the removed node 
    }

    @Override
    public Webpage removeBack() {
        Webpage removedNode = super.removeBack(); // call the parent method , handles right node 

        // checks null status 
        if (removedNode != null && tail != null) {
            removedNode.setLeftNode(null); // sets the removed node left node to null 

            // transverse 
            Webpage current = head;
            while (current != null && current.getRightNode() != tail) {
                current = current.getRightNode(); 
            }

            // if current isnt the last 
            if (current != null) {
                tail.setLeftNode(current); // set the tail left node to current 
            }
        }
        return removedNode; // returned the removed node 
    }

    @Override
    public Webpage removeAt(int index) {
        Webpage removedNode = super.removeAt(index); // call the parent method 
        // checks if removed node was removed correctly 
        if (removedNode != null) {
            Webpage leftNode = removedNode.getLeftNode(); // gets the prev node
            Webpage rightNode = removedNode.getRightNode(); // gets the next node 
            if (leftNode != null) {
                leftNode.setRightNode(rightNode);
            }
            if (rightNode != null) {
                rightNode.setLeftNode(leftNode);
            }
            // garbage collection 
            removedNode.setLeftNode(null);
            removedNode.setRightNode(null);
        }
        return removedNode; // return the removed node 
    }
} 