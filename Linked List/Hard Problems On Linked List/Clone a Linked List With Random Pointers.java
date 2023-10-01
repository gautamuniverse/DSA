/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node random;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.random = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.random = null;
     }
     Node(int data, Node next, Node random)
     {
         this.data = data;
         this.next = next;
         this.random = random;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node cloneLL(Node head) {
        // Write your code here.

        // Approach:
        // The optimisation will be in removing the extra spaces, i.e, the hashmap used in brute force. This approach can be broken down into three steps. 

        // Create deep nodes of all nodes. Instead of storing these nodes in a hashmap, we will point it to the next of the original nodes.
        // Take a pointer, say itr, point it to the head of the list. This will help us to point random pointers as per the original list. This can be achieved by itr->next->random = itr->random->next
        // Use three pointers. One dummy node whose next node points to the first deep node. itr pointer at the head of the original list and fast which is two steps ahead of the itr. This will be used to separate the original linked list with the deep nodes list.
       
        // Time - O(3N) ~ O(N)
        // Space - O(1)

       //Step - 1 -  Next pointers
       Node itr = head;

       while(itr != null)
       {
           Node front = itr.next;
           itr.next = new Node(itr.data);
           itr.next.next = front;
           itr = front;
       }

       //Step 2 - Random Pointers
       itr = head;

       while(itr != null)
       {
           if(itr.random != null)
           {    
               //itr.random.next will be the deep copy node
               itr.next.random = itr.random.next;
           }
           itr = itr.next.next;
       }

       //Step - 3- Split the two linked lists
       Node pseudoHead = new Node(-1);
       Node copyPseudo = pseudoHead;
        itr =head;
       while(itr != null)
       {    
           copyPseudo.next = itr.next;
           itr.next = itr.next.next;
           copyPseudo= copyPseudo.next;
           itr = itr.next;
       }

       return pseudoHead.next;


    }
}