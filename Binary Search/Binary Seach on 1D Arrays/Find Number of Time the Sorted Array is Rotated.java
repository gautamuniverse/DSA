public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        return binarySearchModified(arr, arr.length);
    }

    private static int binarySearchModified(int []arr, int n)
    {      
        int low = 0;
        int high=n-1;
        int ans = Integer.MAX_VALUE;
        int index = 0;
        while(low <= high)
        {
            int mid = (low+high)/2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if(arr[low] <= arr[high])
            {  ans = Math.min(ans, arr[low]); 
               //Break from here as no need to perform further binary search

               //Store the current minimum index
                if(ans == arr[low])
                index = low;

                break;
            }

            //Check if the left half is sorted
            if(arr[low] <= arr[mid])
            {
                ans = Math.min(ans, arr[low]);

                if(ans == arr[low])
                index = low;

                low = mid+1;
            }

            else
            {
                ans = Math.min(arr[mid],ans);

                if(ans == arr[mid])
                index = mid;

                high = mid-1;
            }
        }
        return index;
    }
}