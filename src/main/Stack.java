package main;

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

    public void push(String str){
        if(top == maxSize - 1){
            expandStack();
        }
        numElements++;
        stackArr[top++] = str;
    }

    private void expandStack(){
        String[] temp = stackArr;
        String[] largerStack = new String[maxSize*2];
        for(int i = 0; i < maxSize; i++){
            largerStack[i] = temp[i];
        }
        stackArr = largerStack;
        maxSize = maxSize * 2;
    }

    public boolean isEmpty(){
        if(numElements <= 0){
            return true;
        }
        return false;
    }

    public String pop(){
        if (numElements <= 0) {
            return "";
        }
        numElements--;
        return stackArr[--top];
    }

    public int getSize(){
        return numElements;
    }
}
