import java.util.ArrayList;

public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();

        // Prepare the ArrayList to store the edges data.
        for (int i = 0; i < n; i++) {
            // Create and add new array list to the current parent list
            adjacency.add(new ArrayList<>());
            adjacency.get(i).add(i); // we add the first index value for each sub arraylist, which is nothing but the
                                     // ith index. as the number of nodex are ranging from 0 to n-1
        }

        // Fill the adjacency list with the edges data.
        for (int temp[] : edges) {
            int u = temp[0];
            int v = temp[1];
            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }

        // Create the final array for output
        int ans[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            ans[i] = adjacency.get(i).stream().mapToInt(Integer::intValue).toArray();
        }

        return ans;
    }

}
