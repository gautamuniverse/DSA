class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Naive solution: O(matrix.length * log2(matrix[0].length))
        // for(int i = 0; i< matrix.length; i++)
        // {  
        //     if(binarySearch(matrix[i], target) != -1)
        //     return true;
        // }

        // return false;


        //Best approach : Elimination(Binary Search)
        //Time : O(n + m)
        //Space : O(1)

        int row =0;
        int col = matrix[0].length-1;
        
        //setting boundations
        while(row < matrix.length && col >= 0)
        {   
            //element found, return true
            if(matrix[row][col] == target)
            return true;
            //the element is bigger hence it must be in the bottom of the current col, increase row
            else if(matrix[row][col] < target)
            row++;

            //current element is lesser hence it must be in the left side of the current element, decrease col
            else
            col--;
        }

        //element was not found
        return false;
        
    }

     private static int binarySearch(int [] arr, int target)
    {   

        int n = arr.length;

        int low = 0;
        int high = n-1;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] > target)
            {
                high = mid-1;
            }
            else
             low = mid+1;
        }
        return -1;
    }
}