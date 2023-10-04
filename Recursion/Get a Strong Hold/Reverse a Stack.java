import java.util.Stack;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here

		if(stack.isEmpty())
		return;

		int top = stack.pop();

		reverseStack(stack);

		Stack<Integer> temp = new Stack<>();
		while(!stack.isEmpty())
		{
			temp.push(stack.pop());
		}
		stack.push(top);
		while(!temp.isEmpty())
		{
			stack.push(temp.pop());
		}
	}

}
