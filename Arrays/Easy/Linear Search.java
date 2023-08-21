class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while(j  nums.length)
        {
            if(nums[j] != 0)
            {
                nums[i] = nums[j];
                i++;
                j++;
            }
            else
            j++;
        }

        while(inums.length)
        {
            nums[i] = 0;
            i++;
        }
    }
}