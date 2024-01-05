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
    public List<Integer> inorderTraversal(TreeNode root) {
        //  List<Integer> ans = new ArrayList<>();
        // inOrder(root, ans);

        // return ans;

        //Iterative inorder
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root; 
        while(true)
        {   
            //If the current node is not null, we will keep going to the left most child of the current node.
            if(node != null)
            {
                st.push(node);
                node = node.left;
            }
            else
            {
                if(st.isEmpty()) break; //if the stack is empty, means we have successfully traversed all the nodes so break out from the loop

                //else we will pop the top node from the stack and add it into the ans.
                node = st.pop();
                ans.add(node.val);
                node = node.right; //Now as we are done with the left childs of the current node, so now we will move towards the right children of the current node.
            }
        }
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> ans)
    {
        if(root == null) return;

        
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}