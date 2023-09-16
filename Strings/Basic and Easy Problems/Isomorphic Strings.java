import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static boolean areIsomorphic(String str1, String str2) {
        // Write your code here.
        //Approach - 1 Using two stacks, not recommended.

        //Check if the lengths are same or not, if not return false
        // if(str1.length() != str2.length())
        // return false;

        // int distinct1 = Integer.MIN_VALUE;
        // int distinct2 = Integer.MIN_VALUE;
        // Set<Character> st1 = new HashSet<>(); 
        // Set<Character> st2 = new HashSet<>(); 
        // for(char i : str1.toCharArray())
        // {
        //    st1.add(i);
        // }
        // for(char i : str2.toCharArray())
        // {
        //     st2.add(i);
        // }

        // if(st1.size() != st2.size())
        // return false;
        // else
        // return true;


        // Approach 2 -  Using two Maps, Highly recommended.
        // time - O(N)
        // space- O(2N)

        // Check if the lengths are same or not, if not return false
        if(str1.length() != str2.length())
        return false;
        
        // Character, Character map to check if there is already a mapping present for the 
        // current character of string 1
        Map<Character, Character> mapCC = new HashMap<>();

        // Character, Boolean map to check if the current character in string 2 is unused.
        //This map will make sure we don't have multiple mappings for the cracters of string
        // 1 with string 2

        Map<Character, Boolean> mapCB = new HashMap<>();

        for(int i = 0; i< str1.length(); i++)
        {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            //Check if there is already a mapping for current ch1 in the map1
            if(mapCC.containsKey(ch1))
            {
                //check if the mapping is correct and is mapped to ch2
                if(mapCC.get(ch1) != ch2)
                {
                    return false;
                }
            }
            //The current ch1 is not already mapped, check if it not used before
            else
            {   
                // Current ch2 is already used and is therefore mapped incorrectly
                if(mapCB.containsKey(ch2))
                return false;
                else
                {
                    // the current ch1 and ch2 are not mapped and are unused.
                    //therefore add them to the maps
                    mapCC.put(ch1, ch2);
                    mapCB.put(ch2, true);
                }
            }
        }

        return true;
    
    }
}