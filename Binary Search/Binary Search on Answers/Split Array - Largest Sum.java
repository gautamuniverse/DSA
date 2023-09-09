import java.util.Arrays;

public class Solution {
    public static int largestSubarraySumMinimized(int []a, int k) {
        // Write Your Code Here
        //This problem is exactly similar to the Book Allocation problem this problem can also be used to solve the Painters Partition problem
        //We will use the optimal approach of solving the minimise maximum subarray problems
        // We will use the binary search approach
        //In the book allocation we were asked to assign books, atleast one to exactly k students
        //Here we are asked to make exactly k subarrays of the given array
        //In book allocation we had to find the minimum of the maximum pages a student can have
        //Here we are trying to find the minimum of the max subarray sum

        //Therefore we will use the same exact approach
        //Start with finding the max of the array and also the sum of the element
        //Our low pointer will be the max element of the array, as the minimum of the
        //subarray having the greatest sum can be with one element and that is the max element
        //Also our maximum possible subarray sum can be the sum of whole array

        int low = Arrays.stream(a).max().getAsInt();
        int high = Arrays.stream(a).sum();

        while(low <= high)
        {
            int mid = (low + high)/2;
            //Send the array and the current max subarray sum limit, and check if it is possible to 
            //distribute among the k subarrays
            //the current count of the subarrays is exactly equal to k, therefore try checking for smaller values
            if(currentSubarrays(a, mid) <= k)
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;
    }

    private static int currentSubarrays(int [] arr, int maxSum)
    {
        int numberOfSubarrays = 1;
        int currentSum = 0;

        for(int i = 0; i<arr.length; i++)
        {
            if(currentSum + arr[i] <= maxSum)
            {
                currentSum+=arr[i];
            }

            else
            {
                numberOfSubarrays++;
                currentSum= arr[i];
            }
        }

        return numberOfSubarrays;
    }
}



