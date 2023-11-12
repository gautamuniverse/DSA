class Solution {
    public long subArrayRanges(int[] nums) {
        //  long total = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int max = nums[i];
        //     int min = nums[i];

        //     for (int j = i; j < nums.length; j++) {
        //         max = Math.max(max, nums[j]);
        //         min = Math.min(min, nums[j]);
        //         total += (max - min);
        //     }
        // }
        // return total;

        //O(N) solution
        int n = nums.length;
        int nsl[] = new int [n]; //next smaller to left
        int nsr[] = new int [n]; //next smaller to right

        Arrays.fill(nsl, -1); //prefill the nsl to -1, means no nsl
        Arrays.fill(nsr, n);  //prefill the nsr to n, means no nsr

        int ngl[] = new int [n]; //next greater to left
        int ngr[] = new int [n]; //next greater to right

        Arrays.fill(ngl, -1); //prefill the ngl to -1, means no ngl
        Arrays.fill(ngr, n); //prefill the ngr to n, means no ngr

        Stack<Integer> st = new Stack<>();

        //calculate the nsl
        for(int i = 0; i<n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
            {
                st.pop();
            }

            if(!st.isEmpty())
            {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        //Calculate the nsr
        st.clear();

        for(int i = n-1; i>=0; i--)
        {
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
            st.pop();

            if(!st.isEmpty())
            {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        //Calculate the ngl

        st.clear();
        for(int i = 0; i<n; i++)
        {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i])
            {
                st.pop();
            }

            if(!st.isEmpty())
            {
                ngl[i] = st.peek();
            }
            st.push(i);
        }

        //calculate ngr
        st.clear();

        for(int i = n-1; i>= 0; i--)
        {
           while(!st.isEmpty() && nums[st.peek()] < nums[i])
            {
                st.pop();
            }

            if(!st.isEmpty())
            {
                ngr[i] = st.peek();
            }

            st.push(i);
        }

        long total = 0;
        //Calculate the sum of minimums and sum of maximums
        for(int i =0; i<n; i++)
        {   
            long leftMin = i - nsl[i];
            long rightMin = nsr[i] - i;


            long leftMax = i - ngl[i];
            long rightMax = ngr[i] - i;

            total+= (leftMax*rightMax - leftMin*rightMin) * nums[i];
        }
        
        return total;
    }
}