import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i<k; i++)
		{
			int len = kArrays.get(i).size();
			for(int j = 0; j< len; j++)
			{
				pq.add(kArrays.get(i).get(j));
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while(!pq.isEmpty())
		{
			ans.add(pq.remove());
		}
		return ans;
	}
}
