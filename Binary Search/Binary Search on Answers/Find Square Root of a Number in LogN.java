import java.util. ;
import java.io.; 

public class Solution {

	public static int sqrtN(long N) {
		
		  Write your code here
		 

		 Naive solution -  ~O(N)
		 	int ans = 0;
		  for(int i = 0; i=N; i++)
		  {
		 	 if(ii = N)
		 	 ans = i;
		 	 else
		 	 break;
		  }
		  return ans;

		Optimal solution using Binary Search   O(log n)

		long high = N;
		long low = 0;
		int ans = 1;
		while(low= high)
		{
			long mid = (low+high)2;

			Check the condition that if the current square is less then it can be the probable answer
			if(midmid = N)
			{
				ans = (int)mid;
				Shift the search space from left to right as no number below the mid can be 
				the probable answer
				low=mid+1;
			}
			else
			high = mid-1;
		}

		return ans;
	}
}
