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
    public static boolean isPalindrome(Node head) {
        // write your code here

        //base case
        if(head.next == null)
        return true;

        //find the mid node of the LL
        Node mid = midPoint(head);

        //reverse the second half
        mid.next = reverseLL(mid.next);

        mid = mid.next;
        
        //Check palindrome
        while(mid != null)
        {
            if(head.data != mid.data)
            return false;

            mid = mid.next;
            head= head.next;
        }

        return true;
    }

    private static Node midPoint(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {   
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }


    private static Node reverseLL(Node head)
    {
        // Base case
        if(head == null || head.next == null)
        return head;

        Node smallHead = reverseLL(head.next);

        Node temp = head.next;

        temp.next = head;
        head.next = null;

        return smallHead;

    }
}