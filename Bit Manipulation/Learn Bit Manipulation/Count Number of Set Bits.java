public class Solution {
    public static int countSetBits(int n) {
        // Write your code here

        //Working method
        
        // int d = 2, ans = 0, x = N;
        // while (x > 0) {

        //     // Using the Mathematical formula explained in the Approach.
        //     ans += ((N + 1) / d) * (d / 2) + Math.max((N + 1) % d - d / 2, 0);

        //     // Window size double every time we shift to the next left bit.
        //     d *= 2;
        //     x /= 2;
        // }
        // return ans;


        //Below method gives tle for one test case

       int count = 0; // Initialize the count of set bits to 0.

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                // Check the rightmost bit.
                // If it is set (1), increment the count.
                if ((num & 1) == 1) {
                    count++;
                }
                // Right-shift to the next bit.
                num >>= 1;
            }
        }

        return count; // Return the total count of set bits from 1 to n.

    }
}