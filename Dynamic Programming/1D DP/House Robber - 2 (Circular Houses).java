class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // APPROACH:
        // Since we know that the last and first element can never be taken togehter in
        // the answer therefore we will consider two arrays first one is including first
        // elemenet and excluding the last element, and the second one is including the
        // last element and exclsuing the fist element.

        // int dp [] = new int[nums.length];

        // //Don't consider the last element
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for(int i = 2; i<=nums.length - 2; i++)
        // {
        // int take = nums[i] + dp[i-2];
        // int notTake = dp[i-1];

        // int curr = Math.max(take, notTake);
        // dp[i] = curr;
        // }

        // int ans1 = dp[nums.length-2];

        // //Dont consider the first element;
        // dp[1] = nums[1];
        // dp[2] = Math.max(nums[1], nums[2]);

        // for(int i = 3; i<=nums.length - 1; i++)
        // {
        // int take = nums[i] + dp[i-2];
        // int notTake = dp[i-1];

        // int curr = Math.max(take, notTake);
        // dp[i] = curr;
        // }

        // int ans2 = dp[nums.length-1];

        // return Math.max(ans1, ans2);

        // Space optimisation

        // Don't consider the last element
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= nums.length - 2; i++) {
            int take = nums[i] + prev2;
            int notTake = prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        int ans1 = prev;

        // Dont consider the first element;
        prev2 = nums[1];
        prev = Math.max(nums[1], nums[2]);

        for (int i = 3; i <= nums.length - 1; i++) {
            int take = nums[i] + prev2;
            int notTake = prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        int ans2 = prev;

        return Math.max(ans1, ans2);

    }

}