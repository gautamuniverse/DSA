public class Solution {
    public static int[] findPeakGrid(int [][]G){
        // Write your code here.
        //Naive - O(n * m). return the greatest element of the matrix

        //Best approach - use the find peak element in the 1d array intuition 
        //Time - O(n * log2(m))
        //Intuition
        //Apply binary search on the column numbers
        //Find the max element from that column and then get the row index of that greatest element
        //Now compare that greatest element with its right and left element, 
        //if the current elment is greater than its left and right, it is peak
        //else check if it is less than its left, then discard the left cols
        //else discard the right cols

        int low = 0;
        int high = G[0].length-1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            int row = findGreatest(G, mid);
            int left = mid-1>=0?G[row][mid-1]:-1;
            int right = mid+1<G[0].length?G[row][mid+1]:-1;

            if(G[row][mid] > left && G[row][mid]> right)
            {
                int [] ans = {row, mid};
                return ans;
            }

            else if(G[row][mid] < G[row][mid-1])
            high = mid-1;
            else
            low = mid+1;
        }
        int [] ans = {-1, -1};
        return ans;

    }

    private static int findGreatest(int [][]arr, int col)
    {
        int rowIndex = -1;
        int greatest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i][col] > greatest)
            {
                greatest = arr[i][col];
                rowIndex = i;
            }
        }

        return rowIndex;
    }
}