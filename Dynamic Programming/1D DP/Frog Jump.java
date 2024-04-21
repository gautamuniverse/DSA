import java.util.*;
import java.io.*;

public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..

        // recursive
        // return helper(n, heights, n - 1);

        // Memoization. (Top Down)
        // We will make a n+1 sized array to store the aray elements and store the
        // results for each n in the array indexes. and avoid re computing the recursion
        // for those n for which we already have the result stored in the array.

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);

        // return helperMemo(n, heights, n - 1, dp);

        // Tabulation (Bottom Up)
        // We know that for n = 0 then answer is 0 and for n = 1 the answer is
        // Math.abs(heights[1] - heights[0])
        // We also have the recurrence relation with us that we used for the recursive
        // solution, so we can use those logics to build the answer array bottom up.

        // int dp[] = new int [n]; //0 based indexing therefore we can take n size 
        // dp[0]= 0;

        // //Since we know that our recurrence relation is only going to get executed when the index >=1 therefore start the traversal from index  = 1
        // for(int i = 1; i<n; i++)
        // {
        //     int singleStep = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
        //     int doubleStep = Integer.MAX_VALUE;
        //     if(i > 1)
        //     doubleStep = dp[i-2] + Math.abs(heights[i] - heights[i-2]);

        //     dp[i] = Math.min(singleStep, doubleStep); 
        // }

        // return dp[n-1];


        //Tabulation - Space optimization - only using variables.

        int prev = 0;
        int prev2 = 0;
        
        for(int i = 1; i< n; i++)
        {
            int singleJump = prev + Math.abs(heights[i] -heights[i-1]);
            int doubleJump = Integer.MAX_VALUE;
            if(i>1)
            doubleJump = prev2 + Math.abs(heights[i] - heights[i-2]);

            int curr = Math.min(singleJump, doubleJump);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    // private static int helper(int n, int[] heights, int index) {
    // // Base case - if we are the 0th index, then cost of jumping from 0 to 0 is
    // 0.
    // if (index == 0)
    // return 0;

    // int singleJump = helper(n, heights, index - 1) + Math.abs(heights[index] -
    // heights[index - 1]);
    // int doubleJump = Integer.MAX_VALUE;
    // if (index > 1)
    // doubleJump = helper(n, heights, index - 2) + Math.abs(heights[index] -
    // heights[index - 2]);

    // return Math.min(singleJump, doubleJump);
    // }

    private static int helperMemo(int n, int[] heights, int index, int[] dp) {
        // Base case - if we are the 0th index, then cost of jumping from 0 to 0 is 0.
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int singleJump = helperMemo(n, heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);
        int doubleJump = Integer.MAX_VALUE;
        if (index > 1)
            doubleJump = helperMemo(n, heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);

        dp[index] = Math.min(singleJump, doubleJump);
        return dp[index];
    }
}