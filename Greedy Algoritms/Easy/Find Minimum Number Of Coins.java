//optimal - O(n)

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        int coins [] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> ans = new ArrayList<>();
        //Greedy approach
        for(int i = (coins.length - 1); i>=0; i--)
        {
            while(n >= coins[i])
            {
                n-=coins[i];
                ans.add(coins[i]);
            }
        }

        return ans;

    }
}




//Binary Search solution: O(log n)

// import java.util.ArrayList;
// import java.util.List;
// public class Solution {
//     public static List<Integer> MinimumCoins(int n) {
//         // Write your code here.
//         int coins [] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
//         List<Integer> ans = new ArrayList<>();
//         while(n != 0)
//         {
//            int curr = findCoin(coins, n);
//            n -= curr;
//            ans.add(curr);
//         }
//         return ans;
//     }

//     private static int findCoin(int [] coins, int n)
//     {   
//         int low = 0;
//         int high = coins.length - 1;
//         while(low <= high)
//         {
//             int mid = (low + high)/2;

//             if(coins[mid] > n)
//             {
//                 high = mid - 1;
//             }
//             else
//             {
//                 low = mid + 1;
//             }
//         }

//         return coins[high];
//     }
// }
