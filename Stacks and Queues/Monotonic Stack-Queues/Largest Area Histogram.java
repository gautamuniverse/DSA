//Intuition:
//The maximum area of a rectangle that an index of height 'h' can form depends on the next smaller building on either side. If the next index value is greater, there is no issue in considering the current index, as we can easily incorporate the area contributed by the current index. For example, consider the sequence 2, 1, 4, 5, 2. Here, for index 0, the maximum area can be only 2 because the index to its right is smaller, and it cannot contribute to a larger area. In contrast, for a case like 3, 2, we might argue that 2 can contribute to a greater area, such as 4. However, the area of 4 will be realized when we reach index 1, as it considers 3 and then forms the area 4.

class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] NSL = NSL(heights);
        int [] NSR = NSR(heights);

        int maxArea = Integer.MIN_VALUE;

        for(int  i = 0; i< heights.length; i++){

          //Formula to calculate the max area of the rectangle
          //We here will consider the max area that can be formed for each index individually, we will check what's the max area to the left and to the right of the current index that can be formed if we consider the current index.
          int areaRight = (NSR[i] - i)*heights[i];
          int areaLeft = (i - NSL[i])*heights[i];

          //The final area when we consider the current index  is area to the left + area to the right and subtracting the area of the index itself because we have considered the area 0f the index two times while calculating the arealeft and arearight.
          int currentIndexMaxAreaContribution = areaLeft+areaRight- heights[i];

          maxArea = Math.max(maxArea, currentIndexMaxAreaContribution);
        }

        return maxArea;
    }

    private static int[] NSL(int[] arr)
      {
          Stack<Integer> st = new Stack<>();
          
          int[] nsl = new int[arr.length];
          Arrays.fill(nsl, -1);

          for(int i = 0; i<arr.length; i++)
          {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
              st.pop();
            }

            if(!st.isEmpty())
            nsl[i] = st.peek();

            st.push(i);
          }

        return nsl;
      }
       private static int[] NSR(int[] arr)
      {
          Stack<Integer> st = new Stack<>();
          
          int[] nsr = new int[arr.length];
          Arrays.fill(nsr, arr.length);

          for(int i = arr.length - 1; i>=0; i--)
          {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
              st.pop();
            }

            if(!st.isEmpty())
            nsr[i] = st.peek();

            st.push(i);
          }

        return nsr;
      }
}