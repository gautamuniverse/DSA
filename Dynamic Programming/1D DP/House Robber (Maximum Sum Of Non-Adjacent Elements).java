class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // Recursive
        // return recursive(nums, nums.length - 1);

        // Memo
        // int dp[] = new int[nums.length + 1];
        // Arrays.fill(dp, -1);
        // return recursive(nums, nums.length - 1, dp);

        // Tabulation
        // int dp[] = new int [nums.length];

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for(int i = 2; i< nums.length; i++)
        // {
        // int take = nums[i] + dp[i-2];
        // int notTake = dp[i-1];
        // dp[i] = Math.max(take, notTake);
        // }

        // return dp[nums.length - 1];

        // Space Optimization

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    private int recursive(int[] nums, int index, int[] dp) {
        if (index == 0)
            return nums[0];
        if (index < 0)
            return 0;
        int take = 0;
        int notTake = 0;

        if (dp[index] != -1)
            return dp[index];
        take = nums[index] + recursive(nums, index - 2, dp);
        notTake = recursive(nums, index - 1, dp);

        dp[index] = Math.max(take, notTake);
        return dp[index];
    }
}