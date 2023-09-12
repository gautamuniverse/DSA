import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // Write your code here.

        //Naive- use binary search on each row
        // for(int i =0; i<mat.size(); i++)
        // {
        //     if(binarySearch(mat.get(i), target))
        //     return true;
        // }

        // return false;

        //Better approach, take advantage of the first element of the row
        
        // int low = 0;
        // int high = mat.size() - 1;
        // int ithIndex = -1;
        // while(low <= high)
        // {
        //     int mid = (low + high)/2;
        //     if(mat.get(mid).get(0) == target)
        //     return true;

        //     else if(mat.get(mid).get(0) > target)
        //     {
        //         high = mid-1;
        //     }
        //     else
        //     {   
        //         ithIndex = low;
        //         low = mid+1;
        //     }
        // }

        // if(low == -1 || low == 0)
        // return false;

        // if(binarySearch(mat.get(low-1), target))
        // return true;

        // return false;

        //Best Approach -  flatten the 2d array into 1d array of n*m size
        //then determine the 2d index out of the 1d index
        //formula to get the 2d index from the 1d index:
        //   row : 1dIndex/m
        //   col : 2dIndex%m
        //then perform the binary search on the hypothetical 1d array without actually storing
        // the elements
        int n = matrix.size();
        int m = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
        
    }

    private static boolean binarySearch(ArrayList<Integer> arr, int target)
    {   

        int n = arr.size();

        int low = 0;
        int high = n-1;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(arr.get(mid) == target)
            {
                return true;
            }
            else if(arr.get(mid) > target)
            {
                high = mid-1;
            }
            else
             low = mid+1;
        }
        return false;
    }

}
