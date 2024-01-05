import java.util.Stack;

/*
	
	Following the structure used for Binary Tree
	
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

public class Solution {

	public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here

		//Recursive Solution		
		// if(root == null) return;

		// System.out.print(root.data+" ");
		// preOrder(root.left);
		// preOrder(root.right);

		//Iterative solution
		if(root == null) return;
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		st.push(root);

		while(!st.isEmpty())
		{
			//Take out the topmost node
			BinaryTreeNode<Integer> currNode = st.pop();
			//Print the node's value
			System.out.print(currNode.data+" ");
			//Push the right and then left child into the stack
			//Because the LIFO will make sure the left is printed first
			if(currNode.right != null)st.push(currNode.right);
			if(currNode.left != null)st.push(currNode.left);
		}
	}

}