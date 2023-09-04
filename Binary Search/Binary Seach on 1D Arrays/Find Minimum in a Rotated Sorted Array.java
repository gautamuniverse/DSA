public class Solution {
    public static int findMin(int []arr) {
        // Write your code here.
        return binarySearchModified(arr, arr.length);
    }
    private static int binarySearchModified(int []arr, int n)
    {      
        int low = 0;
        int high=n-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = (low+high)/2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if(arr[low] <= arr[high])
            {  ans = Math.min(ans, arr[low]); 
               //Break from here as no need to perform further binary search
                break;
            }

            //Check if the left half is sorted
            if(arr[low] <= arr[mid])
            {
                ans = Math.min(ans, arr[low]);
                low = mid+1;
            }

            else
            {
                ans = Math.min(arr[mid],ans);
                high = mid-1;
            }
        }
        return ans;
    }
}