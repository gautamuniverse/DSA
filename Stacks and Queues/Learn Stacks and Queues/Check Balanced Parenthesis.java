class Solution {
    public boolean isValid(String s) {
         // Approach
        // Keep pushing opening brackets, whenever encounter a closing bracket, pop from
        // the stack only if the type of bracket inside the stack is same as that of the current encounteredclosing bracket in the string if the stack is not empty otherwise return false
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }

            else {
                //Stack is empty
                if (st.isEmpty())
                    return false;
                //The opening bracket inside the stack should be of the same type as that of the closing bracket, ascii difference should not be more than 2 and should greater than 0.
                else if(s.charAt(i) - st.peek() > 0 && s.charAt(i) - st.peek() <=2 )
                st.pop();
                //The type of bracket inside the stack is different than the closing bracket encountered in the string.
                else
                return false;
            }
        }
        return st.isEmpty();
    }
}