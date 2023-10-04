import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static List< String > generateString(int N) {
        // Write your code here.
        String s = "";
        List<String> ans= new ArrayList<>();
        helper(N, s, ans);
        return ans;
    }

    private static int helper(int N, String s, List<String> ans)
    {
        if(s.length() == N)
        {
            ans.add(s);
            return 0;
        }


        if(s.equals("") || s.charAt(s.length()-1) == '0')
        {
            helper(N, s+"0", ans);
            helper(N, s+"1", ans);
        }
        else
        {
            helper(N, s+"0", ans);
        }

        return 0;
    }
}
