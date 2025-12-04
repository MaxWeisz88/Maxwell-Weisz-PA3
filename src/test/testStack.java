package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Stack;

public class testStack {
    @Test
    public void testPush(){
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals(stack.getSize(), 5);
    }

    @Test
    public void testPop(){
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals(stack.pop(), "E");
        assertEquals(stack.pop(), "D");
        assertEquals(stack.pop(), "C");
        assertEquals(stack.pop(), "B");
        assertEquals(stack.pop(), "A");
        assertEquals(stack.getSize(), 0);
        assertEquals(stack.pop(), "");//Empty stack just returns empty brackets
        assertEquals(stack.getSize(), 0);//Empty stack so doesn't decrease size
    }

    @Test 
    public void testExpandStack(){
        Stack stack = new Stack(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");//expands once
        stack.push("E");
        assertEquals(stack.getSize(), 5);
        stack.push("F");
        stack.push("G");//expands again
        assertEquals(stack.getSize(), 7);
        assertEquals(stack.pop(), "G");
        assertEquals(stack.pop(), "F");
        assertEquals(stack.pop(), "E");
        assertEquals(stack.pop(), "D");
        assertEquals(stack.pop(), "C");
        assertEquals(stack.pop(), "B");
        assertEquals(stack.pop(), "A");
        //should still keep the correct ordering after expanding
    }
}
