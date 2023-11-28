import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
		// Write your code here.

		// Solving using Sliding window
		// Time- O(2N) , Space - O(1)
		// int l=0;
		// int zeroCount = 0;
		// int maxAns = 0;

		// for(int r = 0; r<arr.size(); r++)
		// {
		// if(arr.get(r) == 0)
		// zeroCount++;

		// //We are out of zero's budget, shrink the window
		// while(zeroCount > k)
		// {
		// if(arr.get(l) == 0)
		// zeroCount--;

		// l++;
		// }
		// //For each window calculate the max consecutive 1s
		// maxAns = Math.max(maxAns, r - l + 1);
		// }

		// return maxAns;

		// Optimal - O(N)
		int l = 0, r;

		for (r = 0; r < arr.size(); r++) {
			if (arr.get(r) == 0)
				k--;

			if (k < 0) {
				if (arr.get(l++) == 0)
					k++;
			}
		}
		return r - l;
	}
}