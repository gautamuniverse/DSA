class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;
        int n = s.length();
        String ans = "";
        while(i < n)
        {
            //Check if the current string character is '('
            if(s.charAt(i) == '(')
            {
                //check if the stack is empty, if so then that means the current '(' is part of the outermost parenthesis.
                //Therefore dont' include in the answere, else add it.
                if(!st.isEmpty())
                {   st.push(s.charAt(i));
                    ans+=s.charAt(i);
                }
                //The stack is empty therefore push to stack and dont include in the answer
                else
                {
                    st.push(s.charAt(i));
                }
            }
            //The current index element is ')'
            else{
                //check if removing the current '(' present in the stack makes it empty, if so, dont include it in the answer. otherwise include it.
                st.pop();
                if(st.size() != 0)
                {
                    ans+=s.charAt(i);
                }
            }
            i++;
        }

        return ans;
    }
}