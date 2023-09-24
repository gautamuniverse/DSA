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

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.

        //Naive
        //Count the number of total nodes, then connect the (total-k)th node to next.next;

        //Base case
        //Time - O(2N)
        //Space - O(1) 
        // if(head.next == null && K == 1)
        // return null;

        // Node temp = head;
        // int count = 0;
        // while(temp != null)
        // {
        //     temp = temp.next;
        //     count++;
        // }

        // //One edge case
        // if(count == K)
        // {
        //     return head.next;
        // }

        // int targetPrev = count - K;

        // temp = head;
        // int  i = 1;
        // while(i < targetPrev)
        // {
        //     temp = temp.next;
        //     i++;
        // }
        // if(temp!= null && temp.next != null)
        // temp.next = temp.next.next;

        // return head;


        // Optimal Approach - 2 Pointer approach
        //time - O(N)
        //Space - O(1)
        //Make a dummy node
        Node start = new Node();
         start.next = head;

         //fast and slow pointing to the dummy node, null at start
         Node  fast = start;
         Node  slow = start;
        //Move the fast node k steps ahead of slow
         for(int i=0; i<K; i++){
             
             fast = fast.next;
             
         }  
            // slow will be pointing to one node before of the target node
             while(fast.next != null){
                 slow = slow.next;
                 fast = fast.next;
             }

             //point the slow's next to target node's next.
            slow.next= slow.next.next;

            // return start's next,in case the k == count then start's next 
            //will be removing the head.
            return start.next;
    }

}