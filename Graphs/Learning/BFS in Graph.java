import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        // Write your code here
        Queue<Integer> verticeQueue = new LinkedList<>();

        int visited[] = new int[n + 1];
        List<Integer> bfs = new ArrayList<>();

        // Push the root node into the queue and mark it as visited
        verticeQueue.add(0);
        // Mark 0th node as visited.
        visited[0] = 1;
        // Taking out and processing all the nodes and their neighbors in the queue
        // while it is not empty
        while (verticeQueue.size() > 0) {
            // Take out the current element
            int current = verticeQueue.poll();
            bfs.add(current);
            for (Integer neighbors : adj.get(current)) {

                // ONLY IF THE NEIGHBORS ARE NOT VISITED YET WE PROCESS THEM OTHERWISE WE DO NOT

                if (visited[neighbors] == 0) {

                    // Push the neighbours of the current node into the queue
                    // And mark them visited
                    visited[neighbors] = 1;

                    verticeQueue.add(neighbors);

                }
            }

        }

        return bfs;

    }
}
