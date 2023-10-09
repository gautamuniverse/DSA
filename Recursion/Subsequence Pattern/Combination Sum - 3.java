class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
      // Write your code here.
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> currentCombo = new ArrayList<>();

       helper(1, k,n,0, ans, currentCombo);
       
       return ans;
    }

    private static void helper(int curr, int k, int target,int currentSum, List<List<Integer>> ans, List<Integer> currentCombo)
    {
        //Base case
        if(currentCombo.size() == k)
        {
            if(currentSum == target)
            {ans.add(new ArrayList<>(currentCombo));}
            return;
        }

        for(int i = curr; i<=9; i++)
        {   //Take it
            currentCombo.add(i);
            helper(i+1, k , target, currentSum + i, ans, currentCombo);

            //Don't take it
            currentCombo.remove(currentCombo.size()-1);
        }
    }
}