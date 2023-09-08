public class Solution {
    public static int missingK(int[] vec, int n, int k) {
        // Write your code here.
        //Naive solution
        //time - O(N)
        //Idea: whenever we encounter a number which is less than or equal to the k
        //then we increment the k value, and else we found our required missing number
        // for(int i = 0; i<n; i++)
        // {
        //     if(vec[i] <= k)
        //     k++;

        //     else
        //     break;
        // }
        // return k;

        //Optimal approach - Binary Search : TIme : O(logN)
        //In this problem we can't directly apply Binary search on answers

        int low = 0;
        int high = n-1;

        while(low <= high)
        {
            int mid = (low+high)/2;

            int missing_numbers = vec[mid] - (mid+1);

            //The below condition means that there are no missing numbers at this index and we 
            //need to move forward to find the missing numbers
            if(missing_numbers <k)
            low = mid+1;

            //We need to consider smaller number of missing numbers
            //kth missing number = vec[high] + k - (vec[high] - (high+1))
        //=  vec[high] + k - vec[high] + high + 1
        // = k + high + 1.
            else
            high = mid-1;
        }
        //return low+k or return high+1+k
        //high+1 will be pointing to the low index,as low has moved ahead of high one index further
        return low+k;
    }

}