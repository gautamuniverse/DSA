class Solution {
    public String longestPalindrome(String s) {
       
    //    Time- O(N^3)
    //    Space- O(1)

    //     int maxLength = 0;
    //     String ans = "";

    //     for (int i = 0; i < s.length(); i++) {
    //         for (int j = i + 1; j <= s.length(); j++) {
    //             String substring = s.substring(i, j);
    //             if (isPalindrome(substring) && substring.length() > maxLength) {
    //                 ans = substring;
    //                 maxLength = ans.length();
    //             }
    //         }
    //     }

    //     return ans;
    // }

    // private boolean isPalindrome(String s) {
    //     int left = 0;
    //     int right = s.length() - 1;

    //     while (left < right) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }

    //     return true;

        //Better solution: DP

        // //Fill the dp, starting from first cell(0,0) diagnol wise. 
        // //Columns represent the start character and rows represent the end character
        // //the first diagnol represents that the string is of length of 1, that single characters that start and end on their own
        // //the second diagnol represent thet the string is of length 2, and so on...
        // //Here we are using the variable as g meaning gap, gap = 0  means the single character strings and so on, they also represent the diagnol starting substring.


        // Create a dynamic programming table to store palindrome information
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        // Initialize the longest palindrome substring as an empty string
        String longestString = "";

        // Fill the DP table diagonally
        for (int g = 0; g < s.length(); g++) {
            // Loop through the matrix diagonally
            for (int i = 0, j = g; j < s.length(); j++, i++) {
                // Check if the substring has a gap of 0 (single character), which is always a palindrome
                if (g == 0) {
                    dp[i][j] = true;
                } 
                // Check if the start and end characters are the same for a gap of 1
                else if (s.charAt(i) == s.charAt(j)) {
                    // If the gap is 1, it's a palindrome
                    dp[i][j] = (g == 1) ? true : dp[i + 1][j - 1]; // Check if the middle string is also a palindrome
                }

                // If the current substring is a palindrome and longer than the longest found so far
                if (dp[i][j] && (j - i + 1) > longestString.length()) {
                    // Update the longest palindrome substring
                    longestString = s.substring(i, j + 1);
                }
            }
        }

        // Return the longest palindrome substring found
        return longestString;
    }
}
