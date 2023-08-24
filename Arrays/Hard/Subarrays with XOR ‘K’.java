import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraysWithSumK(int[] a, int b) {
        
        //Bruteforce O(N^2)
        // int count = 0;
        // for (int i = 0; i < a.length; i++) {
        //     int xor = 0;
        //     for (int j = i; j < a.length; j++) {
        //         xor ^= a[j];
        //         if (xor == b) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

        //Optimal approach- t - O(N)  space - O(N)
          int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^b:
            int x = xr ^ b;

            // add the occurrence of xr^b
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }
}