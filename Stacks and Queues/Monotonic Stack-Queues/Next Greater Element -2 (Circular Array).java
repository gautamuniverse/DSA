// Time - O(2n + 2n)
// space - O(n)

class Solution {
    public int[] nextGreaterElements(int[] a) {
         int n = a.length;
        int [] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 2*n-1; i>=0; i--)
        {
            //if the current element is greater than the stack top, pop the stack
            while(!st.isEmpty() && st.peek() <= a[i%n])
            {
                st.pop();
            }

            //If the current index is greater than n, we dont require next greater element
            if(i < n)
            {
                if(!st.isEmpty())
                ans[i] = st.peek();

                else
                ans[i] = -1;
            }
            st.push(a[i%n]);
        }

        return ans;
    }
}