import java.util.Arrays;

public class Solution {
    public static int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        
        //naive solution O(N^2)
        // int max = Arrays.stream(arr).max().getAsInt();
        // for(int i = 1; i<=max; i++)
        // {
        //     int sum =0;
        //     for(int j = 0; j< arr.length; j++)
        //     {   
        //         double dividend = arr[j];
        //         double divisor = i;
        //         double div = Math.ceil(dividend/divisor);
        //         sum+=(int)div;
        //     }
        //     if(sum<=limit)
        //     {
        //         return i;
        //     }
        // }
        // return -1;

        //Optimal Solution
        int max = Arrays.stream(arr).max().getAsInt();
        int min = 1;

        //Our range is defined, that is min to max
        int low = min;
        int high = max;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(divisionResult(arr, mid, limit))
            {
                high = mid-1;
            }
            else
            low = mid+1;
        }
        //Low will eventually point to the lowest possible divisor
        return low;
    }

    private static boolean divisionResult(int arr[], int num, int limit)
    {       int sum =0;
            for(int j = 0; j< arr.length; j++)
            {   
                double dividend = arr[j];
                double divisor = num;
                double div = Math.ceil(dividend/divisor);
                sum+=(int)div;
            }
            if(sum<=limit)
            {
                return true;
            }
        return false;
    }
}