// Write your code here

        // Naive solution : O(N^2)
        // int count = 0;

        // for (int i = 0; i < arr.length; i++) {
        // int currCount = 0;
        // for (int j = i; j < arr.length; j++) {
        // if (arr[j] % 2 == 1)
        // currCount++;

        // if (currCount == k) {
        // count++;
        // }

        // }

        // }

        // return count;

        // Better solution

        // We can use the prefix sum approach here. First we will be needing to replace
        // each odd number with 1 and each even number with 0 to make the array a binary
        // array. Now we can easily use the prefix sum method, here the k will be
        // equating to the required sum.

        //Convert the array to binary array, ordd -> 1, even -> 0
        for(int i = 0; i< arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            arr[i] = 0;

            else
            arr[i] = 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int preSum = 0;
        int reqSum = 0;
        map.put(0, 1); // Prefix sum 0 is having one count

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            reqSum = preSum - k;

            count += map.getOrDefault(reqSum, 0); // check if map contains the required sum and if so return its count,
                                                  // if not then get the default value as 0

            //Put the current prefix sum into the map
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;