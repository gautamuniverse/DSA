/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node left;
 * public Node right;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * Node(int data, Node left, Node right)
 * {
 * this.data = data;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * 
 *****************************************************************/
public class Solution {
    public static Node createTree(int[] arr) {
        // Write your code here.
        return createTreeHelper(arr, 0);
    }

    private static Node createTreeHelper(int [] arr, int index)
        {
            if(index >= arr.length)
            return null; 

            Node rootNode = new Node(arr[index]);
            rootNode.left = createTreeHelper(arr, 2*index+1);
            rootNode.right = createTreeHelper(arr, 2*index+2);

            return rootNode;
        }

}