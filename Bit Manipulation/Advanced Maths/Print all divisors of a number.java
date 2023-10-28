import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution{
    public static List< Integer > printDivisors(int n) {
        // Write your code here

        //O(N)
        // List<Integer> ans=  new ArrayList<>();
        // for(int i =1; i<=n; i++)
        // {
        //     if(n % i == 0)
        //     ans.add(i);
        // }

        // return ans;

        //O(sqrt(N))
        List<Integer> ans=  new ArrayList<>();
        for(int i =1; i*i<=n; i++)
        {
            if(n%i == 0)
            {
              ans.add(i);

              //This step makes sure that we don't add the same i again to the ans list
              //For example, 6 divides 12, ans 12/6 is also 6, so in case of a number
              //which is exactly half of the target dividend number, include it only once.
                if(n/i != i)
                  ans.add(n/i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}