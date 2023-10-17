import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> ratMaze(int [][]mat) {
        // Write your code here.
        List<String> ans = new ArrayList<>();

        String combination = "";
        if (mat[0][0] == 1) {
            helper(mat, ans, combination, 0, 0);
        } else {
            //no valid path from source, hence return -1
            ans.add("-1");
        }
        return ans;

    }

    private static void helper(int [][] mat, List<String> ans,String combination, int row, int col)
    {   //Combination found
        if(row == mat.length-1 && col == mat.length-1)
        {
            ans.add(combination);
            return;
        }
        
        // //Edge case
        // if(row >= mat.length || col >= mat.length || row <0 || col <0)
        // return;

        
        
        

        //check what is the next possible direction
        //down
        if(row != mat.length-1 && mat[row+1][col] != 0)
        {
            combination+='D';
            //MARK CELL VISITED
            mat[row][col] = 0;
            helper(mat, ans, combination, row+1, col);

            //backtrack
            mat[row][col] = 1;

            combination=combination.length()>1?combination.substring(0,combination.length()-1):"";
        }

        //Up
        if(row != 0 && mat[row-1][col] != 0)
        {
            combination+='U';
            //MARK CELL VISITED
            mat[row][col] = 0;
            helper(mat, ans, combination, row-1, col);

            //backtrack
            mat[row][col] = 1;
            combination=combination.length()>1?combination.substring(0,combination.length()-1):"";
        }

        //left
        if(col != 0 && mat[row][col-1] != 0)
        {
            combination+='L';
            //MARK CELL VISITED
            mat[row][col] = 0;
            helper(mat, ans, combination, row, col-1);

            //backtrack
          mat[row][col] = 1;

            combination=combination.length()>1?combination.substring(0,combination.length()-1):"";
        }

        //right
        if(col!= mat.length-1 && mat[row][col+1] != 0)
        {
            combination+='R';
            //MARK CELL VISITED
            mat[row][col] = 0;
            helper(mat, ans, combination, row, col+1);

            //backtrack
            mat[row][col] = 1;
            combination=combination.length()>1?combination.substring(0,combination.length()-1):"";
        }
    }

}