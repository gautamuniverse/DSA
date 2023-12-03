import java.util.ArrayList;

public class Solution {

    static class MinHeap {
        ArrayList<Integer> heap;
        int size;

        // Constructor for the class.
        MinHeap(int size) {
            heap = new ArrayList<>();
            this.size = size;
        }

        // Implement the function to remove the minimum element.
        int extractMinElement() {
            // Check if the heap is empty
            if (heap.isEmpty()) {
                return -1; // Return -1 if the heap is empty
            }

            // Save the minimum element to be returned later
            int minElement = heap.get(0);

            // Swap the last element with the root and remove the last element
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);

            int parentIndex = 0;
            int leftChildIndex, rightChildIndex, childIndex;

            // Heapify the heap to maintain the heap property
            while (true) {
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
                childIndex = parentIndex;

                // Find the index of the smaller child
                if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(childIndex)) {
                    childIndex = leftChildIndex;
                }
                if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(childIndex)) {
                    childIndex = rightChildIndex;
                }

                // Swap parent and child if child is smaller
                if (childIndex != parentIndex) {
                    int temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(childIndex));
                    heap.set(childIndex, temp);
                    parentIndex = childIndex;  //meaning there was no greater child downward
                } else {
                    // Break if the heap property is restored
                    break;
                }
            }
            return minElement;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            int parentIndex = ind;
            int leftChildIndex, rightChildIndex, childIndex;

            // Heapify the heap to maintain the heap property
            while (true) {
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
                childIndex = parentIndex;

                // Find the index of the smaller child
                if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(childIndex)) {
                    childIndex = leftChildIndex;
                }
                if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(childIndex)) {
                    childIndex = rightChildIndex;
                }

                // Swap parent and child if child is smaller
                if (childIndex != parentIndex) {
                    int temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(childIndex));
                    heap.set(childIndex, temp);
                    parentIndex = childIndex;  //meaning there was no greater child downward
                } else {
                    // Break if the heap property is restored
                    break;
                }
            }
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            heap.add(val);
            int pos = heap.size() - 1;

            while (pos > 0) {
                int parent = (pos - 1) / 2;
                // If the parent element is greater than the current element, then swap and move up
                if (heap.get(pos) < heap.get(parent)) {
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(pos));
                    heap.set(pos, temp);
                    pos = parent;
                } else {
                    break;
                }
            }
        }
    }
}
