package main;

/**
 * Simple Min_PriorityQueue class using the MinHeap class to build a priority queue with the least
 * distance at the front of the queue. Supports inserting elements into the queue, changing elements
 * priority values, deleting elements, getting the top of the queue elements, etc. 
 */
public class Min_PriorityQueue {
    private static final int DEFAULT_SIZE = 11;
    private int numElements;
    private MinHeap queue;

    public Min_PriorityQueue(){
        queue = new MinHeap(DEFAULT_SIZE);
        numElements = 0;
    }

    public Min_PriorityQueue(int size){
        queue = new MinHeap(size);
        numElements = 0;
    }

    /**
     * Uses the MinHeap insert method to insert a GraphNode object into the heap to build a the 
     * queue.
     * @param g the GraphNode being added to the queue
     */
    public void insert(GraphNode g){
        queue.insert(g);
        numElements++;
    }

    /**
     * Uses the MinHeap decreaseKey method to decrease the priority value of the GraphNode passed
     * within the heap. 
     * @param g GraphNode to decrease the priority of
     * @param newPriority the new Priority to change it to
     */
    public void decreasePriority(GraphNode g, int newPriority){
        queue.heapDecreaseKey(g, newPriority);
    }

    /**
     * Pulls the element on the top of the heap if it exists, this GraphNode will have the lowest
     * priority field. Then deletes the element from the queue and decreases the size of the queue.
     * @return the GraphNode at the top of the heap
     */
    public GraphNode pullHighestPriorityElement(){
        if(numElements == 0){
            return null;
        }
        GraphNode min = queue.getMin();
        queue.deleteMin();
        numElements--;
        return min;
    }

    /**
     * Calls the heapify method on the GraphNode passed to it to rebalance the minheap property at
     * that GraphNodes position in the heap. 
     * @param g GraphNode that needs to be rebalanced at 
     */
    public void rebalance(GraphNode g){
        queue.heapify(g);
    }

    /**
     * Returns true if this queue has the GraphNode passed 
     * @param g GraphNode to check if in the queue
     * @return true if in the queue, false otherwise
     */
    public boolean hasKey(GraphNode g){
        return queue.hasNode(g);
    }

    /**
     * Returns true if this queue is empty and false if not.
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty(){
        if(numElements > 0){
            return false;
        }
        return true;
    }

    /**
     * Returns the current number of elements in the queue.
     * @return current number of elements in queue
     */
    public int numElements(){
        return numElements;
    }
}