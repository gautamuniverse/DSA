public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        return binarySearch(arr, 0, n-1, x);
    }

    private static int binarySearch(int [] nums, int low, int high, int x)
    {
        
        int ans = nums.length;
        while(low<=high)
        {   int mid = (low+high)/2;
            if(nums[mid] >=x)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
    
        return ans;
    }   
}