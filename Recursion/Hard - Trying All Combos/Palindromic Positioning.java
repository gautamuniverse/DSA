import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<List<String>> partition(String str) {
        // Write your code here.

        //Create a final Answer List which will store all the individual palindrome string lists
        List<List<String>> ans = new ArrayList<>();

        //Call the helper function to generate the final ans list
        helper(str, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void helper(String str, int index, List<List<String>> ans, List<String> currentList)
    {

            //Base case
            if(index == str.length())
            {
                ans.add(new ArrayList<>(currentList));
                return;
            }

            //Iterate over each partition, that consider partition at each index
            for(int i = index; i< str.length(); i++)
            {
                //Check if the current partition is possible, that is check if the current partition
                //substring is a palindrome(as given in the quesiton requirement)
                if(isPalindrome(str, index, i))
                {   
                    //Add current palindromic substring to the currentList
                    currentList.add(str.substring(index, i+1));
                    //Recursively search for next palindromic substrings with the current combination
                    helper(str, i+1, ans, currentList);
                    //Backtracking, remove the latest string
                    currentList.remove(currentList.size()-1);
                }
                 
            }
    }

    private static boolean isPalindrome(String str, int begin, int end)
    {
        while(begin <= end)
        {
            if(str.charAt(begin++) != str.charAt(end--))
            return false;
            
        }

        return true;
    }
}
