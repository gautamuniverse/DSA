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
 };

 *****************************************************************/

public class Solution {
    public static Node deleteMiddle(Node head) {
        // Write your code here.

        //naive approach

        //base case
        if(head.next == null)
        {
            return null;
        }
        if(head.next.next == null)
        {
            head.next = null;
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!= null && fast.next!= null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = prev.next.next;
        return head;
    }
}