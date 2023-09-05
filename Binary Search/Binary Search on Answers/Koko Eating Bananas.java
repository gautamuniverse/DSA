import java.util.Arrays;

public class Solution {
    public static int minimumRateToEatBananas(int []v, int h) {
        // Write Your Code Here
        int low = 1;
        //Get the max element in the array as high, which can be our max answer possible
        int high = Arrays.stream(v).max().getAsInt();
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            //check if the current hourly Bananas are within the given h range
            int totalH = totalHours(v, mid);
            if(totalH <= h)
            {
                high = mid-1;
            }
            else
            low = mid+1;
        }

        //Low will be containin our answer, because low will be pointing to the 
       //number which is just after not possible number, and that will be the
       //min possible number as well.
        return low;
    }

    private static int totalHours(int [] arr, int hourlyBananas)
    {
        int totalH = 0;
        for(int i = 0; i<arr.length; i++)
        {
            totalH+=Math.ceil((double)arr[i]/ (double)hourlyBananas);
        }

        return totalH;
    }
}



