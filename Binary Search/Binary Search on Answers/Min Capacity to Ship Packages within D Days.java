class Solution {
    public int shipWithinDays(int[] weights, int d) {
     // Write your code here.
        //Naive approach -  O((sum - max) * N)
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();
        // for(int i = max; i<=sum; i++)
        // {   int daysRequired = daysTaken(weights, i);
        //     if(daysRequired <= d)
        //     {
        //         return i;
        //     }
        // }
        // return sum;

        //Optimal approach
        //Since we have a range of answers that is, max to sum
        //Therefore use Binary Search to shrink down the search space
        int low = max;
        int high = sum;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(daysTaken(weights, mid) <= d)
            {
                //If the current capacity is possible, look for smaller capacity
                high = mid-1;
            }
            else
            low = mid+1;
        }
        //Low will be pointing to the answer, concept of opposite polarity
        //Initially low was pointing to the non possible capacity hence in the end
        //it pointed to the possible polarity
        return low;
    }

    private static int daysTaken(int [] arr, int wt)
    {
        int days= 1;
        int load = 0;

        for(int i = 0; i<arr.length; i++)
        {   
            if(load+arr[i] > wt)
            {
                days++;
                load = arr[i];
            }
            else{
                load+=arr[i];
            }
        }
        return days;
    }
}