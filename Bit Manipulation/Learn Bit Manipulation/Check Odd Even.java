public class Solution {
    public static String oddEven(int N){
        // Write your code here.

        //The lsb of an odd number will always be 1 and for an even number it will be 0
        if((N & 1) == 0)
        return "even";
        else
        return "odd";

    }
}