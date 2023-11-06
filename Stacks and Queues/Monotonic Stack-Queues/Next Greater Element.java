import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.

        //O(n^2) in worst case
        // Using hashmaps

        // Map<Integer, Integer> map = new HashMap<>();

        // int[] ans = new int[n];

        // ans[n - 1] = -1;
        // map.put(n - 1, arr[n - 1]);

        // for (int i = n - 2; i >= 0; i--) {
        //     if (arr[i] < arr[i + 1]) {
        //         ans[i] = arr[i + 1];
        //         map.put(i, arr[i]);
        //     } else {
        //         int j;
        //         // Traverse to thr right of the array to find the first occurance of greater
        //         // eelement to the right of the current element
        //         for (j = i + 1; j < n; j++) {
        //             if (map.containsKey(j) && map.get(j) > arr[i]) {
        //                 ans[i] = map.get(j);
        //                 map.put(i, arr[i]);
        //                 break;
        //             }
        //         }
        //         if (j >= n) {
        //             ans[i] = -1;
        //             map.put(i, arr[i]);
        //         }
        //     }
        // }

        // return ans;

        // O(n) using Stacks

        Stack<Integer> st = new Stack<>();
        int ans [] = new int [n];

        ans[n-1] = -1;
        st.push(arr[n-1]);

        for(int i = n-2; i>= 0; i--)
        {
            
            //Current element is greater than the stack top element, pop them out
            while(!st.isEmpty() && arr[i] >= st.peek())
            st.pop();

            //If stack not empty, assign topmost element to the ans[i]. it is sure to be greater than arr[i] because of the first while loop condition
            if(!st.isEmpty())
            {
                ans[i] = st.peek();
                st.push(arr[i]);
            }

            //else no element found greater than arr[i] to the right, assign -1
            else
            {
                ans[i] = -1;
                st.push(arr[i]);
            }
        }

        return ans;
    }
}