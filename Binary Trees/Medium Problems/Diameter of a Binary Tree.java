/*************************************************************
 * 
 * Following is the Binary Tree Node structure:
 * 
 * class TreeNode<T> {
 * public T data;
 * public BinaryTreeNode<T> left;
 * public BinaryTreeNode<T> right;
 * 
 * TreeNode(T data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 
 *************************************************************/


//Here we finding the max dia using the code of of finding maxHeight of a tree
//The max dia is the max (lh + rh) that we can get for each node.
// The dia doesn't necessarily pass through the root.
public class Solution {
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        // Write your code here.

        int[] dm = new int[1]; // for storing the ans

        findDia(root, dm);

        return dm[0];
    }

    private static int findDia(TreeNode<Integer> root, int[] dm) {
        if (root == null)
            return 0;

        int lh = findDia(root.left, dm);
        int rh = findDia(root.right, dm);

        dm[0] = Math.max(dm[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}