import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findMaxFruits(int[] arr, int n) {
        // Write your code here.

        // Naive solution - O(N^2) , space - O(1);

        // int max =Integer.MIN_VALUE;

        // for (int i = 0; i < arr.length; i++) {
        // Map<Integer, Integer> tempBasket = new HashMap<>();
        // tempBasket.put(arr[i], 1);
        // for (int j = i+1; j < arr.length; j++) {
        // if(!tempBasket.containsKey(arr[j]) && tempBasket.size() >= 2)
        // break;

        // if(tempBasket.containsKey(arr[j]))
        // {
        // tempBasket.put(arr[j], tempBasket.get(arr[j]) + 1);
        // }
        // if(!tempBasket.containsKey(arr[j]) && tempBasket.size() < 2)
        // {
        // tempBasket.put(arr[j], 1);
        // }
        // }
        // Collection <Integer> values = tempBasket.values();
        // int sum = 0;
        // for(int k : values)
        // {
        // sum+=k;
        // }

        // max = Math.max(max, sum);
        // }

        // return max;

        // Optimal Solution:
        // We can also read the problem statement as:
        // Find the length of the longest contiguous subarray with at most 2 distinct
        // integers.

        // Approach: We are gonna use sliding window approach. here we will be defining
        // two pointers and we are gonna place botht he pointers at the 0 index at
        // start, The right pointer will move. Conditions:
        // we will add the current element at the right pointer to the map, if it is
        // already there then we will simply increase its count.
        // Now we will also check if the map size has increased beyond 2, if so then we
        // will keep decreasing the count of the elements starting from the left pointer
        // in the map such that the size of the map becomes equal to 2.
        // We will keep updating the max fruits we have in the basket at each iteration,
        // we will only update the maxfruits variable if the current count of fruits is
        // greater than the max fruits so far.

        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, right;
        int maxFruits = 0;

        for (right = 0; right < arr.length; right++) {
            // Check the current count of the current fruit in the map, if doesn't exits
            // then assign 0 value
            int currentFruitCount = basket.getOrDefault(arr[right], 0);
            // put the current fruit in the basket with the incremented current count value
            // if it exits
            basket.put(arr[right], currentFruitCount + 1);

            // If the size of map is more than 2, start decrementing/removing the fruits
            // from left side of window(shrink window size)
            while (basket.size() > 2) {
                int fruitCount = basket.get(arr[left]);

                // if the fruit count is 1 then directly remove it.
                if (fruitCount == 1)
                    basket.remove(arr[left]);

                else
                    basket.put(arr[left], fruitCount - 1);

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;

    }
}