
public class Solution {
    public static int createAtoi(String str) {
        // Write your code here.

        //Iterative Code;
        //  Time Complexity: O(N)
        //  Space Complexity: O(1)

        //Base case, checking first two chars
        //  int index = 0;
        // int sign = 1;
        // int result = 0;

        // // Remove leading whitespace
        // while (index < str.length() && str.charAt(index) == ' ') {
        //     index++;
        // }

        // // Check for sign character
        // if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
        //     sign = (str.charAt(index) == '-') ? -1 : 1;
        //     index++;
        // }

        // // Process digits
        // while (index < str.length() && Character.isDigit(str.charAt(index))) {
        //     int digit = str.charAt(index) - '0';

        //     // Check for integer overflow
        //     if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
        //         return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //     }

        //     result = result * 10 + digit;
        //     index++;
        // }

        // return result * sign;


        //Recursive Solution
        //Time - O(N)
        //Space -  O(N) -  recursion call stack
        if(str.length() == 0)
        return 0;
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' ')
        {
            ++index;
        }
        if(index >= str.length())
        return 0;
        
        int sign = 1;
        if(str.charAt(index) == '-')
        {
            sign = -1;
            index++;  
        }
        else if(str.charAt(index) == '+')
        index++;



        return (int)atoiHelper(str, index, sign, 0);

    }

    private static long atoiHelper(String str, int index, int sign, long result)
    {   
        if(sign * result >= Integer.MAX_VALUE)
        return Integer.MAX_VALUE;

        if(sign * result  <= Integer.MIN_VALUE)
        return Integer.MIN_VALUE;

        if(index >= str.length() || str.charAt(index) < '0' || str.charAt(index) > '9')
        return sign*result;

        
        result = atoiHelper(str, index+1, sign, (result*10 + (str.charAt(index)-'0')));

        return result;
    }
}
