public class Solution {

    static boolean isSymmetrical(TreeNode left,TreeNode right){

        if(left==null || right ==null){

            return left==right;

        }

        // if(left.val!=right.val) return false;

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);

    }

    public static boolean isSymmetric(TreeNode root) {

        // Write your code here.

        return root==null || isSymmetrical(root.left, root.right);

 

    }

}

