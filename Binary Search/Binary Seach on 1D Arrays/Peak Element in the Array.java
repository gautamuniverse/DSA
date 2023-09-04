import java.util.ArrayList;
public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.

        return binarySearch(arr, arr.size());
    }

    private static int binarySearch(ArrayList<Integer> arr, int n)
    {   
        //Edge cases
        if(n == 1)
        return 0;

        if(arr.get(0) > arr.get(1))
        return 0;

        if(arr.get(n-1) > arr.get(n-2))
        return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1))
            {
                return mid;
            }
            //Check if the current element is in the decreasing curve or increasing curve
            //If the element is on the increasing curve the element can nver be found in the left half
            else if(arr.get(mid) > arr.get(mid-1))
            {
                low = mid+1;
            }
            //The current mid is present on the decreasing curve hence the peak can never be found on this half
            //search in the left half
            else
                high = mid-1;
        }

        return -1;
    }
}
