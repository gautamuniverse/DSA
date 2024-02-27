/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.

        //Both the children exists
        if(root.left != null && root.right != null)
        {
            int sum = root.left.data + root.right.data;
            if(sum != root.data)return false;
            else
            return isParentSum(root.left) && isParentSum(root.right);
        }
        //Only the left child exists
        else if(root.left != null)
        {
            if(root.data != root.left.data)return false;
            else return isParentSum(root.left);
        }
        //Only the right child exists
        else if(root.right != null)
        {
            if(root.data != root.right.data) return false;
            else return isParentSum(root.right);
        }
        
        return true; // no children
    }
}s