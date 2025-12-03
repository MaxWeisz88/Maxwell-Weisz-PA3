package main;
import java.io.FileWriter;
import java.io.BufferedWriter;

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
        while(answer.previousNode != null){
            pathStack.push(answer.previousDirection);
            answer = answer.previousNode;//need to make this write the answer in reverse
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

    public static void addDistances(GraphNode curr, Min_PriorityQueue queue){
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