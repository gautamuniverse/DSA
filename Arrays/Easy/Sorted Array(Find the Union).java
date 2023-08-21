import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        Set<Integer> finalAns = new TreeSet<>();
        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length)
        {
            if(a[i] < b[j])
            {
                finalAns.add(a[i]);
                i++;
            }
            else if(a[i] > b[j])
            {
                finalAns.add(b[j]);
                j++;
            }
            else
            {
                finalAns.add(a[i]);
                i++;
                j++;
            }
        }

        while(i < a.length)
        {
            finalAns.add(a[i]);
            i++;
        }
        while(j < b.length)
        {
            finalAns.add(b[j]);
            j++;
        }
        List<Integer> ans = new ArrayList<>(finalAns);
        // Collections.sort(ans);
        return ans;
    }
}