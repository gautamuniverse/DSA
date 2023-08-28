import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

// import jdk.internal.jshell.tool.resources.l10n;

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        //Space = O(N)
        //Time - O(n logn) + O(n)
        // HashMap<Integer, Integer> map = new HashMap<>();
        // Arrays.sort(a);
        // int [] ans = new int[2];
        // int num = 1;
        // for(int i : a)
        // {   
        //     if(map.containsKey(i))
        //     {
        //         ans[0] = i;
        //         map.put(i, 2);
        //     }
        //     else
        //     map.put(i, 1);
        // }

        // for(int i = 1; i<=a.length; i++)
        // {
        //     if(map.containsKey(i))
        //     {
        //         continue;
        //     }
        //     else
        //     {
        //         ans[1] = i;
        //         break;
        //     }
        // }

        // return ans;

        //Hashing using Array
        //Time - O(2N)
        //Space - O(N)
        // int ans [] = new int[a.length+1];

        // for(int i: a)
        // {
        //     ans[i]++;
        // }
        // int finalAns[] = new int [2];
        // for(int i = 1; i<=a.length; i++)
        // {
        //     if(ans[i] == 2)
        //     {
        //         finalAns[0] = i;
        //     }
        //     if(ans[i] == 0)
        //     {
        //         finalAns[1] = i;
        //     }
        // }

        // return finalAns;

        //Mathematic approach
        // TIme -  O(N)
        // Space - O(1)

        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;

    }
}