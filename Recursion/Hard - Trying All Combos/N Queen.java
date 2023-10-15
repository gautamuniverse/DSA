//Optimal
//Time - O(N! * N)
//Space - O(N^2)
//We will optimise the time taken to check for the previous queen position to O(1) using hashing
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

          char [][] board = new char[n][n];
        //Prefill the board cells to .
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                board[i][j] = '.';
            }
        }

        int [] left=  new int[n];
        int [] upperDiagonal = new int [2*n - 1];
        int [] lowerDiagonal = new int [2*n - 1];

        helper(ans, board, left, upperDiagonal, lowerDiagonal, 0, n);
        return ans;
    }

    private static void helper(List<List<String>> ans,char[][] board,  int [] left, int [] upperDiagonal, int[] lowerDiagonal, int col, int n)
    {
        if(col == n)
        {
            ans.add(construct(board));
            return;
        }

        //Iterate over each row
        for(int row = 0; row< n; row++)
        {
            //check if it is safe to place queen at current cell
            if(left[row] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[n-1 + col - row] == 0)
            {   
                left[row] = 1; // Mark the row as occupied
                upperDiagonal[row + col] = 1; // Mark the upper diagonal as occupied
                lowerDiagonal[n - 1 + col - row] = 1; // Mark the lower diagonal as occupied
                board[row][col] = 'Q';
                helper(ans, board, left, upperDiagonal, lowerDiagonal, col+1, n);

                //backtrack
                left[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n-1 + col - row] = 0;
                board[row][col] = '.';
            }
        }
    }

    private static List<String> construct(char [][] board)
    {
        List<String> subList = new ArrayList<>();

        for(int i = 0; i< board.length; i++)
        {
            String currentRow = new String(board[i]);
            subList.add(currentRow);
        }

        return subList;
    } 
}



//Naive solution
//Space - O(N^2)
//Time - O(N! * N)
// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
         
//         char [][] board = new char[n][n];
//         //Prefill the board cells to .
//         for(int i = 0; i<n; i++)
//         {
//             for(int j = 0; j<n; j++)
//             {
//                 board[i][j] = '.';
//             }
//         }

//         //call the helper funciton which will work in DFS fashion to fill the columns
//         helper(ans, board, 0,n);
//         return ans;
//     }

//     private static void helper(List<List<String>> ans, char[][]board, int col, int n)
//     {
//         //Once arrangement found, conver the board into a List of strings and add to the final answer
//         if(col == n)
//         {
//             ans.add(construct(board));
//             return;
//         }

//         //iterate over each row 
//         for(int i = 0; i<n; i++)
//         {   
//             //Check if it safe to place the Q at the current cell
//             if(isSafe(board, i, col))
//             {
//                 board[i][col] = 'Q';
//                 helper(ans, board, col+1, n);
//                 //Backtrack to re-initiate the cell with '.'
//                 board[i][col] = '.';
//             }
//         }
//     }

//     private static boolean isSafe(char [][] board, int row, int col)
//     {
//         //make the duplicate copies of the row and col
//         int dupRow = row;
//         int dupCol = col;
        
//         //Check for the left direction
//         for(int i = 0; i<col; i++)
//         {
//             if(board[row][i] == 'Q')
//             return false;
//         }

//         //Check for the upper left diagnol (\)
//         while(dupRow >= 0 && dupCol >=0)
//         {
//             if(board[dupRow][dupCol] == 'Q')
//             {
//                 return false;
//             }

//             dupRow--;
//             dupCol--;
//         }

//         dupRow = row;
//         dupCol = col;

//         //Check for the bottom left diagnon (/)
//         while(dupRow <board.length && dupCol>= 0)
//         {
//             if(board[dupRow][dupCol] == 'Q')
//             {
//                 return false;
//             }

//             dupRow++;
//             dupCol--;
//         }

//         return true;
//     }

//     private static List<String> construct(char [][] board)
//     {
//         List<String> subList = new ArrayList<>();

//         for(int i = 0; i< board.length; i++)
//         {
//             String currentRow = new String(board[i]);
//             subList.add(currentRow);
//         }

//         return subList;
//     }
// }