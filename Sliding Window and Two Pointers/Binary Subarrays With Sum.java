import java.util.HashMap;

public class Solution {
    public static int subarrayWithSum(int []arr, int s) {
        // Write your code here

        //Naive approach -  O(N^2)

        // int count = 0;
        // for(int i = 0; i<arr.length; i++)
        // {   int sum = 0;
        //     for(int j = i; j<arr.length; j++)
        //     {
        //         sum+=arr[j];

        //         if(sum == s)
        //         count++;
        //     }
        // }

        // return count; 


        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Initially put 0 prefix sum with count 1, Initialize index having zero sum as 1.
        map.put(0, 1); 
        int count =0;
        int preSum =0;
        for(int i =0; i<arr.length; i++)
        {   preSum += arr[i];
            int reqd = preSum - s;
            count+=map.getOrDefault(reqd, 0);
            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
        return count;
    }
}
