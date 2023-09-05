public class Solution {
    public static int NthRoot(int n, int m) {
		//Optimal solution using Binary Search   O(log (n+m))

		long high = m;
		long low = 0;
		while(low<= high)
		{
			long mid = (low+high)/2;
			//Check the condition that if the current multiplication is equal to m then it is our answer
            
            if((long)Math.pow(mid, n) == m)
			{
				return (int)mid;
			}
			else if((long)Math.pow(mid, n) < m)
			low = mid+1;
            
            else
            high = mid-1;
		}
        //We couldn't find any answer
		return -1;
    }
}
