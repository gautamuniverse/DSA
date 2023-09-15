import java.util.Stack;

public class Solution {
    public static int maxDepth(String s) {

//         Approach: 

 

// We will iterate over the characters of ‘S’, and for each opening parentheses '(', increment a variable ‘maxNestingDepth’ by 1 and find the depth of the rest of the strings.
// The value of the ‘maxNestingDepth’ will determine the following:
// The number of open parentheses that are not yet closed.
// The current depth of the parentheses.
 

// Algorithm:

 

// Function int maxDepth(string S):

// Initialize two integer variables, ‘maxNestingDepth’ and ‘currentDepth’, with 0.
// For each character ‘c’ in ‘S’:
// If ‘c’ equals ’(’:
// Increment ‘currentDepth’ by one.
// ‘maxNestingDepth’ is updated with a maximum of ‘maxNestingDepth’ and ‘currentDepth’.
// Else:
// Decrement ‘currentDepth’ by one.
// Return ‘maxNestingDepth’.
// Time Complexity
// O(N), Where ‘N’ is the string ‘S’ length. 

        int cnt=0,maxi=0;

        for(char ch:s.toCharArray()){

            if(ch=='(') maxi=Math.max(maxi,++cnt);

            else if(ch==')') cnt--;

        }

        return maxi;

    }
}