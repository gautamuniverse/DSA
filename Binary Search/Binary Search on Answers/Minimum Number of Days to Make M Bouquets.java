//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/

import java.util.Arrays;

public class Solution {
    public static int roseGarden(int[] arr, int k, int m) {
        
        // Write your code here.
        
        //Naive Approach -  O(N) + O(max-min)*N

        // //Min days to bloom
        // int min = Arrays.stream(arr).min().getAsInt();
        // //Max days to bloom
        // int max = Arrays.stream(arr).max().getAsInt();

        // long val = (long)k*m;
        // //If the total number of flowers are less than required then return -1
        // if(arr.length < val)
        // {
        //     return -1;
        // }

        
        // for(int i = min; i<=max; i++)
        // {
        //     if(possible(arr, k, m, i))
        //     return i;
        // }

        // return -1;


        //Optimal Approach using binary Search
        //Idea -  since we have already figured out the possible range of days
        //i.e min and max number of possible days so use that to saerch for possible answers

          //Min days to bloom
        int min = Arrays.stream(arr).min().getAsInt();
        //Max days to bloom
        int max = Arrays.stream(arr).max().getAsInt();

        long val = (long)k*m;
        //If the total number of flowers are less than required then return -1
        if(arr.length < val)
        {
            return -1;
        }

        int low = min;
        int high = max;

        while(low <= high)
        {   int mid = (low+high)/2;
            if(possible(arr, k, m, mid))
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;


        //Why do we return low? because of the concept of the opposite polarity
        //in the start low was pointing to the not possible days and high was pointing to the 
        //always possible days, and hence in the end the polarities will change and low will be 
        //pointing to the min possible days and high will be pointing to the just one day less
        //than the possible day.
    }

    private static boolean possible(int [] arr, int k, int m, int days)
    {
        int n = arr.length;

        int count=0;
        int noOfB=0;

        for(int i = 0; i<n; i++)
        {
            if(arr[i] <= days)
            count++;
            else
            {
                noOfB += count/k;
                count=0;
            }
        }

        noOfB += count/k;
        return noOfB>=m;
    }
}