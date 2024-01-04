/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.`
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        inOrder(in, root);
        preOrder(pre, root);
        postOrder(post, root);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
        
    }

    private static void inOrder(List<Integer> ans, TreeNode root)
    {
        if(root == null) return;


        inOrder(ans, root.left);
        ans.add(root.data);
        inOrder(ans, root.right);

    }

    private static void preOrder(List<Integer> ans, TreeNode root)
    {
        if(root == null) return;

        ans.add(root.data);
        preOrder(ans, root.left);
        preOrder(ans, root.right);

    }

    private static void postOrder(List<Integer> ans, TreeNode root)
    {
        if(root == null) return;

        
        postOrder(ans, root.left);
        postOrder(ans, root.right);
        ans.add(root.data);
    }
}