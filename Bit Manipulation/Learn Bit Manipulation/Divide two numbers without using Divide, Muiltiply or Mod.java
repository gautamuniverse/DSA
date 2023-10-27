public class Solution {
    public static int divideTwoInteger(int dividend, int divisor) {

        // Write your code here

        int ans = 0;

        boolean flag = false;

        if (dividend < 0) {

            flag = !flag;

            dividend = (-dividend);

        }

        if (divisor < 0) {

            flag = !flag;

            divisor = (-divisor);

        }

        while (dividend >= 0) {

            ans++;

            dividend -= divisor;

        }

        if (flag)
            return -(ans - 1);

        return ans - 1;

    }

}