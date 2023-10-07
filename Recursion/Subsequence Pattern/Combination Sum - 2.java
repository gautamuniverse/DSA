
//Optimal approach; Time : O(2^n * k)

//Solution from -> https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/

import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        //    Write your code here.
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(arr, 0, target, ans, new ArrayList<>());

        return ans;
    }

    private static void helper(ArrayList<Integer> arr, int index, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currentCombo)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(currentCombo));
            return;
        }


        for(int i = index; i<arr.size(); i++)
        {
            //possibility of picking current element, check if not already picked.
            if(i > index && arr.get(i) == arr.get(i-1)) continue;
            
            //If current element greater than the target then break, no point checking since the elements are sorted
            if(arr.get(i) > target)
            break;

            currentCombo.add(arr.get(i));
            helper(arr, i+1, target-arr.get(i), ans, currentCombo);
            currentCombo.remove(currentCombo.size()-1);
        }
    }
}



// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.HashSet;
// import java.util.Set;


// ///Naive Approach - Time- O(2^n*k * log(Set Size))

// class LexicographicSort implements Comparator<ArrayList<Integer>>{
//      @Override
//     public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
//         // Compare the elements lexicographically in each child list
//         int minLength = Math.min(list1.size(), list2.size());
//         for (int i = 0; i < minLength; i++) {
//             int elementComparison = list1.get(i).compareTo(list2.get(i));
//             if (elementComparison != 0) {
//                 return elementComparison;
//             }
//         }

//         // If the common elements are the same, the shorter list comes first
//         return Integer.compare(list1.size(), list2.size());
//     }
// }
// public class Solution 
// {
//     public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
//     {
//         //    Write your code here.

//         Collections.sort(arr);

//         Set<ArrayList<Integer>> ans = new HashSet<>();

//         helper(arr, 0, target, ans, new ArrayList<>());
//         ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>(ans);
//         Collections.sort(finalAns, new LexicographicSort());
//         return finalAns;
//     }

//     private static void helper(ArrayList<Integer>arr, int index, int target, Set<ArrayList<Integer>> ans,ArrayList<Integer> currentCombo)
//     {
//         if(target == 0)
//         {
//             ans.add(new ArrayList<>(currentCombo));
//             return;
//         }

//         if(index == arr.size())
//         {
//             if(target == 0)
//             {
//                 ans.add(new ArrayList<>(currentCombo));
//             }
//             return;
//         }


//         //Take
//         currentCombo.add(arr.get(index));
//         helper(arr, index+1, target-arr.get(index), ans, currentCombo);
        
//         currentCombo.remove(currentCombo.size()-1);

//         //Not take
//         helper(arr, index+1, target, ans, currentCombo);
//     }
// }