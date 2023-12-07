class Solution {
    public int findKthLargest(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

		for(int i : input)
		{
			pq.add(i);
		}

		for(int i = 1; i<k; i++)
		{
			pq.remove();
		}

		return pq.remove();
    }
}