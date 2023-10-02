import java.util.*;
public class Solution {
    public static List< Integer > goodNumbers(int a, int b, int digit) {
        // Write your code here.
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = a; i<=b; i++)
        {   if(i%10 == digit)
            continue;

            if(isGood(i/10, digit, i%10))
            arr.add(i);
        }

        return arr;
    }

    private static boolean isGood(int num, int digit, int sum)
    {   
        if(num<=0)
        return true;

        int rem = num%10; // Curr digit
        if(rem <= sum || rem == digit)
        {
            return false;
        }

        return isGood(num/10, digit, sum+rem);
         
    }
}