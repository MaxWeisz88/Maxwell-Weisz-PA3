package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    }
}
