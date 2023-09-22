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

public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.

        //Use the tortoise algorithm
        //Fast and slow pointers

        //Time - O(N/2)
        //Space - O(1)
        
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next!= null)
        {  
            fast = fast.next.next;
            slow = slow.next;
            
        }


        return slow;
    }
}