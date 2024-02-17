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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        reversePreOrder(root, ans, 0);

        return ans;
    }

    private static void reversePreOrder(TreeNode root, List<Integer> ans, int currentDepth)
    {
        if(root == null) return;

        //We will consider the current node only if the currentDepth is equal to the ans list size, which means that we have not reached that level yet so we can add the current node. list size is less than the currentDepth when they are equal as the currentDepth is starting from 0.
        if(currentDepth == ans.size())
        {
            ans.add(root.val);
        }

        reversePreOrder(root.right, ans, currentDepth+1);
        reversePreOrder(root.left, ans, currentDepth+1);
    }
}