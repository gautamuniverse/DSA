import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.
        //Kadane's approach, O(N^2), Space -  O(1)
        // int n = arr.length;

        // int maxCount = Integer.MIN_VALUE;

        // for(int i = 0; i< n; i++)
        // {
        //     int j = i+1;
        //     int currentSum = arr[i];
        //     int count =currentSum==0?1:0;
        //     while(j<n)
        //     {   
        //         currentSum+=arr[j];
        //         if(currentSum==0)
        //         {
        //             count = j-i+1;
                   
        //         }
        //         j++;
        //     }
        //      maxCount= Math.max(count, maxCount);
        // }

        // return maxCount;

        //Optimal solution - O(N),  space -  O(N)

        Map<Integer, Integer> map = new HashMap<>();

        int maxIndex = 0;
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++)
        {
            sum+=arr[i];
            if(sum == 0)
            {
                maxIndex = i+1;
            }
            else
            {
                if(map.containsKey(sum))
                {
                    maxIndex = Math.max(maxIndex, i - map.get(sum));
                }
                else
                {
                    map.put(sum, i);
                }
            }
        } 

        return maxIndex;
    }
}