class Solution {
    public int sumSubarrayMins(int[] arr) {
     // Write your code here.

        // Bruteforce Solution
        // Time O(n^3)

        long mod = (long)1000000007;
        long total = 0;
        // Compute all the subarrays
        // for(int i = 0; i<arr.length; i++)
        // {
        // for(int j = i; j<arr.length;j++)
        // { int min = Integer.MAX_VALUE;

        // for(int k = i; k<=j; k++)
        // {
        // min = Math.min(min, arr[k]);
        // }
        // total = (total + min)%mod;
        // }
        // }

        // return total;

        // Little better O(n^2)
        // //Compute all the subarrays
        // for(int i = 0; i<arr.length; i++)
        // { int min = arr[i];
        // for(int j = i; j<arr.length;j++)
        // {
        // min = Math.min(min, arr[j]);
        // total = (total + min)%mod;
        // }

        // }

        // return total;

        // Optimal approach
        // Intuition : We will be finding the number of subarrays for which the current
        // indexed element is the minimum.
        // To find the minimums, we can find the NSR and NSL indices of the array
        // elements, and then we can easliy find the number of subarrays.

        int n = arr.length;

        // Declaring NSR and NSL arrays
        int nsr[];
        int nsl[];

        // Get the NSL and NSR
        nsl = getNSL(arr);
        nsr = getNSR(arr);
        

        // Compute the sum of subarray minimums
        for (int i = 0; i < n; i++) {
            // Calculate the count of minimum subarrays to the left and to the right of the
            // current element.
            int countL = i - nsl[i];
            int countR = nsr[i] - i;

            long totalCount = countL * countR;

            long totalSum = (totalCount * arr[i]);
            total = (total+ totalSum)%mod;
        }
        return (int)total;
    }

    private static int[] getNSL(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                    st.pop();
                }
                result[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(i);
        }
       
        return result;
    }

    private static int[] getNSR(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                result[i] = arr.length;
            } else {
                //Make the arr[i] <= arr[st.peek()] '<=' in either NSR or NSL. this will avoid the  duplicate subarrays.
                while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                    st.pop();
                }
                result[i] = st.isEmpty() ? arr.length : st.peek();
            }

            st.push(i);
        }
        return result;
    }
}