import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []a, int k) {
		// Write your code here.

		HashMap<Integer, Integer> map = new HashMap<>();

		int maxLength = 0;
		int sum = 0;
		for(int i = 0; i<a.length; i++)
		{	int length = 0;
			sum+=a[i];

			//Check if sum equal to k, update the length
			if(sum == k)
			{
				length = i +1;
				maxLength = Math.max(length, maxLength);
			}
			//Calculate the remaining prefix sum that is sum - k
			int rem = sum - k;

			//Check if the remaining sum is present in the hashmap
			if(map.containsKey(rem))
			{
				maxLength = Math.max(maxLength, i - map.get(rem));
			}

			//Update the map entry
			if(!map.containsKey(sum))
			{
				map.put(sum, i);
			}

		}

		return maxLength;
	}
}