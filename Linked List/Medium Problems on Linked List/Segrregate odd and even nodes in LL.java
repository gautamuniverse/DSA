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
    public static Node segregateEvenOdd(Node head)
    {
        // Write Your Code Here.
        //Naive recursive approach

        //base case
        // if(head == null || head.next == null)
        // {
        //     return head;
        // }
        // //assuming that recursion will return the head of the sorted list 
        // Node smallAns = segregateEvenOdd(head.next);
        // head.next = smallAns;

        // //If new list's head is even valued, then find the occurance of first odd
        // if(smallAns.data %2 == 0)
        // {   
        //     //if head value is odd then that means we need to place it after evens
        //     if(head.data %2 ==1)
        //     {
        //     Node temp = head;
        //     while(temp.next != null && temp.next.data %2 == 0)
        //     {   
        //         temp = temp.next;
        //     }
            
        //     Node temp2 = temp.next;
        //     temp.next = head;
        //     head.next = temp2;
        //     return smallAns;

        //     }

        //     //head value is even therefore no need to move its position
        //     else
        //     {
                
        //         return head;
        //     }
        // }

        // //new returned list start is odd, that means all the nodes after it are also node,
        // //therefore simple return the head
        // else
        // {
           
        //     return head;
        // }


        //Iterative approach - Optimal

        Node temp = head;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;

        while(temp != null)
        {

            if(temp.data %2 == 0)
            {
                if(evenStart == null)
                {
                    evenStart = temp;
                    evenEnd = evenStart;
                }
                else
                {
                    evenEnd.next = temp;
                    evenEnd = evenEnd.next;
                }
            }
            else
            {
                if(oddStart == null)
                {
                    oddStart = temp;
                    oddEnd = oddStart;
                }
                else
                {
                    oddEnd.next = temp;
                    oddEnd = oddEnd.next;
                }
            }
            temp = temp.next;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}