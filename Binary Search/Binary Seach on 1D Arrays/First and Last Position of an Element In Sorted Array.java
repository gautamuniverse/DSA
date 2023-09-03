import java.util.* ;
import java.io.*; 
public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int lb = lowerBound(arr, n, k);
        if(lb == n || arr.get(lb) != k)
        {   int [] ans = {-1, -1};
            return ans;
        }
        int [] ans = {lb, upperBound(arr, n, k) -1};
        return ans;
    }

    private static int lowerBound(ArrayList<Integer> arr, int n, int k)
    {
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high)
        {   int mid = (low+high)/2;
            if(arr.get(mid) >= k)
            {
                ans = mid;
                high = mid-1;
            }
            else
            low = mid+1;
        }

        return ans;
    }

    private static int upperBound(ArrayList<Integer> arr, int n, int k)
    {
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high)
        {   int mid = (low+high)/2;
            if(arr.get(mid) > k)
            {
                ans = mid;
                high = mid-1;
            }
            else
            low = mid+1;
        }

        return ans;
    }
}
