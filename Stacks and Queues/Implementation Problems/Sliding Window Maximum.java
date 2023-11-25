import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        // Write your code here.n

		//Naive Solution - O(N^2)

		// int totalMaximums = n - k + 1;
		// int maximums[] = new int [totalMaximums];

		// for(int i = 0; i<totalMaximums; i++)
		// {	

		// 	int max = Integer.MIN_VALUE;
		// 	for(int j = i; j<i+k && j<n; j++)
		// 	{
		// 		max = Math.max(max, arr[j]);
		// 	}
		// 	maximums[i] = max;
		// }

		// return maximums;

		//Optimal Solution:
		//Approach:
		
		/* Every time before entering a new element, we first need to check 
		whether the element present at the front is out of bounds of our 
		present window size. If so, we need to pop that out. Also, we need 
		to check from the rear that the element present is smaller than the 
		incoming element. If yes, theres no point storing them and hence we 
		pop them out. Finally, the element present at the front would be our 
		largest element */

		// Time - O(N + N)

		int ans[] = new int [n - k + 1];
		int index = 0;

		Deque<Integer> dq = new ArrayDeque<>();

		for(int i = 0; i<n; i++)
		{
			//Remove out of range numbers
			if(!dq.isEmpty() && dq.peek() == i-k)
			{
				dq.poll(); //poll from front
			}

			//remove smaller elements in range k as they are useless
			while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
			dq.pollLast();

			//Push the current index from the last
			dq.offerLast(i);

			//now if the window size has become k then put the greatest element in the current 
			//window into the ans array
			if(i >= k - 1)
			{
				ans[index++] = arr[dq.peekFirst()]; //The element at  the front is greatest as we are maintaing the elemens in the decreasing fashion
			}
		}

		return ans;
	}
}