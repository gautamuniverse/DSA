
/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        // Idea:
        // 1. First of all push root value into an array/ds
        // 2. Now for the left boundary start the traversal from the root's left and
        // keep traversing and pushing elemnnts into the array until we reach a point
        // where the root's left is a leaf node. If at any point the root's left is null
        // then only in that situation we will mvoe towards right.
        // 3. Now for the leaf nodes we will perform the inorder traversal and only add
        // the leaf nodes to the answer list
        // 4. for the right boundary we will perform same thing as for the left boundary
        // just that we will store the values in rever order and also in case of right
        // child is null then only we will mvoe towards the left child. and we are not
        // including the leaft nodes in either of the case.

        // Final answer list
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        ans.add(root.data);

        if(root.left != null)
        // add the left boundary values to the ans
        addLeftBoundary(root.left, ans);

        // Add the leaf node values to the answer
        addLeafNodes(root, ans);

        if(root.right != null)
        // Add the right boundary values to the answer
        addRightBoundary(root.right, ans);

        return ans;
    }

    // function to add the left boundary of the tree
    private static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        
        TreeNode curr = root;

        while(curr != null)
        {
            //if the current node is leaf node we stop
            if(curr.left == null && curr.right == null)
            return;

            //add the current node's value
            ans.add(curr.data);

            //If the curr's left is not null so keep moving towards left
            if(curr.left != null)
            curr = curr.left;
            else
            curr = curr.right;
        }
    }

    // Function to add the leaf nodes of the tree
    private static void addLeafNodes(TreeNode root, List<Integer> ans) {
        // if the root is a leaf node add it to the answer
        if (root.left == null && root.right == null)
            ans.add(root.data);

        // Keep moving to the left if not null
        if (root.left != null)
            addLeafNodes(root.left, ans);
        // Keep moving towards right if not null
        if (root.right != null)
            addLeafNodes(root.right, ans);
    }

    // Function to add the right boundary
    private static void addRightBoundary(TreeNode root, List<Integer> ans) {
        // for storing and then retrieving the values in reverse order
        Stack<Integer> temp = new Stack<>();

        TreeNode curr = root;

        while (curr != null) {
            // If the current node is leaf node we stop
            if (curr.left == null && curr.right == null)
                break;

            // Add the current node
            temp.add(curr.data);

            // If the curr's right is not null keep moving towards right
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        // retrieve the reverse values from the stack pop operation
        while (!temp.isEmpty()) {
            ans.add(temp.pop());
        }
    }
}