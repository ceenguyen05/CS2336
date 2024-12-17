package edu.utdallas.cs2336;

public interface Part3SortedPreferences {

    /**
     * Get the root node
     * @return The root node; null if not available
     */
    Webpage getRoot(); // done 

    /**
     * Add a node in the proper position
     * NOTE: This needs to be added as a NEW node, not a simple assignment of the original node
     *
     * @param webpage Node to add
     */
    void add(Webpage webpage); // done 

    /**
     * Find the given value by a binary search of the tree
     * @param value The value to search for
     * @return The node with this value, or null if there is no such node
     */
    Webpage find(int value); // done 

    /**
     * Remove a node with that value, if found
     * @param value Integer to search for
     * @return The node, if found, with the tree re-configured without the missing node.
     */
    Webpage remove(int value); // done 
}

class Part3SortedPreferencesImpl implements Part3SortedPreferences {
    // given in the webpage class is left, right, and parent references 
    // start with the root 
    Webpage root ;

    // constructor , set root to null 
    public Part3SortedPreferencesImpl () {
        this.root = null ;
    }

    @Override 
    public Webpage getRoot () {
        // simply return the root 
        return root ;
    }

    @Override 
    public void add(Webpage webpage) {
        // webpage is the newNode for reference to the previous parts 
        // if the root is null, BST is empty , assign the newNode as the root 
        if (root == null) {
            root = webpage ;
            return ;
        }

        // use recursion to find the correct place to add the newNode 
        // start with the root 
        addHelper(root , webpage) ;

    }

    // helper method for add 
    private void addHelper (Webpage node , Webpage webpage) {
        // check the value of the current node to the newNode 
        if (webpage.getID() < node.getID()) {
            // if the left reference is null, add here 
            // set node left to webpage 
            // set webpage parent to node 
            if (node.getLeftNode() == null) {
                node.setLeftNode(webpage);
                webpage.setParentNode(node);
            // else recurse until it hits null 
            } else {
                addHelper(node.getLeftNode() , webpage) ;
            }
        // means the value is greater than the current node 
        } else {
            // if the right reference is null, spot has been found to add 
            // set node right to webpage 
            // set webpage parent to node 
            if (node.getRightNode() == null) {
                node.setRightNode(webpage);
                webpage.setParentNode(node);
            // else recurse until null has been reached 
            } else {
                addHelper (node.getRightNode() , webpage) ;
            }
        }
    }

    @Override 
    public Webpage find(int value) {
        // check if the BST is empty 
        if (root == null) {
            return root ;
        }

        // check if the root is the value 
        if (value == root.getID()) {
            return root ;
        }
        
        // call recursive method to locate that node if any
        return  findHelper(value , root) ;
    }

    private Webpage findHelper (int value , Webpage node) {
        // base case , if the current node is equal to value, return that node 
        if (node.getID() == value) {
            return node ;
        }
        // if the value is less than the current node 
        if (value < node.getID()) {
            // if the left node is not null , keep recursing 
            if (node.getLeftNode() != null) {
                return findHelper (value , node.getLeftNode()) ;
            // if it is null then value isnt found , return null 
            } else {
                return null ;
            }
        // means value is greater than the current node 
        } else {
            // if the right node is not null, keep recursing 
            if (node.getRightNode() != null) {
                return findHelper(value, node.getRightNode()) ;
            // if it is null, value is not found, returns null 
            } else {
                return null ;
            }
        }
    }

    @Override 
    public Webpage remove(int value) {
        // create a node to hold the return value of the recursive method 
        Webpage removedNode = removeHelper(value, root, null);
        return removedNode;
    }
    

    private Webpage removeHelper(int value , Webpage node , Webpage parent) {
        // base case , if root is null or value not found, return null 
        if (node == null) {
            return null ;
        }

        // set parent node 
        node.setParentNode(parent);

        // search for the node recursivly 
        // value is left so keep searching the left references
        if (value < node.getID()) {
            return removeHelper(value, node.getLeftNode(), node);
        // value is greater so keep searching the right references 
        } else if (value > node.getID()) {
            return removeHelper(value, node.getRightNode(), node);
        // value has been found
        } else {
            // set the childstatus of the node 
            ChildStatus child = node.getChildStatus() ;
            // handle all three cases 
            switch (child) {
                // no children 
                case NONE :
                    // if parent is not null 
                    // update parent references 
                    if (parent != null) {
                        // if the removed node is the left 
                        if (parent.getLeftNode() == node) {
                            parent.setLeftNode(null);
                        // if the removed node is the right 
                        } else {
                            parent.setRightNode(null);
                        }
                    }
                    // garbage collection 
                    node.setParentNode(null);
                    // return the node that was removed 
                    return node ;
                // 1 left node 
                case LEFT_ONLY :
                    // if parent isnt null 
                    if (parent != null) {
                        // if the removed node is the left of its parent 
                        // set the parent left node to the left child 
                        if (parent.getLeftNode() == node) {
                            parent.setLeftNode(node.getLeftNode());
                        // if the removed node is the right of its parent
                        // set the parent right node to the left child 
                        } else {
                            parent.setRightNode(node.getLeftNode());
                        }
                    }

                    // update left child to parent 
                    node.getLeftNode().setParentNode(parent);

                    // garbage collection 
                    node.setParentNode(null);
                    node.setLeftNode(null);
                    // return the removed node 
                    return node ;
                // 1 right node 
                case RIGHT_ONLY :
                    // if parent isnt null 
                    if (parent != null) {
                        // if the removed node is the left of its parent 
                        // set the parent left node to the right child 
                        if (parent.getLeftNode() == node) {
                            parent.setLeftNode(node.getRightNode());
                        // if the removed node is the right of its parent
                        // set the parent right node to the right child 
                        } else {
                            parent.setRightNode(node.getRightNode());
                        }
                    }

                    // update its child to parent     
                    node.getRightNode().setParentNode(parent);
                    // garbage collection 
                    node.setParentNode(null);
                    node.setRightNode(null);
                    // return the removed node 
                    return node ;
                // both children 
                case BOTH :
                    // call recursive method to find the right subtree leftest node 
                    Webpage replacement = findLeast(node.getRightNode());

                    // copy the replacement node links to the current links in the BST 
                    // first is for the root 
                    if (parent == null) { 
                        root = replacement;
                    // next if the node is the left, set the parent left to replacement 
                    } else if (parent.getLeftNode() == node) {
                        parent.setLeftNode(replacement);
                    // if the node is the parent right , set the parent right to replacement 
                    } else {
                        parent.setRightNode(replacement);
                    }

                    // remove the replacement node from its OG spot in the BST
                    removeHelper(replacement.getID(), node.getRightNode(), node);

                    // update replacements nodes links to show its new spot in the BST
                    replacement.setParentNode(parent);
                    replacement.setLeftNode(node.getLeftNode());
                    replacement.setRightNode(node.getRightNode());

                    // update the children pointers 
                    // left child 
                    replacement.getLeftNode().setParentNode(replacement);
                    // right child
                    replacement.getRightNode().setParentNode(replacement);

                    // garbage collection 
                    node.setParentNode(null);
                    node.setLeftNode(null);
                    node.setRightNode(null);
                    // return the removed node 
                    return node ;
            }
        }
        // return the removed node 
        return node ;
    }

    // helper to find the far left nodeto replace 
    // parameter is the right subtree of the found node 
    private Webpage findLeast (Webpage node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode() ;
        }
        return node ;
    }
}
