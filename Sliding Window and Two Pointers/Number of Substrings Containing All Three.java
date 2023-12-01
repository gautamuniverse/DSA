public class Solution {
    public static int countSubstring(String s) {
        // Write your code here.
        // naive -O(N^2)

        // int count = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     int currCount = 0;
        //     boolean containsA = false;
        //     boolean containsB = false;
        //     boolean containsC = false;
        //     for (int j = i; j < s.length(); j++) {

        //         if(s.charAt(j) == 'a')
        //         containsA = true;

        //         if(s.charAt(j) == 'b')
        //         containsB = true;

        //         if(s.charAt(j) == 'c')
        //         containsC = true;

        //         if(containsA & containsB & containsC)
        //         count++;
        //     }
        // }

        // return count;

        //Optimal 2 pointer
        // O(N), O(1)

        char [] map = new char[3];
        int left = 0;
        int right = 0;
        int count = 0;

        while(right < s.length())
        {   

            map[s.charAt(right) - 'a']++;
            // If the map contains all three characters then we 
            // can reduce our window size to find more potential substrings
            while(map[0] >= 1 && map[1] >= 1 && map[2] >= 1)
            {
                count += s.length() - right;
                map[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return count;

        
    }
}