class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int consecutive=0;
        for(int i =0; i<nums.length; i++)
        {
            if(nums[i] == 1)
            consecutive++;
            else
            {   
                consecutive = 0;
            }
            max = Math.max(max, consecutive);
        }
        
        return max;
    }
}