import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] countGreater(int[] arr, int[] query) {
        // Write your code here.

        // Naive time - O(query.length * arr.length)
        // int ans [] = new int [query.length];

        // for(int i = 0; i<query.length;i++)
        // {
        // for(int j = query[i]+1; j< arr.length; j++)
        // {
        // if(arr[j] > arr[query[i]])
        // ans[i] = ans[i]+=1;
        // }
        // }

        // return ans;

        // Optimal solution - time - O(N), space - O(n)

        int[] counts = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }
            counts[i] = count;
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            result[i] = counts[query[i]];
        }

        return result;

    }
}