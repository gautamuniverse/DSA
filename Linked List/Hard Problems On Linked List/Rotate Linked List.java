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
    public static Node rotate(Node head, int k) {
        // Write your code here.

        //Recursive solution-
        //Time - O(N)
        //Space - O(N) for recursion call stack

        //base cases
        // if(head.next == null)
        // return head;

        // if(k <= 0)
        // return head;

        // //if the number of rotations are greater than k then find the effective rotations
        // //If the effective rotations come out to be exactly equal to 0 rotations then return head
        // int count = countNode(head);
        // if(k%count == 0)
        // return head;

        // k = k%count;


        // //Perform 1 rotation
        // Node temp = head;
        // Node prev = null;
        // while(temp.next != null)
        // {   
        //     prev = temp;
        //     temp = temp.next;
        // }

        // prev.next = null;
        // temp.next = head;
        // head = temp;

        // //Recursively perform the k-1 rotations
        // Node smallAns = rotate(head, k-1);

        // return smallAns;

        //Optimal Solution
        //Iterative -- time - O(N)
        //Space - O(1)

         if(head == null||head.next == null||k == 0) return head;
        //calculating length
        Node temp = head;
        int length = 1;
        while(temp.next != null) {
            ++length;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head;
        k = k%length; //when k is more than length of list
        int end = length-k; //to get end of the list
        while(end--!=0) temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;
            
        return head;
    }

    private static int countNode(Node head)
    {
        Node temp = head;
        int count = 0;
        while(temp !=null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }
}