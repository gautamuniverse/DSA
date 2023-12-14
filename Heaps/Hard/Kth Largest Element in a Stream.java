/*Intuition, we will be using minPriority Queue, and we will maintain the size of the queue equal to k, this will make sure that when we peek, we will be getting the kth largest element, because it will be at the fron of the queue. */

class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums){
            //Directly call the add function to add the nums array elements
            add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) pq.remove();

        //Why peek? because the minimum element will be at the front and we are maintaining queue size = k therefore it will be the Kth largest element.
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */










 // class KthLargest {
//     ArrayList<Integer> pq;
//     int K;

//     KthLargest(int k, int[] arr) {
//         K = k;
//         pq = new ArrayList<>();
//         for (int i : arr) {
//             pq.add(i);
//         }
//         buildHeap();
//     }

//     int add(int val) {
//         pq.add(val);
//         heapifyUp(); // Corrected method name
//         Collections.sort(pq, Collections.reverseOrder());

//         return pq.get(K - 1);
//     }

//     void buildHeap() {
//         int n = pq.size();
//         for (int i = n / 2 - 1; i >= 0; i--) {
//             heapifyDown(i);
//         }
//     }

//     void heapifyUp() {
//         int pos = pq.size() - 1;

//         while (pos > 0) {
//             int parent = (pos - 1) / 2;
//             // If the parent element is smaller than the current element, then swap and move up
//             if (pq.get(pos) > pq.get(parent)) {
//                 swap(pos, parent);
//                 pos = parent;
//             } else {
//                 return;
//             }
//         }
//     }

//     void heapifyDown(int i) {
//         int n = pq.size();
//         int largest = i;
//         int left = 2 * i + 1;
//         int right = 2 * i + 2;

//         if (left < n && pq.get(left) > pq.get(largest)) {
//             largest = left;
//         }

//         if (right < n && pq.get(right) > pq.get(largest)) {
//             largest = right;
//         }

//         if (largest != i) {
//             swap(i, largest);
//             heapifyDown(largest);
//         }
//     }

//     void swap(int i, int j) {
//         int temp = pq.get(i);
//         pq.set(i, pq.get(j));
//         pq.set(j, temp);
//     }
// }






// class KthLargest {

//         PriorityQueue<Integer> pq;
//         int K;

//         KthLargest(int k, int[] arr) {
//             pq = new PriorityQueue<>((a, b) -> b - a); // Max Priority Queue
//             this.K = k;

//             for (int i : arr) {
//                 pq.add(i);
//             }
//         }

//         int add(int val) {
//             pq.add(val);

//             List<Integer> temp = new ArrayList<>();

//             for (int i = 0; i < K - 1; i++) {
//                 temp.add(pq.remove());
//             }

//             int ans = pq.peek();

//             for (int i : temp) {
//                 pq.add(i);
//             }

//             return ans;
//         }
// }

// /**
//  * Your KthLargest object will be instantiated and called as such:
//  * KthLargest obj = new KthLargest(k, nums);
//  * int param_1 = obj.add(val);
//  */