
import java.util.HashMap;

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here

        // int maxlen = Integer.MIN_VALUE;

        // for(int i = 0; i<a.length; i++)
        // {   int len = 0;
        //     for(int j = i; j<a.length;j++ )
        //     {
        //         len += a[j];
        //         if(len == k)
        //         {
        //             maxlen = Math.max(j-i + 1, maxlen);
        //         }
        //     }
            
        // }

        // return maxlen;

        //Better HashMap approach
        
        // int n = a.length; // size of the array.

        // HashMap<Long, Integer> preSumMap = new HashMap<>();
        // long sum = 0;
        // int maxLen = 0;
        // for (int i = 0; i < n; i++) {
        //     //calculate the prefix sum till index i:
        //     sum += a[i];

        //     // if the sum = k, update the maxLen:
        //     if (sum == k) {
        //         maxLen = Math.max(maxLen, i + 1);
        //     }

        //     // calculate the sum of remaining part i.e. x-k:
        //     long rem = sum - k;

        //     //Calculate the length and update maxLen:
        //     if (preSumMap.containsKey(rem)) {
        //         int len = i - preSumMap.get(rem);
        //         maxLen = Math.max(maxLen, len);
        //     }

        //     //Finally, update the map checking the conditions:
        //     if (!preSumMap.containsKey(sum)) {
        //         preSumMap.put(sum, i);
        //     }
        // }

        // return maxLen;


        //Two pointer approach most optimised for only positive numbers
      int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            
            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward the right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
}