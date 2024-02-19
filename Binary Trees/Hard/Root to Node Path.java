
/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;

        String paths = "";
        findPaths(root, ans, paths);
        return ans;
    }

    private static void findPaths(BinaryTreeNode root, List<String> ans, String paths) {
        // if we encountered a node beyond the leaf node then return
        if (root == null)
            return;
        // If the current path string is empty then add the current node's value without
        // any space
        if (paths.isEmpty())
            paths += root.data;
        // If the current path already has some prefilled node values then adda the
        // current node to the path with a space
        else {
            paths += " " + root.data;
        }

        // If the current node is a leaf node then add the current path to the final ans
        // list
        if (root.left == null && root.right == null) {
            ans.add(paths);
            return;
        }

        // Recursively check the left and right branches of the tree.
        findPaths(root.left, ans, paths);
        findPaths(root.right, ans, paths);
    }
}