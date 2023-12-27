class Solution {
    public int jump(int[] nums) {
        int farthest = 0; // represents the farthest we can go so far
        int end = 0; // will represent the end that is the fartheest position index
        int ans = 0; //will maintain the jumps we are gonna take

        for(int i = 0; i< nums.length - 1; i++)
        {
            farthest = Math.max(farthest , nums[i] + i);
            if(farthest >= nums.length - 1) //we can make a jump directly to the n-1 index therefore we increase the ans counter and break from the loop
            {
                ++ans;
                break;
            }

            if(i == end) //we have reached the end of current level(level means the previous jump's farthest distance is what we have reached at this point so we are gonna update the end to the new farthest so that we can update the jump level)
            {
                ++ans;
                end = farthest; 
            }
        }

    return ans;
    }
}