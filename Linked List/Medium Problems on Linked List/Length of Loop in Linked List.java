import java.util.HashSet;
import java.util.Set;



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

public class Solution
{
    public static int lengthOfLoop(Node head) {
        // Write your code here

         // Write your code here.
        //nAIVE aPPROACh - use hashing

        // Set<Node> set = new HashSet<>();

        // Node temp = head;

        // while(temp.next != null)
        // {
        //     if(set.contains(temp))
        //     return temp;

        //     set.add(temp);

        //     temp = temp.next;
        // }

        // return null;


        //Optimal approach
        //Using the slow, fast pointer
        //We will use the concept of collission point and the collisionNode pointer, that is
        //The distance of the head pointer to the loop start point will be the same as the the distance
        //of the collision point to the loop start node

         //base case, loop/cycle not possible
         if(head == null || head.next == null)
         return 0;
         
         Node slow = head;
         Node fast = head;
         Node collisionNode = null;

         while(fast.next != null && fast.next.next != null)
         {

            slow = slow.next;
            fast = fast.next.next;

            if(slow.equals(fast))
            {
                collisionNode = slow;
                break;
            }
         }
        //cycle is not present.
         if(collisionNode == null)
         return 0;

        // Cycle exists. Finding it's length
        int length = 0;
        do {
            fast = fast.next;
            length++;
        } while (fast != slow);

        return length;
    }
}