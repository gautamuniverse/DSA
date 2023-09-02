public class Solution {
    public static int count(int arr[], int n, int k) {
        //Your code goes here

        int lb = lowerBound(arr, n, k);
        if(lb == n)
        return 0;

        return upperBound(arr,n, k) - lb;
        
    }

     private static int lowerBound(int []arr, int n, int k)
    {
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high)
        {   int mid = (low+high)/2;
            if(arr[mid] >= k)
            {
                ans = mid;
                high = mid-1;
            }
            else
            low = mid+1;
        }

        return ans;
    }

    private static int upperBound(int []arr, int n, int k)
    {
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low <= high)
        {   int mid = (low+high)/2;
            if(arr[mid] > k)
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