import java.util.Stack;

public class Solution {

    private static int checkPrecedence(char c)
    {
        switch(c)
        {
            case '+':
            case '-':
            return 1;

            case '/':
            case '*':
            return 2;

            case '^':
            return 3;
        }

        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Write your code here

        String ans = "";

        Stack<Character> st = new Stack<>();

        for(int i = 0; i<exp.length(); i++)
        {   char c = exp.charAt(i);

            //if the current character is an operand
            //append it to the result
            if(Character.isLetterOrDigit(c))
            {
                ans+=c;
            }

            //If the current character is '('
            //Push it to the stack
           else if(c == '(')
            {
                st.push(c);
            }

            //if the current character is ')'
            //Start popping operators from the stack until '(' is encountered
            else if(c == ')')
            {
                while(!st.isEmpty() && st.peek() != '(')
                {
                    ans+=st.pop();
                }
                st.pop();
            }

            //If the current character is an operator
            //Keep popping and appending to the answer string till the
            //precedence of the current operator is less than that of the peek operator

            else
            {
                while(!st.isEmpty() && checkPrecedence(c) <= checkPrecedence(st.peek()))
                {
                    ans+=st.pop();
                }

                st.push(c);
            }
        }

        //append the remaining operators presnt in the stack to the answer string
        while(!st.isEmpty())
        {
            ans+=st.pop();
        }

        return ans;
    }
}