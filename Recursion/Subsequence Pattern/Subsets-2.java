//Optimal Approach

// Time Complexity: O(2^n) for generating every subset and O(k)  to insert every subset in another data structure if the average length of every subset is k. Overall O(k * 2^n).

// Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void helper(int [] arr, int index, List<List<Integer>> ans, ArrayList<Integer> currentCombo)
    {   
        ans.add(new ArrayList<>(currentCombo));
        for(int i = index; i < arr.length; i++)
        {
            // Skip the current index if the previous element is equal, we want to avoid duplicates
            if(i!= index && arr[i] == arr[i-1]) continue;

            //Pick
            currentCombo.add(arr[i]);
            helper(arr, i+1, ans, currentCombo);

            //Don't pick
            currentCombo.remove(currentCombo.size()- 1);
        }
    }
}





// -------------NAIVE APPROACH-------------

// Time Complexity: O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log( x)  to insert every combination of average length k in a set of size x. After this, we have to convert the set of combinations back into a list of list /vector of vectors which takes more time.

// Space Complexity:  O(2^n * k) to store every subset of average length k. Since we are initially using a set to store the answer another O(2^n *k) is also used.

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Set<ArrayList<Integer>> set = new HashSet<>();
//         Arrays.sort(nums);
// 		helper(nums, set, 0, new ArrayList<>());

// 		List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
// 	}

// 	private static void helper(int [] arr, Set<ArrayList<Integer>> ans, int index, ArrayList<Integer> currentSubset)
// 	{
// 		if(index == arr.length)
// 		{   
// 			ans.add(new ArrayList<>(currentSubset));
// 			return;
// 		}


// 		//Pick
// 		currentSubset.add(arr[index]);
// 		helper(arr, ans, index+1, currentSubset);

		
// 		//Don't pick
// 		currentSubset.remove(currentSubset.size()-1);
// 		helper(arr, ans, index+1, currentSubset);
// 	}
// }