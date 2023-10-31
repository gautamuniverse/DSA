public class Solution {
    public static int power(int N, int R) {
        long result = 1;
        long base = N;
        int exponent = R;
        long mod = 1000000007;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent /= 2;
        }

        return (int) result;
    }
}


//Brute
public class Solution {
    public static int power(int N, int R){
        // Write your code here.
        return (int) calPower(N, R);
    }

    private static long calPower(int n, int x)
    {   
        if(x <= 0)
        return 1;

        if(x == 1)
        return n;

        long a1 = 1, a2 = 1, a3 = 1, a4= 1;
        if(x%2 == 1)
        {
            a1 = calPower(n, x/2);
            a2 = calPower(n, x - (x/2));
        }
        else
        {
            a3 = calPower(n, x/2);
            a4 = calPower(n, x/2);
        }

        long mod = 1000000007;
        long result = (a1*a2*a3*a4)%mod;
        return result;

    }
}