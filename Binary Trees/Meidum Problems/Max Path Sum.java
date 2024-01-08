/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
        findHeight(root, max);

       return max[0];

    }

    private static int findHeight(TreeNode root, int [] max)
    {
        if(root == null) return 0;
        //making sure we always take the root which gives us positive sum
        int leftSum = Math.max(0,findHeight(root.left, max));
        int rightSum =Math.max(0,findHeight(root.right, max));
        //Store the max sum path we got so far
        max[0] = Math.max(max[0], leftSum + rightSum + root.val);
        //Select that sub tree which gives max sum
        return root.val + Math.max(leftSum, rightSum);
    }
}