import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.

        //Time  - ~O(N)
        //Space-  O(N)
        // PriorityQueue<Long> sorted = new PriorityQueue<>();

        // for(Long i: a)
        // {
        //     sorted.offer(i);
        // }
        // for(Long i: b)
        // {
        //     sorted.offer(i);
        // }

        // for(int i = 0; i<a.length; i++)
        // {
        //     a[i] = sorted.poll();
        // }
        // for(int i = 0; i<b.length; i++)
        // {
        //     b[i] = sorted.poll();
        // }

        //Without using space - Naive - Time - O(N*M)
        //Space - O(1)

        // for(int i = 0; i< a.length; i++)
        // {   for(int j = 0; j<b.length; j++)
        //     {
        //         if(a[i] > b[j])
        //         {
        //             Long temp = a[i];
        //             a[i] = b[j];
        //             b[j] = temp;
        //         }
        //     }
            
        // }
        // Arrays.sort(b);


        //Optimal-1 Time - O(min(n,m)) + O(nlogn) + O(mlogm)
        //space - O(1)
        int left = a.length - 1;
        int right = 0;

        while(left >=0 && right < b.length)
        {   //the element at left array is bigger than the element at the right array so swap
            if(a[left] > b[right])
            {
                Long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }
            //the elements are equal or at correct arrays, from this point break because no point in 
            //comparing further elements as they are already at their correct positions
            else
            {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

    }
}