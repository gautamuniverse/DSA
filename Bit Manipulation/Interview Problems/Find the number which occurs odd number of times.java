public class Solution{
    public static int missingNumber(int n, int []arr){
        // Write your code here.

        //Time complexity : O(N)

        //Approach : Xor of two same numbers results in 1.
        // so if take xor of all the numbers  then even numbered numbers will go away and only the odd numbered numbers will remain.

        int xor = 0;
        for(int i : arr)
        {
            xor= xor^i;
        }

        return xor;
    }
}