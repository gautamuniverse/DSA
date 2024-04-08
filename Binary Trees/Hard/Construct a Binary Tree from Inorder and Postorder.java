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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //If the lengths of both the traversals is not equal we return from there, no tree possible.
        if(inorder.length != postorder.length)
        return null;
        
   // Creating a hashmap for mapping the inrorder indexes with nodex
        Map<Integer, Integer> inMap = new HashMap<>();

        // Map the inorder traversal numbers with their indexes to be used for finding
        // the index of the root in the later stage.
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    private static TreeNode buildTreeHelper(int [] inorder, int is, int ie, int [] postorder, int ps, int pe, Map<Integer, Integer> inMap)
    {
          // If the starting indexes cross the ending indexes we return null
        if (is > ie || ps > pe)
            return null;

        TreeNode root = new TreeNode(postorder[pe]);

         int inRootIndex = inMap.get(postorder[pe]);

        int inLeftNodes = inRootIndex - is;

        root.left = buildTreeHelper(inorder, is, inRootIndex - 1, postorder, ps,  ps+inLeftNodes - 1, inMap);
        root.right = buildTreeHelper(inorder, inRootIndex + 1, ie, postorder, ps + inLeftNodes, pe-1, inMap);

        return root;
    }
}