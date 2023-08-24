import java.util.*;
public class Solution {
    public static List<List<Integer>> fourSum(int []arr, int target) {
        // Write your code here.

        // //Extreme Bruteforce -  O(n^3logn)

        // int n = arr.length;

        // Set<List<Integer>> st = new HashSet<>();

        // for (int i = 0; i < n; i++) {
            
        //     for (int j = i + 1; j < n; j++) {
        //         Set<Integer> hashset = new HashSet<>();
        //        for(int k = j+1; k<n; k++)
        //        {
        //             //Calculate the 4th element:
        //         int fourth = target -(arr[i] + arr[j]+ arr[k]);

        //         //Find the element in the set:
        //         if (hashset.contains(fourth)) {
        //             List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
        //             temp.sort(null);
        //             st.add(temp);
        //         }
        //         hashset.add(arr[k]);
        //        }
        //     }
        // }

        // // store the set elements in the answer:
        // List<List<Integer>> ans = new ArrayList<>(st);
        // return ans;

        //Optimal Solution
        // Time - O(n^3)
        // Space -  O(n)
        int n = arr.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(arr);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }
}