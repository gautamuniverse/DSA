import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<String> validParenthesis(int n){
        // Write your code here.

        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        helper(n, s, arr, 0,0); 
        return arr;
    } 

    private static void helper(int n, String s, ArrayList<String> arr, int open, int close)
    {   

        if(s.length() == 2*n)
        { 
            arr.add(s);
            return;
        }
            if(open< n)
            helper(n, s+"(", arr, open+1, close);
            if(close < open)
            helper(n, s+")", arr, open, close+1);
    }
}