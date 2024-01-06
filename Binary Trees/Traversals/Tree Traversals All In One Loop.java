
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
import java.util.Stack;

class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.`
        // List<Integer> in = new ArrayList<>();
        // List<Integer> pre = new ArrayList<>();
        // List<Integer> post = new ArrayList<>();

        // inOrder(in, root);
        // preOrder(pre, root);
        // postOrder(post, root);

        // List<List<Integer>> ans = new ArrayList<>();
        // ans.add(in);
        // ans.add(pre);
        // ans.add(post);

        // return ans;

        // Iterative all traversals in one loop

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<Pair> st = new Stack<>();
        // Here the num in pair represents 1, 2, 3, where
        // 1 means it is for preOrder
        // 2 means it is for inOrder
        // 3 means it is for postOrder
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            // get the topmost pair in the stack
            Pair curr = st.pop();

            // If the num == 1 that means it is for preOrder
            if (curr.num == 1) {
                TreeNode temp = curr.node;
                curr.num++;
                pre.add(temp.data);
                // Push the pair back to stack with incremented num
                st.push(curr);

                // if the current node has a left, push it into the stack as a new pair
                if (temp.left != null) {
                    st.push(new Pair(temp.left, 1));
                }

            }
            // Num == 2 it is for inOrder
            else if (curr.num == 2) {
                in.add(curr.node.data);
                curr.num++;
                st.push(curr);

                if (curr.node.right != null) {
                    st.push(new Pair(curr.node.right, 1));
                }
            }
            // num == 3 means postOrder
            else {
                // Dont do anything simply add the node value to postOrder list
                post.add(curr.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }

    private static void inOrder(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;

        inOrder(ans, root.left);
        ans.add(root.data);
        inOrder(ans, root.right);

    }

    private static void preOrder(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;

        ans.add(root.data);
        preOrder(ans, root.left);
        preOrder(ans, root.right);

    }

    private static void postOrder(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;

        postOrder(ans, root.left);
        postOrder(ans, root.right);
        ans.add(root.data);
    }
}