package test;
import main.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testHashMap {

    @Test
    public void testHashFunction(){
        HashMap testMap = new HashMap();
        GraphNode testNode = new GraphNode("3901DI9-DG23", false);
        Entry testEntry = new Entry(testNode, 1);
        testMap.set(testNode, 1);
        assertTrue(testEntry.equals(testMap.getEntry(testNode)));
    }


}