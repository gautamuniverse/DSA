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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        //Create a queue for storing the nodes
        Queue<TreeNode> nodesQ = new LinkedList<>();

        //Push root node into nodesQ
        nodesQ.offer(root);

        //Initialize a boolean flag represents left->right or right->left direction
        boolean leftToRight = false; //after processing root we  have to start from right to left.

        //traverse all the nodes in zig zag manner while the nodesQ is not empty
        while(!nodesQ.isEmpty())
        {
            //Check the current row size, that is get the size of current level of tree, we have to get all of those nodes popped out and placed in our row list
            int rowSize = nodesQ.size();

            //make a list for storing current row
            ArrayList<Integer> row = new ArrayList<>(rowSize);

            for(int i = 0; i< rowSize; i++)
            {
                TreeNode node = nodesQ.remove();

                //push the node's children into the queue
                if(node.left != null) nodesQ.offer(node.left);
                if(node.right != null) nodesQ.offer(node.right);

                
                if(!leftToRight)
                row.add(node.val);
                //if the flag is false we will add the nodes values in reverse order into the list. Because we are inserting values into list in left -> right manner
                else
                row.add(0, node.val); //adding at 0 eventually adds the values from backedn of the list if 0 index is already filled.
            }
            //Toggle the flag after each row traversal
            leftToRight = !leftToRight;

            //Add the current row into the final ans
            List<Integer> rowList = new ArrayList<>(row);
            ans.add(rowList);
        }
        return ans;

    }
}