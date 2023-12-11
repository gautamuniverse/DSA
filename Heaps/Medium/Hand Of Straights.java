/*Intuition: We will use a minHeap to get the minimum value all the time when we are starting to create a new group. And we will simultaneously create a frequency map and we will check for the count available to us of each value, if at any moment of creating the group, we happen to find that in the map the available count has become 0, then we will pop it off from the min heap and also from the map, but also we need to see if the value we are about pop from minHeap has to be the minimum, the peek value of the min heap, otherwise we have to straight up return false, because if we are removing a value which is not the minimum as per our min heap then we are basically create a whole for the actual minimum value available to us, for example 1,1,2,3,3,4,5,
here the first group that we will be forming is 1,2,3 but notice that on utilizing the 2 we made its count 0 in the map, therefore we have to remove it from the map as well as from the minheap, but we have a number smaller than the 2 in the minheap already because its count is still 1, this means that when we will again pick 1 for creating a new group, we wont be able to form the next consecutive group of size groupSize, that will be something like 1,3,4 which is invalid.*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
       // If the total cards are not divisible equally in group size then return false.
        int totalCards = hand.length;
        if (totalCards % groupSize != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        // Frequency map
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // get the keys from the map
        Set<Integer> keySet = map.keySet();

        // initializing the priority queue with Map Keys
        PriorityQueue<Integer> pq = new PriorityQueue<>(keySet);

        while (!pq.isEmpty()) {
            int min = pq.peek();
            int k = 0;
            while (k < groupSize) {
                if (!map.containsKey(min)) {
                    return false;
                } else {
                    if (map.get(min) == 0) {
                        return false;
                    }

                    map.put(min, map.get(min) - 1);
                    if (map.get(min) == 0) {
                        int min_now = pq.peek();
                        if (min_now != min)
                            return false;
                        else
                            pq.remove();
                    }
                    k++;
                    min++;
                }

            }

        }
        return true;
    }
}