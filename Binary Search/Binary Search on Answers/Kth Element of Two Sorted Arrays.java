import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n, int m, int z) {
        // Write your coder here
        //Naive approach
        //Space - O(n+m)
        //Time - O(m+n)

        // int arr3[] = new int [m+n];

        // int i = 0;
        // int j = 0;
        // int k = 0;
        // while(i < n && j <m)
        // {
        //     if(arr1.get(i) <= arr2.get(j))
        //     {
        //         arr3[k] = arr1.get(i);
        //         i++;
        //         k++;
        //     }
        //     else
        //     {
        //         arr3[k] = arr2.get(j);
        //         j++;
        //         k++;
        //     }
        // }

        // while(i < n)
        // {
        //     arr3[k] = arr1.get(i);
        //     i++;
        //     k++;
        // }

        // while(j<m)
        // {
        //     arr3[k] = arr2.get(j);
        //     j++;
        //     k++;
        // }

        // return arr3[z-1];


        //better approach, space - O(1). time - O(n+m)
        // int count = 0;
        // int i = 0;
        // int j = 0;

        // while(i < n && j<m)
        // {   
            


        //     if(arr1.get(i) <= arr2.get(j))
        //     {   
        //         if(count == z-1)
        //         {
        //             return arr1.get(i);
        //         }

        //         i++;
        //         count++;
        //     }
        //     else
        //     {
        //         if(count == z-1)
        //         {
        //             return arr2.get(j);
        //         }
        //         j++;
        //         count++;
        //     }
        // }

        // while(i< n)
        //     {   
        //         if(count == z-1)
        //         {
        //             return arr1.get(i);
        //         }

        //         i++;
        //         count++;
        //     }
        //   while(j < m)
        //     {
        //         if(count == z-1)
        //         {
        //             return arr2.get(j);
        //         }
        //         j++;
        //         count++;
        //     }
               
        // return 0;

        //Optimal approach -  Binary Search
        //Same approach as used in the median of two sorted arrays
        

        if(m>n) return kthElement(b, a, m, n, z);

        int total = (n + m);

        int low = Math.max(0, z-m);
        int high = Math.min(z, n);

        while(low <= high)
        {   
            //mid1 represent number of elements from arr1, to make left half
            //mid2 represents number of elements from arr2, to make the left half
            int mid1 = (low + high)/2;
            int mid2 = z-mid1;

            int l1 = (mid1>0) ? a.get(mid1-1):Integer.MIN_VALUE;
            int l2 = (mid2>0) ? b.get(mid2-1):Integer.MIN_VALUE;
            int r1 = (mid1<n) ? a.get(mid1):Integer.MAX_VALUE;
            int r2 = (mid2<m) ? b.get(mid2):Integer.MAX_VALUE;

            //We have found our answer
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;
    }

}