// O(N * M * 4^S), where N is the number of rows, M is the number of columns, 
// and S is the length of the target word.

public class Solution {
    public static boolean present(char [][]board, String word, int n, int m) {
        // Write your code here.

            //Find the first occurance of the word's first character in the board
            for(int i = 0; i<n; i++)
            {
                for(int j = 0; j<m; j++)
                {   
                
                    if(helper(board, word, 0, i, j))
                    {   
                        //First occurance found which eventually lead to the word being found
                        return true;
                    }
                }
            }
            return false;
    }

    private static boolean helper(char [][] board, String word,int index, int row, int col)
    {   

        if(index >= word.length())
        return true;

        if(row>= board.length || row <0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(index))
        {
            return false;
        }

        boolean a1, a2, a3, a4;
        char currentChar = board[row][col];
        //mark the current cell as visited
        board[row][col] = '#';
            //Check next row
            a1 = helper(board, word, index+1, row+1, col);

            //check in next col
            a2 = helper(board, word, index+1, row, col+1);

            //check in prev col
            a3 = helper(board, word, index+1, row, col-1);

            //check in prev row
            a4 = helper(board, word, index+1, row-1, col);

        boolean result = a1||a2||a3||a4;

        //restore the cell character
        board[row][col] = currentChar;

        return result;
    }
}