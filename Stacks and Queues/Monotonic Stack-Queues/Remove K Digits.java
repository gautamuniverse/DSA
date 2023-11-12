// class Solution {
//     public String removeKdigits(String num, int k) {
//         int len = num.length();
//         if (k == 0)
//             return num;

//         if (k == len)
//             return "0";

//         Stack<Character> st = new Stack<>();

//         int index = 0;
//         while (index < len) {
//             // While the stack top contains a number greater than the current number pop it,
//             // because if it is 14 in the stack and current numnber is 3, then making 13 is
//             // lesser than 134 or 14. therefore pop 4.
//             while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(index)) {
//                 st.pop();
//                 k--;
//             }
//             st.push(num.charAt(index++));
//         }

//         // Check if k is still greater than 0
//         while (k-- > 0)
//             st.pop();

//         String smallest = "";

//         while (!st.isEmpty()) {
//             smallest = st.pop() + smallest;
//         }

//         int nonZeroIdx = 0;
//         while (nonZeroIdx < smallest.length() && smallest.charAt(nonZeroIdx) == '0') {
//             nonZeroIdx++;
//         }

//         String ans = (nonZeroIdx == smallest.length()) ? "0" : smallest.substring(nonZeroIdx);

//         return ans;
//     }
// }


public class Solution {
    public String removeKdigits(String num, int k) {
        //Using StringBuilder as a Stack
        StringBuilder ans = new StringBuilder();
        for (char x : num.toCharArray()) {
            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > x && k > 0) {
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            if (ans.length() > 0 || x != '0') {
                ans.append(x);
            }
        }
        while (ans.length() > 0 && k > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }
        if (ans.length() == 0) {
            ans.append('0');
        }
        return ans.toString();
    }
}