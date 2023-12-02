import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        // Write your code here.

        // Naive solution
        // int count = 0;

        // for(int i = 0; i< n; i++)
        // { Set<Integer> set = new HashSet<>();
        // for(int j = i; j<n; j++)
        // {
        // set.add(arr[j]);

        // if(set.size() == k)
        // count++;
        // }
        // }

        // return count;

        // Optimal - O(2N) ~ O(N)

       //exactly k = atmost k - atmost (k-1)
        return atmostK(arr, k) - atmostK(arr, k - 1); 
    }
    private static int atmostK(int [] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int count=0;

        while(right < arr.length)
        {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > k && left < arr.length)
            {
                map.put(arr[left], map.get(arr[left]) - 1);

                //If the arr[left] value in map has become 0, remove the its key
                if(map.get(arr[left]) == 0)
                map.remove(arr[left]);

                left++;
            }

            //We have to include all the subarrays, i.e atmost k unique elements
            // for example, arr = [1,2,1] and k=2, here 3 subarrays are possible 1,12,121
            count += right - left + 1;

            right++;
        }

        return count;
    }
}