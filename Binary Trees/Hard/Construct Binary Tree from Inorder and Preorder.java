import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.INEG;

/*********************************************************
 * 
 * Following is the TreeNode structure:
 * 
 * class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {
 * this.data = 0;
 * this.left = null;
 * this.right = null;
 * }
 * TreeNode(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * TreeNode(int data, TreeNode left, TreeNode right) {
 * this.data = data;
 * this.left = left;
 * this.right = right;
 * }
 * };
 ********************************************************/

public class Solution {
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Write your code here.
          //If the preorder and inorder length is not equal then return null
        if(inorder.length != preorder.length)
        return null;

        // Creating a hashmap for mapping the inrorder indexes with nodex
        Map<Integer, Integer> inMap = new HashMap<>();

        // Map the inorder traversal numbers with their indexes to be used for finding
        // the index of the root in the later stage.
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildBinaryTreeHelper(inorder, 0, inorder.length -1, preorder, 0, preorder.length - 1, inMap);
    }

    private static TreeNode buildBinaryTreeHelper(int[] inorder, int is, int ie, int[] preorder, int ps, int pe,
            Map<Integer, Integer> inMap) {
        // If the starting indexes cross the ending indexes we return null
        if (is > ie || ps > pe)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);

        int inRootIndex = inMap.get(preorder[ps]);
        //Nodes in the left subtree
        int leftNodes = inRootIndex - is;

        root.left = buildBinaryTreeHelper(inorder, is, inRootIndex - 1, preorder,ps + 1, ps + leftNodes, inMap);
        root.right = buildBinaryTreeHelper(inorder, inRootIndex + 1, ie, preorder, ps + leftNodes + 1, pe, inMap);

        return root;

    }
}