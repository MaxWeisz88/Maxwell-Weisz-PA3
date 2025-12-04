package main;

/**
 * Class representing an entry used by the HashMap class to hold a key-value pair. The key it holds
 * is a GraphNode object and the value is the index that the object is at in the MinHeap array. 
 * @author Maxwell Weisz
 * maxwellweisz@brandeis.edu
 * 12/4/2025
 * COSI 21A PA3
 */
public class Entry {
    private GraphNode key; 
    private int value;
    private int keysIndex;//Index of this key in the HashMap array tracking keys

    public Entry(GraphNode key, int value){
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the GraphNode that is the key of this Entry object. 
     * @return the GraphNode that is the key to this Entry
     */
    public GraphNode getKey(){
        return key;
    }

    /**
     * Gets the int that is the value of this Entry object, representing the index of this object
     * in the MinHeap array.
     * @return the int that is the value for this Entry
     */
    public int getValue(){
        return value;
    }

    /**
     * Sets this Entry object's value field to the int passed in the method. 
     * @param value value to change this Entry object's value to 
     */
    public void setValue(int value){
        this.value = value;
    }

    /**
     * Returns true if the Entry object passed to this method is equal to this Entry object, 
     * comparing the key and value to check for equality. 
     * @param entry
     * @return
     */
    public boolean equals(Entry entry){
        if(entry.value == this.value && entry.key.equals(this.key)){
            return true;
        }
        return false;
    }

    /**
     * Sets this Entry objects keysIndex value to the value passed.
     * @param keysIndex the index of this GraphNode in the HashMap keys array
     */
    public void setKeysIndex(int keysIndex){
        this.keysIndex = keysIndex;
    }

    /**
     * Returns the index of this Entry objects key in the HashMap keys array.
     * @return HashMap keys array index
     */
    public int getKeysIndex(){
        return keysIndex;
    }
}
