//heapify algorithm 
//Time - O(logn)

public class Solution {
    public static int[] MinToMaxHeap(int n, int[] arr) {
        // Write your code here

        // in a heap, the elements from posN n/2+1 to n-1 are leaf nodes.
        // So we dont need to take them into consideration while running the heapify
        // algirithm.
        // Because the leaf nodes are max Heap in thereselves.
        // We will use the heapify algorithm on non leaf nodes and take them to their
        // correct positions.

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
        return arr;
    }

    private static void heapify(int[] arr, int n, int i) {

        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        int largest = i;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // if node at ith position is not in its correct position, swap and heapify
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // Take the largest position node to its correct position.
            heapify(arr, n, largest);
        }

    }
}

// O(N*logn) , space - O(N)

// public class Solution {
// static int ans[];
// static int index = 0;

// public static int[] MinToMaxHeap(int n, int[] arr) {
// // Write your code here
// ans = new int[arr.length];
// for (int i : arr) {
// insertIntoHeap(i);
// }

// return ans;
// }

// private static void insertIntoHeap(int num) {
// // insert at the end of the array
// if (index < ans.length)
// ans[index] = num;
// else
// return;

// int pos = index;
// // perform heapify
// while (pos > 0) {
// int parentIndex = (pos - 1) / 2;
// // Compare if the child is greater than the parent, if so then swap
// if (ans[parentIndex] < ans[pos]) {
// int temp = ans[parentIndex];
// ans[parentIndex] = ans[pos];
// ans[pos] = temp;
// pos = parentIndex;
// } else {
// break;
// }
// }
// index++;
// }
// }