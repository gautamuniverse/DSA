import java.util.PriorityQueue;

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static int maximumMeetings(int[] start, int[] end) {
        // Write your code here.
        // Create a priority queue and sort the list in ascending order of their end
        // times
        // We want the meetings that end early to finish first.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (int i = 0; i < start.length; i++) {
            Pair pair = new Pair(start[i], end[i]);
            pq.add(pair);
        }
        // 1 because we are completing one meeting before starting of the loop
        int count = 1;
        // Note the end time of the first meeting so that we can schedle only those
        // meetings going forward which have the start time greater than the end time of
        // the previous meeting to avoid overlap of time.
        int endTime = pq.poll().end;
        while (!pq.isEmpty()) {
            Pair currentPair = pq.poll();
            // Only if the time of current meeting is not overlapping with previous we will
            // consider it
            if (currentPair.start > endTime) {
                count++;
                endTime = currentPair.end;
            }
        }
        return count;
    }
}
