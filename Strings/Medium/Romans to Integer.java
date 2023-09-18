import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        //Approach used:
        //We will check if the current character is less than or greater than the 
        //character to its right, if it is less then we will substract it from the greater number
        //otherwise we add them both numbers

        //Time- O(N)
        //Space- O(Number of Symbols)

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int result = map.get(s.charAt(s.length()-1));

        for(int i = s.length()-2; i>=0; i--)
        {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
            result-=map.get(s.charAt(i));
            
            else
            result+=map.get(s.charAt(i));
        }

        return result;
    }
}