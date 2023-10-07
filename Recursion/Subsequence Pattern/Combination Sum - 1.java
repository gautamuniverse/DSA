import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Solution {
    public static List< List < Integer > > combSum(int []arr, int k) {
        // Write your code here.
        Arrays.sort(arr);
       Set<List<Integer>> ans = new HashSet<>();
        
        helper(arr, k, 0, ans, new ArrayList<>());

        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }

    private static void helper(int[] arr, int k, int index, Set<List<Integer>> ans, ArrayList<Integer> currentCombo)
    {
        //base case
        if(k == 0)
        {
            ans.add(new ArrayList<>(currentCombo));
            return;
        }

        if(index == arr.length)
        {
            if(k == 0)
            {
                 ans.add(new ArrayList<>(currentCombo));
            }
            return;
        }


        if(arr[index] <= k)
        {
            currentCombo.add(arr[index]);
            helper(arr, k-arr[index], index, ans, currentCombo);
            currentCombo.remove(currentCombo.size()-1);
        }

        helper(arr, k, index+1, ans, currentCombo);
    }
}