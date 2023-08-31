import java.util.Arrays;

public class Solution {
    public static int subarrayWithMaxProduct(int []arr){
        // Write your code here.

        //O(N)
        //Observation bAses algorithm
        //Conditions:
        //1. If the array has only +ve elements then the answer is straight up product of all the array elements
        //2. If the array has even number of -ve elements, then also answer is the product of all the array elements
        //3. if the array has odd number of -ve elements, then removeing 1 odd -ve number can give us max product of array elements
        //4. if there are 0's in the array then we need to consider prefix and suffix products of the array elements from the 0
        //5.The maximum product obtained from these prefix and suffix subarrays will be our final answer.
        int n = arr.length;
        int suffix = 1;
        int prefix = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length; i++)
        {   
            if(prefix == 0)
            prefix = 1;

            if(suffix == 0)
            suffix = 1;
        
            prefix *= arr[i];
            suffix *= arr[n - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
        }


        return max;
    }
}