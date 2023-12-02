import java.util.*;

public class Solution {
    public static String minSubString(String a, String b) {
        // Write your code here

        // Naive
        // int minLength = Integer.MAX_VALUE;
        // String finalAns = "";
        // Map<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < b.length(); i++) {
        // map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
        // }
        // for (int i = 0; i < a.length(); i++) {
        // String currAns = "";
        // for (int j = i; j < a.length(); j++) {
        // currAns += a.charAt(j);
        // if (map.containsKey(a.charAt(j))) {
        // map.put(a.charAt(j), map.get(a.charAt(j)) - 1);
        // if (map.get(a.charAt(j)) == 0)
        // map.remove(a.charAt(j));
        // }

        // if (currAns.length() < minLength && map.size() == 0) {
        // minLength = currAns.length();
        // finalAns = currAns;
        // }
        // }
        // if (map.size() == 0) {
        // for (int k = 0; k < b.length(); k++) {
        // map.put(b.charAt(k), map.getOrDefault(b.charAt(k), 0) + 1);
        // }
        // }
        // }

        // return finalAns;

        // Optimal Solution

        // Idea: We will employ the concept of acquiring and releasing characters,
        // maintaining both a desired count and a current matching count of characters.
        // Additionally, we'll manage two maps: one for the frequency mapping of
        // characters in string 2 and another for string 1. For string 1, we'll populate
        // the values in the map as we iterate through it.

        // During iterations of string 1, we will track the matching count. The count
        // will only increase if we acquire a character that is beneficial, meaning it
        // is present in the string 2 frequency map. We will also refrain from
        // increasing the matching count if we acquire a character not present in the
        // string 2 frequency map or if its frequency in string 1 is already sufficient.
        // Once we achieve the desired matching count, we won't halt the iteration of
        // the i pointer; instead, we'll continue. At this point, we have a potential
        // substring answer, which we'll note down.

        // To obtain a smaller potential substring, we'll commence iterating the j
        // pointer, initially set to -1. While moving the j pointer, we'll run this
        // iteration until the matching count equals the desired matching count.
        // Otherwise, we would be in a substring lacking all the required characters
        // from string 2. Inside the loop, we'll reduce the matching count only when
        // releasing a character doesn't affect the count and when the character is
        // either not part of the frequency map of string 2 or is in excess of what is
        // required.

        // After completing this second loop, we'll restart the first loop and continue
        // this process until we reach the end of string 1.

        String ans = ""; // Final ans

        // Freq map for string 1
        Map<Character, Integer> map1 = new HashMap<>();
        // Frequency map for string 2
        Map<Character, Integer> map2 = new HashMap<>();

        int left = -1; // initial posn
        int right = -1; // initial posn

        // Populate the fequency map 2 with string 2 characters
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int dmc = b.length(); // desired matching count
        int mc = 0; // matching count, variable used for string 1 count of character matching with
                    // dmc

        // Loop will keep running until explicitly broken out
        while (true) {
            boolean flag1 = false; // Flag for enterning the loop1
            boolean flag2 = false; // Flaf for entering the loop2

            // Loop will run until we find all the desired characters as in the string b,
            // which will help us find our first potential substring
            while (right < a.length() - 1 && mc < dmc) {
                right++;
                char ch = a.charAt(right);

                // POPULATE FREQUENCY OF CURRENT CHARACTER IN MAP1
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                // Check if current character was helpful or not for mc increment
                // Why = ? because it would have become = only after adding the character to the
                // frequency map
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    mc++;
                }

                flag1 = true; // indicating that we have entered the loop1
            }

            // Loop2, this loop will help us shrink down the present potential substring
            // that we have got from loop 1, and we will continue to shring the substring
            // down until we have all the desired characters in our potential substrings
            // mc should stay equal to dmc only then we will have a valid substring
            // containing all the required characters of string b
            while (left < right && mc == dmc) {
                String potentialAns = a.substring(left + 1, right + 1);

                // Update the main ans, if potentialAns length is smaller than the current best
                // ans
                if (ans.length() == 0 || potentialAns.length() < ans.length()) {
                    ans = potentialAns;
                }

                left++;

                // Check the current count of character at left pointer in map1,
                // if its frequency is 1, remove it. otherwise reduce its frequency
                char ch = a.charAt(left);
                if (map1.get(ch) == 1)
                    map1.remove(ch);
                else
                    map1.put(ch, map1.get(ch) - 1); // reduce the freq of ch in map1

                // Check if removing the current character at left posn affects the matching
                // count
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    mc--;
                }

                flag2 = true; // flag indicating that we have entered loop2
            }
            // meaning we haven't entered any loop, we have completed all the iterations,
            // break from outer loop
            if (flag1 == false && flag2 == false)
                break;
        }

        return ans;
    }
}