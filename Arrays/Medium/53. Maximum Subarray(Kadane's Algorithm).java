class Solution {
    public int maxSubArray(int[] arr) {
        //Kadane's linear time complexity algorithm
		int maxSum = arr[0];
		int sum = 0;
		for(int i : arr)
		{
			sum += i;
			
			if(sum > maxSum)
			maxSum = sum;
			
			if(sum < 0)
			sum = 0;
	
		}

		return maxSum;
    }
}