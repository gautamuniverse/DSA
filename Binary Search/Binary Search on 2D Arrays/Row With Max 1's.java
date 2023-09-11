import java.util.ArrayList;
import java.util.Collections;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        //	  Write your code here.
        // Naive Approach
        //Time - O(n x m)
        //Space - O(1)
        // int maxIndex=Integer.MIN_VALUE;
        // int maxCount = 0;
        // for(int i = 0; i<n; i++)
        // {   
        //     int count =0;
        //     for(Integer j : matrix.get(i))
        //     {
        //         if(j == 1)
        //         count++;
        //     }
        //     if(count>maxCount)
        //     {
        //         maxCount = count;
        //         maxIndex = i;
        //     }
        // }

        // return maxIndex;


        //Best Approach -  using lower Bound code
        //time -  O(n * log2 m)
        int maxCount = 0;
        int index = -1;
        for(int i = 0; i<n; i++)
        {
            int count =0 ;
            count = m- lowerBound(matrix.get(i), m, 1);
            if(count > maxCount)
            {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }

    private static int lowerBound(ArrayList<Integer> arr, int n, int x)
    {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high)
        {
            int mid = (low+high)/2;

            if(arr.get(mid) >= x)
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