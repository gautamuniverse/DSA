/*
intuition: 

for a substring, the condition that we need to follow to get the max length fof the repeating character stiring: 

length of the substring - max frequent character in that substring <= K(replacement allowed)


If this is met then we can keep considering more elements to the right, and whenever the conditions is not met then we have to reduce the window size to make the max replacement less than equal to k. */



public class Solution {
    public static int longestRepeatingSubstring(String str, int k) {
        // Write your code here.

        int left = 0;
        int right;

        int maxlength = 0;
        int maxFreqChar = 0;

        int[] char_arr = new int[26];

        for (right = 0; right < str.length(); right++) {
            maxFreqChar = Math.max(maxFreqChar, ++char_arr[str.charAt(right) - 'A']);
            int window_size = right - left + 1;

            // If the number of unique characters are more than k in the current window then
            // we
            // wont be able to make k replacements hence we need to reduce the window size.
            int replaceCount = window_size - maxFreqChar;
            if (replaceCount > k) {
                // decrement the count of the left character in the char array
                // Also increment the left pointer.w
                --char_arr[str.charAt(left++) - 'A'];
            } else // only calculate the maxLength when the replace count is less than k otherwise
                   // we might end up calculating the maxLength fora substring with a maxReplace
                   // count > k which is invalid
                maxlength = Math.max(maxlength, window_size);
        }

        return maxlength;
    }
}
