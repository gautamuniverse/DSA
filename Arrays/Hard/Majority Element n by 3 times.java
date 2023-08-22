class Solution {
    public List<Integer> majorityElement(int[] nums) {
       // Write your code here
        //This approach is better and will take O(N * logn) time at max, worst case chaining may occur
        //So map can end up taking O(N). time complexity is O(N)
        // List<Integer> ans = new ArrayList<>();
        // if(v.length == 1)
        // ans.add(v[0]);
        // HashMap<Integer, Integer> map=new HashMap<>();
        // Arrays.sort(v);
        // for(int i : v)
        // {
        //     if(map.containsKey(i))
        //     {
        //         map.put(i, map.getOrDefault(i, 0)+1);
        //       int count =  map.get(i);
        //       if(count > Math.floor(v.length/3))
        //       {ans.add(i);
        //       map.remove(i);
        //       }
        //     }
        //     else
        //     map.put(i, 1);
        // }
        // return ans;

        //Best/Optimal Approach, intuition taken from Moore's Algorithm for Majority element >n/2 times
        // IMPORTANT Observation : there can be at max 2 majority elements here.    
        //intiution:
        // Intuition: If the array contains the majority of elements, their occurrence must be 
        // greater than the floor(N/3). Now, we can say that the count of minority elements and 
        // majority elements is equal up to a certain point in the array. So when we traverse 
        // through the array we try to keep track of the counts of elements and the elements 
        // themselves for which we are tracking the counts. 
        int count1 = 0, count2 = 0;
        int ele1 =0, ele2 = 0;

        for(int i = 0; i< nums.length; i++)
        {
            if(count1 == 0 && nums[i] != ele2)
            {
                ele1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && nums[i]!= ele1)
            {
                ele2 = nums[i];
                count2++;
            }
            else if(nums[i] == ele1)
            {
                count1++;
            }
            else if(nums[i] == ele2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }  
        count1=0;
        count2 = 0;
        //Compute the count of ele1 and ele2 in the array
        for(int i : nums)
        {
            if(i == ele1)
            count1++;

            if(i == ele2)
            count2++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int majorNum = (nums.length/3) + 1;
        
        if(count1 >= majorNum)
        {
            ans.add(ele1);
        }
        if(count2 >= majorNum)
        {
            ans.add(ele2);
        }

        //This is essential in case all the elements are same.
        if(ele1 == ele2)
        ans.remove(ans.size()-1);
        else
        Collections.sort(ans);

        return ans;
    }
}
