/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }
     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        // Base case
        if (head == null) {
            return null;
        }

        // Edge case: handle the case where the first node contains the key
        //Also handles the case when all the node values are equal to key
        while (head != null && head.data == k) {
            Node next = head.next;
            head.next = null;
            if (next != null) {
                next.prev = null;
            }
            head = next;
        }

        Node temp = head;

        //Now that the head is not equal to K, we iterate the next nodes
        while (temp != null) {
            if (temp.data == k) {
                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                // Connect prev and next node
                prevNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            }
            temp = temp.next;
        }

        return head;
    }
}