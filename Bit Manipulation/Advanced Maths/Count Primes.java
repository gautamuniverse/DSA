import java.util.List;
import java.util.*;

public class Solution {
    public static List< Integer > countPrimes(int n) {
        // Write your code here.

        //O(N*logN)
        List<Integer> ans = new ArrayList<>();

        for(int i = 2; i<= n; i++)
        {
            if(checkPrime(i) && n%i == 0)
            {
                ans.add(i);
            }
        }

        return ans;
    }

    private static boolean checkPrime(int n)
    {
        for(int i = 2; i*i<=n; i++)
        {
            if(n % i == 0)
            return false;
        }
        return true;
    }
}
