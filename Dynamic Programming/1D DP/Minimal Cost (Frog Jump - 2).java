public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        //recursive
        // if(n == 0) return 0;
        // int minCost = Integer.MAX_VALUE;
        // int cost = 0;
        // for(int i = 1; i<=k; i++)
        // {     
        //     if(n-i >= 0){
        //     cost =  minimizeCost(n-i, k, height) + Math.abs(height[n==height.length?n-1:n] - height[n-i]);
        //     minCost = Math.min(cost, minCost);
        //     }  
        //     else break;

        // }

        // return minCost;

        //DP

        if(n == 0) return 0;

        int dp [] = new int [n+1];
        dp[0] = 0;
   
        for(int i = 1; i< n; i++)
        {
             int minCost = Integer.MAX_VALUE;  
            for(int j = 1; j<=k; j++)
            {
                if(i - j >= 0)
                {
                    int cost = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[n-1];



    }
}