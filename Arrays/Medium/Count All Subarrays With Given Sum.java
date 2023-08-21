import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.   
        // int count = 0;
        // for(int i = 0; i<arr.length; i++)
        // {
        //     for(int j = i; j<arr.length; j++)
        //     {
        //         int sum = 0;
        //         for(int k = i; k<=j; k++)
        //         {
        //             sum+=arr[k];
        //         }
        //         if(sum == s)
        //         count++;
        //     }
        // } 

        // return count;


        //O(N^2)
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


        //O(N) -  Most Optimal solution - Prefix Sum (HashMap)
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Initially put 0 prefix sum with count 1, it is essential for the calculation
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