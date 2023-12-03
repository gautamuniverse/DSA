import java.util.List;

public class Solution {
    // Function to perform the pop operation on Max Priority Queue
    public static int pop(List<Integer> queue) {
        // Check if the queue is empty
        if (queue.isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }

        // Save the maximum element to be returned later
        int ans = queue.get(0);

        // Swap the last element with the root and remove the last element
        int lastIndex = queue.size() - 1;
        queue.set(0, queue.get(lastIndex));
        queue.remove(lastIndex);

        int parentIndex = 0;
        int leftChildIndex, rightChildIndex, childIndex;

        // Heapify the queue to maintain the heap property
        while (true) {
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            childIndex = parentIndex;

            // Find the index of the larger child
            if (leftChildIndex < queue.size() && queue.get(leftChildIndex) > queue.get(childIndex)) {
                childIndex = leftChildIndex;
            }
            if (rightChildIndex < queue.size() && queue.get(rightChildIndex) > queue.get(childIndex)) {
                childIndex = rightChildIndex;
            }

            // Swap parent and child if child is greater
            if (childIndex != parentIndex) {
                int temp = queue.get(parentIndex);
                queue.set(parentIndex, queue.get(childIndex));
                queue.set(childIndex, temp);
                parentIndex = childIndex;
            } else {
                // Break if the heap property is restored
                break;
            }
        }

        // Return the maximum element that was removed
        return ans;
    }

    // Code Snippet of the push function:
    // public static void push(List<Integer> heap, int x) {
    //     heap.add(x);
    //     int pos = heap.size() - 1;
    //
    //     while (pos > 0) {
    //         int parent = (pos - 1) / 2;
    //         if (heap.get(pos) > heap.get(parent)) {
    //             int temp = heap.get(parent);
    //             heap.set(parent, heap.get(pos));
    //             heap.set(pos, temp);
    //             pos = parent;
    //         } else {
    //             break;
    //         }
    //     }
    // }
}
