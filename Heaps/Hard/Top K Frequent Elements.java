//Idea: 
/* We are going to use minHeap and HashMap, in the hashmap we are going to store the freq
of each arr item, in the minHeap we will be having the map key/value pairs, the sorting
will be based on the frequencies of the entries,

The Algorithm:
1. First we will create a frequency map
2. Then we will create a minHeap with the custom sorting and the minHeap items are map
entrysets.
3. After creating the freq map and defining the minHeap we will start pushing each of the
Map entry item into the minHeap, we will also keep a check that the size of the minheap
should not go beyond k, this we will be having the k most frequent entries in the minHeap.
4. Now we will be having the minHeap values sorted in ascending orders of the mapFrequency
values.and they are the actual required array numbers.
5. Now we will  remove each minHeap item and store its entry's key value inside the finalAns arr.
6. Return the finalAns array'*/


class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        
         Map<Integer, Integer> freq = new HashMap<>();

        for(int i: arr)
        {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        
        for(Map.Entry<Integer, Integer> i : freq.entrySet())
        {   
            pq.add(i);
            if(pq.size() > k)
            {
                pq.remove();
            }
        }

        int [] finalAns = new int[k];
        int i = 0;
        while(!pq.isEmpty())
        {
            finalAns[i++] = pq.remove().getKey();
        }
        return finalAns;
    }
}