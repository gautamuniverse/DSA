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
 };

 *****************************************************************/
 
 //Problem statement
 //Form a doubly linked list out of the given array.
 //Return the head of the doubly list.

public class Solution
{
    public static Node constructDLL(int []arr) {
        // Write your code here
		

        Node head = new Node(arr[0]);
        head.prev = null;

        Node temp = head;

        for(int i = 1; i< arr.length; i++)
        {
            Node newNode = new Node(arr[i]);
            newNode.prev = temp;

            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }
}