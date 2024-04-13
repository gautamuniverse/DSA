import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure.
 * 
 * class TreeNode<T>
 * {
 * public T data;
 * public TreeNode<T> left;
 * public TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
	static TreeNode<Integer> prev = null;

	public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
		flattenHelper(root);

		return root;
	}

	private static void flattenHelper(TreeNode<Integer> root) {
		// If we reached a null node, we return from there
		if (root == null)
			return;

		// We recursively construct the right and left subtrees of the tree
		flattenHelper(root.right);
		flattenHelper(root.left);

		// Once we comeback from the left we will attach the prev node to the right of
		// the current node
		root.right = prev;
		// And make the left child as null as we have already attached the left child
		// (if exists) to the right side of the root node.
		root.left = null;
		//Change the prev node as the current node.
		prev = root;
	}

}