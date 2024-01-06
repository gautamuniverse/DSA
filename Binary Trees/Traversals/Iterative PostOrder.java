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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // postOrder(root, ans);

        // return ans;

        
        // iterative (2 stacks)
       
        Stack<TreeNode> st1 = new Stack<>(); // will contain the children of nodes along with node
        Stack<TreeNode> st2 = new Stack<>(); // will contain the ans
        List<Integer> ans = new ArrayList<>();
         if(root == null) return ans;
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        while(!st2.isEmpty())
        { 
            ans.add(st2.pop().val);
        }

        return ans;
    }

    private void postOrder(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;

        
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add((Integer)root.val);
    }
}