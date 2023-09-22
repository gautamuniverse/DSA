

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {

    public static boolean detectCycle(Node head) {
        //Your code goes here
        //There is a cycle in a linked list if the same node is repeated on traversal
        //Use two pointer approach, take two pointers, slow and fast
        //The fast pointer will eventually coincide with the slow pointer, return true form that point

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow.equals(fast))
            return true;
        }

        return false;
    
    }
}