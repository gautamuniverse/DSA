
public class Solution {
    public static double myPow(double x, int n) {

        //Bruteforce

        // Handle edge cases
        // if (n == 0) {
        //     return 1.0;
        // }
        // if (x == 0.0) {
        //     return 0.0;
        // }

        // double ans = 1.0;
        // long absN = Math.abs((long) n); // Handle potential overflow for INT_MIN

        // for (long i = 0; i < absN; i++) {
        //     ans *= x;
        // }

        // return (n < 0) ? 1.0 / ans : ans;


        //optimal
        double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
        if (nn % 2 == 1) {
            ans = ans * x;
            nn = nn - 1;
        } else {
            x = x * x;
            nn = nn / 2;
        }
        }
        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
}
