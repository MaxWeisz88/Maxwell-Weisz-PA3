package main;

/**
 * Basic Stack class for Strings to help FindMinPath print out the order of directions correctly. 
 * @author Maxwell Weisz
 * maxwellweisz@brandeis.edu
 * 12/4/2025
 * COSI 21A PA3
 */
public class Stack {
    private int maxSize;
    private String[] stackArr;
    private int top;
    private int numElements;
    private static final int DEFAULT_SIZE = 16;

    public Stack(){
        stackArr = new String[DEFAULT_SIZE];
        top = 0;
        maxSize = 16;
        numElements = 0;
    }

    public Stack(int size){
        stackArr = new String[size];
        top = 0;
        maxSize = size;
        numElements = 0;
    }

    /**
     * Checks first if adding another element will cause Stack Overflow and if so expands the stack.
     * Then adds the element to the top of the stack and increases the top value.
     * @param str String being added to the stack
     */
    public void push(String str){
        if(top == maxSize - 1){
            expandStack();
        }
        numElements++;
        stackArr[top++] = str;
    }

    /**
     * Helper method to make the stack double the size if it needs to be expanded. 
     */
    private void expandStack(){
        String[] temp = stackArr;
        String[] largerStack = new String[maxSize*2];
        for(int i = 0; i < maxSize; i++){
            largerStack[i] = temp[i];
        }
        stackArr = largerStack;
        maxSize = maxSize * 2;
    }

    /**
     * Returns true if there are no elements in this stack. 
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty(){
        if(numElements <= 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the String at the top of the stack and decrements the top and numElements. 
     * @return the String at the top of this stack
     */
    public String pop(){
        if (numElements <= 0) {
            return "";
        }
        numElements--;
        return stackArr[--top];
    }

    /**
     * Returns the size of the stack, the current number of elements in this stack.
     * @return current size of the stack
     */
    public int getSize(){
        return numElements;
    }
}
