//Also note that we can generate any index element asked to us by using the following formula
//(r-1)C(c-1)  where r is the row number and c is the column number, and C is Combination

//We can generate a row if asked using the below generateRow function

import java.util.*;

class Solution {

    private static List<Integer> generateRow (int row)
    {   List<Integer> rowList = new ArrayList<>();
        rowList.add(1);

        int ans =1;
        for(int col =1; col<row; col++)
        {   //Generating each row element using the formula --> (prevAns*(rowNumber - colNumber))/(colNumber)
            ans = ans*(row-col);
            ans = ans / col;
            rowList.add(ans);
        }

        return rowList;
    }
    public List<List<Integer>> generate(int numRows) {
       //Most optimal approach  -- T - O(N^2)
    //Space -  O(1), as taking list is part of the question
        List<List<Integer>> ans= new ArrayList<>();

        for(int i = 1; i<=numRows; i++)
        {
            ans.add(generateRow(i));
        }

        return ans;
    }
}



//2d array Type

//import java.util.*;
//
//public class Solution {
//    private static int[] generateRow(int row) {
//        int ans[] = new int[row + 1];
// 
//        ans[0] = 1;
//        for (int col = 1; col <= row; col++) {
//            // Generating each row element using the formula --> (prevAns * (rowNumber - colNumber)) / colNumber
//            ans[col] = ans[col - 1] * (row - col + 1);
//            ans[col] = ans[col] / col;
//        }
//
//        return ans;
//    }
//
//    public static int[][] pascalTriangle(int N) {
//        int arr[][] = new int[N][];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = generateRow(i);
//        }
//
//        return arr;
//    }
//}
