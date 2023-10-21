public class Solution {
    public static boolean sudokuSolver(int board[][]){

        /* Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Don't print output and return output as specified in the question.
         */
        //Looping through each cell 
        
        for(int i = 0; i<board.length; i++)
        {   
            for(int j = 0; j<board[0].length; j++)
            {
                //check if the cell is empty
                if(board[i][j] == 0)
                {
                    for(int k = 1; k<=9; k++)
                    {   
                        //If it is safe to put the current k value in the current cell then put it
                        if(isSafe(board, k,i, j))
                        {
                            board[i][j] = k;

                            if(sudokuSolver(board) == true)
                            return true;
                            else
                            board[i][j] = 0;
                        }
                    }
                    //We found empty cells but none of the numbers are safe to put, so return false
                    return false;
                }
            }
        }

        //The sudoku board is fully filled return true
        return true;
    }

    private static boolean isSafe(int [][] board, int k, int row, int col)
    {   
        //Check for the presence of k(current value under consideration) in same row, col and within the same sub sudoku board
        for(int i = 0; i< 9; i++)
        {
            //check on the same col
            if(board[i][col] == k)
            return false;

            //Check on the same row
            if(board[row][i] == k)
            return false;

            //Check for the same sub sudoku (3X3)
            //Why i%3 for col? because in case the col>3 then the col will restart from the initial value
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == k)
            return false;  
        }
        return true;
    }
}
