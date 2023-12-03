//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
   boolean isHeap(Node tree) {
        // Base case: an empty tree is a max heap
        if (tree == null)
            return true;

        // Check if the current node's value is greater than its children
        if (tree.left != null && tree.data < tree.left.data)
            return false;

        if (tree.right != null && tree.data < tree.right.data)
            return false;

        // Check if the tree is complete
        if (!isComplete(tree, 0, countNodes(tree)))
            return false;

        // Recursively check the left and right subtrees
        boolean isLeftHeap = isHeap(tree.left);
        boolean isRightHeap = isHeap(tree.right);

        // Return true only if both subtrees are max heaps
        return isLeftHeap && isRightHeap;
    }

    // Function to count the number of nodes in the tree
    int countNodes(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to check if the tree is complete, all the level except last shoudl be completly filled
    //Last level node must have no children.
    boolean isComplete(Node root, int index, int nodes) {
        // An empty tree is complete
        if (root == null)
            return true;

        // If the current index is greater than or equal to the number of nodes, it's not complete
        //It means that there exists a left child for a node at the last level, whereas it should have no children
        //So it violates the CBT property
        if (index >= nodes)
            return false;

        // Recursively check the left and right subtrees
        return isComplete(root.left, 2 * index + 1, nodes) && isComplete(root.right, 2 * index + 2, nodes);
    }
    }