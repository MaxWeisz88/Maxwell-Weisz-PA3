package main;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Main method using the PriorityQueue that combines all the data structures to build a priority
 * queue that gives priority to the GraphNodes with the shortest distance. Finds the shortest path
 * to the target GraphNode, and then prints out the order of directions taken using a stack thats
 * built from the answer GraphNode.
 * Known Bugs: None
 * @author Maxwell Weisz
 * maxwellweisz@brandeis.edu
 * 12/4/2025
 * COSI 21A PA3
 */
public class FindMinPath {
    public static void main(String[] args) {
        Min_PriorityQueue queue = new Min_PriorityQueue();
        GraphWrapper gw = new GraphWrapper();
        GraphNode home = gw.getHome();
        home.priority = 0;
        boolean foundHome = false;
        GraphNode answer = new GraphNode(null, foundHome);
        queue.insert(home);
        while(!queue.isEmpty() && !foundHome){
            GraphNode curr = queue.pullHighestPriorityElement();
            if(curr.isGoalNode()){
                answer = curr;
                foundHome = true;
            } else{
                addDistances(curr, queue);
            }
        }
        
        Stack pathStack = new Stack();
        String path = "";
        if(!foundHome){
            pathStack.push("No path found");
        }
        while(answer.previousNode != null){
            pathStack.push(answer.previousDirection);
            answer = answer.previousNode;
        }
        if(!pathStack.isEmpty()){
            path += pathStack.pop();
        }
        while(!pathStack.isEmpty()){
            path += "\n" + pathStack.pop();
        }
        String outputFilepath = "src/main/answer.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilepath));
            bw.write(path);
            bw.close();
        } catch (Exception e) {
            System.out.println("Failed to write path: " + e.getMessage());
        }
    }

    /**
     * Helper method to add/change the distances from the different GraphNodes this node is 
     * connected to and add them to the queue if they are not already in the queue. 
     * @param curr the current GraphNode to check the distances of connected nodes
     * @param queue the queue that is being added to/having priorities changed
     */
    private static void addDistances(GraphNode curr, Min_PriorityQueue queue){
        if(curr.hasEast()){
            GraphNode east = curr.getEast();
            int dist = curr.priority + curr.getEastWeight();
            if(!queue.hasKey(east)){
                east.priority = dist;
                east.previousNode = curr;
                east.previousDirection = "East";
                queue.insert(east);
            } else{
                if(dist < east.priority){
                    east.priority = dist;
                    queue.rebalance(east);
                    east.previousNode = curr;
                    east.previousDirection = "East";
                }
            }
        }
        if(curr.hasNorth()){
            GraphNode north = curr.getNorth();
            int dist = curr.priority + curr.getNorthWeight();
            if(!queue.hasKey(north)){
                north.priority = dist;
                north.previousNode = curr;
                north.previousDirection = "North";
                queue.insert(north);
            } else{
                if(dist < north.priority){
                    north.priority = dist;
                    queue.rebalance(north);
                    north.previousNode = curr;
                    north.previousDirection = "North";
                }
            }
        }
        if(curr.hasSouth()){
            GraphNode south = curr.getSouth();
            int dist = curr.priority + curr.getSouthWeight();
            if(!queue.hasKey(south)){
                south.priority = dist;
                south.previousNode = curr;
                south.previousDirection = "South";
                queue.insert(south);
            } else{
                if(dist < south.priority){
                    south.priority = dist;
                    queue.rebalance(south);
                    south.previousNode = curr;
                    south.previousDirection = "South";
                }
            }
        }
        if(curr.hasWest()){
            GraphNode west = curr.getWest();
            int dist = curr.priority + curr.getWestWeight();
            if(!queue.hasKey(west)){
                west.priority = dist;
                west.previousNode = curr;
                west.previousDirection = "West";
                queue.insert(west);
            } else{
                if(dist < west.priority){
                    west.priority = dist;
                    queue.rebalance(west);
                    west.previousNode = curr;
                    west.previousDirection = "West";
                }
            }
        }
    }

   
    
}