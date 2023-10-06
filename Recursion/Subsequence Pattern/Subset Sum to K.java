import java.util.*;
public class Solution {
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        // Write your code here

        //Naive 

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i< a.length; i++) 
        {
            List<Integer> subArray = new ArrayList<>();
            long sum = 0;
            for(int j = i; j<a.length; j++)
            {
                sum+=a[j];
                subArray.add(a[j]);  
                
                if(sum== k)
                {
                    ans.add(subArray);
                    break;
                }       
            }
        }

        return ans;
    }
}