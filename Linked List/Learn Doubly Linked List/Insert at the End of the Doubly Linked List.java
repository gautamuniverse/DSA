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

public class Solution
{
    public static Node insertAtTail(Node list, int K) {
        // Write your code here

        if(list == null)
        {
            Node newNode = new Node(K);
            return newNode;
        }

        Node temp = list;
        Node prev=  null;
        while(temp.next != null)
        {   prev = temp;
            temp= temp.next;
        }

        temp.next = new Node(K);
        temp.prev = prev;

        return list;
    }
}