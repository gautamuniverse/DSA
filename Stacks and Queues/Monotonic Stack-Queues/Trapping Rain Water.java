public class Solution {
    public static long getTrappedWater(long []arr, int n) {
        // Write your code here.

        //Bruteforce - O(N^2)
        //Calculating height of water trapped for each pillar
        // long totalWater = 0;
        // for(int i = 1; i<n-1; i++)
        // {   long maxR = arr[i];
        //     long maxL = arr[i];
        //     //Find the max to the right
        //     for(int j = i+1; j<n; j++)
        //     {
        //         maxR = Math.max(maxR, arr[j]);
        //     }

        //     //Find the max to the left
        //     for(int k = 0; k<i; k++)
        //     {
        //         maxL = Math.max(maxL, arr[k]);
        //     }

        //     //find the min of maxL and maxR
        //     long min = Math.min(maxL, maxR);

        //     //Find trapped water for current pol
        //     totalWater+= min-arr[i];
        // }
        // return totalWater;

        

        //Better approach - using prefixes and suffixes of the maximum heights
        //Time - O(N)
        //Space - O(2N)

        //prefix array will contain max heights to the left
        //suffix array will contain max heights to the right

        // long suffix[] = new long[n];
        // long prefix[] = new long[n];

        // long maxL =0;
        // //create prefix
        // for(int i = 0; i<n; i++)
        // {   
        //     if(arr[i] > maxL)
        //     maxL= arr[i];

        //     prefix[i] = maxL;
        // }

        // //create suffix
        // long maxR = 0;
        // for(int i = n-1; i>=0; i--)
        // {
        //     if(arr[i] > maxR)
        //     maxR = arr[i];

        //     suffix[i] = maxR;
        // }

        // //Calculate total trapped water
        // long totalWater = 0;

        // for(int i = 1; i<n-1; i++)
        // {
        //     //get min of maxR and maxL
        //     long min = Math.min(prefix[i], suffix[i]);

        //     totalWater+= min - arr[i];
        // }

        // return totalWater;


        //Optimal Approach - Two Pointer
        //We will be taking a left pointer and a right pointer.
        //Initially we will initialize the left pointer with 0 and the right pointer with n-1
        //We will consider two variables maxR and maxL, indicating maximum on the right and maximum on
        //the right


        // Intuition: We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r] we increase l++, so we can surely say that there is a block with a height more than height[l] to the right of l. And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height[r]. So by traversing these cases and using two pointers approach the time complexity can be decreased without using extra space.

        long maxL = 0;
        long maxR = 0;

        int left = 0;
        int right = n-1;
        long totalWater = 0;
        while(left <= right)
        {
            if(arr[left] <= arr[right])
            {   
                if(arr[left] >= maxL) maxL = arr[left];
                
                else
                totalWater+=maxL - arr[left];

                left++;
            }
            else
            {   
                if(arr[right] >= maxR) maxR = arr[right];

                else
                totalWater+=maxR - arr[right];
                
                right--;
            }
        }

        return totalWater;
    }
}