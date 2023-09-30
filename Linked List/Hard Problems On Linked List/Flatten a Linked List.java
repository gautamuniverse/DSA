/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node flattenLinkedList(Node head) {

        //Below recursive solution giving TLE
        // TIme -  O(n*n*k). 
        // Space- O(n*k)
        // if (head == null || head.next == null)
        //     return head;

        // // Recursively flatten the next linked list
        // head.next = flattenLinkedList(head.next);

        // // Merge the current linked list with the flattened next linked list
        // head = mergeLists(head, head.next);

        // return head;


        Node temp1 = head;

        Node temp2 = head.next;

 

        while(temp1.next != null) {

            

            temp2 = temp1.next;

            temp1.next = temp2.next;

 

            /*

                Discussion section: Suraj Singh

                After wasting hours ,i figured out . In question, 

                it is mentioned make all next pointer to null,

                 merge all using child pointer, so basically 

                 you guys have not make all next pointer null, 

                 that's why it is giving TLE. 

                 (But ideally this should not give TLE, Condingninja, 

                 should look into it .)

            */

            

            if(temp1.data <= temp2.data) temp2.next = null;

            else temp1.next = null;

            // Merge

            Node dH = new Node(-1);

            Node tail = dH;

            while(temp1 != null && temp2 != null) {

                if(temp1.data <= temp2.data) {

                    tail.child = temp1;

                    temp1 = temp1.child;

                    tail = tail.child;

                }

                else {

                    tail.child = temp2;

                    temp2 = temp2.child;

                    tail = tail.child;

                }

            }

            if(temp2 == null) {

                tail.child = temp1;

            }

            if(temp1 == null) {

                tail.child = temp2;

            } // Merge over

 

            temp1 = dH.child;

        }

 

        return temp1;

    }

    // Helper function to merge two sorted linked lists
    private static Node mergeLists(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node dummy = new Node(0); // Dummy node to simplify merging
        Node current = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                current.child = a;
                a = a.child;
            } else {
                current.child = b;
                b = b.child;
            }
            current = current.child;
        }

        if (a != null) {
            current.child = a;
        } else {
            current.child = b;
        }

        return dummy.child;
    }
}
