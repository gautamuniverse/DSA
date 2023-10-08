import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..

        ArrayList<Integer> ans = new ArrayList<>();

        helper(num, ans, 0, 0);

        //Sort the final sum list
        Collections.sort(ans);
        return ans;
    }

    private static void helper(int arr[], ArrayList<Integer> ans, int index, int sum)
    {   
        //We traversed the whole length of the array, store the sum acquired.
        if(index == arr.length)
        {
            ans.add(sum);
            return;
        }
        //Pick
        helper(arr, ans, index+1, sum+ arr[index]);
    
        //Don't pick
        helper(arr, ans, index+1, sum);
    }

}