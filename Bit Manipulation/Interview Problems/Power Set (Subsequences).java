class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        // Approach 1 - Bit Manipulation
        // Time - O(2^n * n)
       List<List<Integer>> ans = new  ArrayList<>();
        for(int i = 0; i<Math.pow(2, nums.length); i++)
        {
            List<Integer> currList = new ArrayList<>();
            int currNum = i;
            for(int j= 0; j<nums.length; j++)
            {
                if((i & (1<<j)) !=0)
                currList.add(nums[j]);
            }
             ans.add(currList);
        }
        return ans;



        //Approach 2 -  timne - O(2^n)

    //    return helper(nums, 0);
    }

    private static List<List<Integer>> helper(int [] nums, int index)
    {
        if(index == nums.length)
        {
            List<List<Integer>> ls = new ArrayList<>();
            List<Integer> an = new ArrayList<>();
            ls.add(an);
            return ls;
        }

        List<List<Integer>> small = helper(nums, index+1);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> i : small)
        {
            List<Integer> cloned = new ArrayList<>(i);
            ans.add(cloned);
        }

        for(List<Integer> i : small)
        {
            ArrayList<Integer> cloned = new ArrayList<>(i);
            cloned.add(0, nums[index]);

           ans.add(cloned);
        }

        return ans;
    }
}