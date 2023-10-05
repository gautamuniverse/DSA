class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       return helper(nums, 0);
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