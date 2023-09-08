//    Write your code here.
        //Note: Minimum distance will always be between the consecutive stalls(not indexes)

        //Naive - O((max-min)*N)

        Arrays.sort(stalls);
        int min = stalls[0];
        int max = stalls[stalls.length-1];

        // //Check for each distance starting from 1 which is possible. we need  to consider
        // //the maximum minimum possible distance between two cows considering the cows can be placed

        // for(int i = 1; i<(max-min); i++)
        // {
        //     if(canWePlace(stalls, i, k))
        //     continue;
        //     //If we can't place the cow then return the previous computed distance
        //     else
        //     return i-1;
        // }

        // //return max limit if not possible
        // return stalls[stalls.length-1] - stalls[0];

        //Optimal Approach: Binary Search
        //We will discard the right half if at any time the mid element is not possible
        //because anything greater than that won't be possible

        int n = stalls.length;
        int low = 0;
        int high = max - min;
        while(low <= high)
        {   int mid = (low + high)/2;
            if(canWePlace(stalls,mid , k))
            {       
                //Current distance is possible, look for bigger distances in the right half
               low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int [] arr, int distance, int k)
    {
        int cowsNum = 1;
        int lastStall =arr[0];

        for(int i = 1; i<arr.length; i++)
        {   
            //Here we are making sure that the max distance between the two stalls is atleast
            //equal to the current minimum distance, i.e atleast one cow should have minimum distance
            if(arr[i] - lastStall >= distance)
            {
                cowsNum++;
                lastStall=arr[i];
            }

            if(cowsNum == k)
            return true;
        }

        return false;

    }