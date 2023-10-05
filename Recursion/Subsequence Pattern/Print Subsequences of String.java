import java.util.ArrayList;
import java.util.List;
public class Solution {

    //Time - O(2^n)
    //space - O(N) for recursion call stack
    public static List<String> generateSubsequences(String s) {
        // Write your code here
        //Base case -  if the string length is 0 then return empty string 
        if(s.length() == 0)
        {
            List<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }
        char firstChar = s.charAt(0);

        //Small list will contain all subsequences starting from string index 1
        List<String> small = generateSubsequences(s.substring(1));

        // List<String> ans = new ArrayList<>();

        int i = 0;
        //Move the pointer to the end of the current small list
        while(i < small.size())
        {
            // ans.add(small.get(i));
            i++;
        }
        int size = 2*small.size();
        int k = 0;

        //concatenate the first char with the existing list to make remaining subsequences
        while(i< size)
        {
            small.add( firstChar + small.get(k));
            i++;
            k++;
        }
        return small;
    }
}