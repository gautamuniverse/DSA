class Solution {
    public int search(int[] arr, int k) {

        //Naive solution: O(N) worst case
    //  int index = 0;
    //     int i = 1;
        int n = arr.length;
    //     while(i< n && arr[i] > arr[i-1])
    //     {
    //         index++;
    //         i++;
    //     }

    //     int ans1 = -1;
    //     int ans2 = -1;
    //     ans1 = binarySearch(arr, n, k, 0, index);
    //     ans2 = binarySearch(arr, n, k, index+1, n-1);

    //     if(ans1 != -1)
    //     {   
    //         return ans1;
    //     }
    //     else if(ans2 != -1)
    //     {
    //         return ans2;
    //     }
    //     else{
    //         return -1;
    //     }

    //Better solution- O(log n)
    //Intuition - find the sorted half and check if the target lies within the low and high of that part

    return binarySearchModified(arr, n, k);
    }

    // private static int binarySearch(int []arr, int n, int k, int low, int high)
    // {   
    //     while(low <= high && low>=0 && high <n)
    //     {
    //         int mid = (low+high)/2;

    //         if(arr[mid] == k)
    //         {   
    //             return mid;
    //         }

    //         else if(arr[mid] > k)
    //         {
    //             high = mid-1;
    //         }
    //         else
    //         low = mid+1;
    //     }

    //     return -1;
    // }

    private static int binarySearchModified(int []arr, int n, int k)
    {      
        int low = 0;
        int high=n-1;

        while(low <= high && low>=0 && high <n)
        {
            int mid = (low+high)/2;

            if(arr[mid] == k)
            {   
                return mid;
            }

            //Check if the left half is sorted
            if(arr[low] < arr[mid])
            {
                //now check if the target lies in the current half
                if(arr[low] <= k && k<= arr[mid])
                {
                    high = mid-1;
                }
                //Target doesn't lie in this half, therefore move to the unsorted half
                else
                low = mid+1;
            }

            else
            {
                if(mid < n-1 && arr[mid+1] <= k && k <= arr[high])
                {
                        low = mid+1;
                }
                else
                high = mid-1;
            }
        }
        return -1;
    }
}