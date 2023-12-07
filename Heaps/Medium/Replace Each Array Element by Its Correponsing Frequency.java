import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> ranks = new HashMap<>();
        for (Integer i : arr) {
            pq.add(i);
            ranks.put(i, ranks.getOrDefault(i, 0) + 1); // freq map
        }

        int count = 1;
        while (!pq.isEmpty()) {
            int num = pq.remove();
            // Duplicate numbers are present in Array, since we have to keep same rnak for
            // the duplicate elements we will remove the duplicate numbers from the priority
            // queue
            if (ranks.get(num) > 1) {
                while (pq.peek() == num)
                    pq.remove();
            }
            //replace the freq with current rank of the num into the map
            ranks.put(num, count);
            count++;
        }
        //Replace each arraylist element with its frequency
        for (int i = 0; i < n; i++) {
            arr.set(i, ranks.get(arr.get(i)));
        }

        return arr;

    }
}
