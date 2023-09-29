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
    public static Node kReverse(Node head, int k) {
        // Write your code here.

        //recursive approach
        //Time - O(N)
        //Space - O(N)


        //base case
        // if(head == null || head.next == null)
        // return head;

        // //Check if n is divisbly by k
        // if(k > listLength(head))
        // return head;

        // Node temp = head;
        // Node prev = null;
        // Node nextNode = null; 
        // int i = 0;

        // //Reverse the first k groups
        // while(i < k && temp != null)
        // {   
        //    nextNode= temp.next;
        //    temp.next = prev;
        //    prev = temp;
        //    temp = nextNode;
        //    i++;
        // }
        // //Call recursion on remaining list
        // Node smallAns = kReverse(temp, k);
        
        // //Head should point to the returned node
        // head.next = smallAns;

        // return prev;


        //Optimal Approach - O(N) , Space - O(1)
        //Iterative

        if(head == null || k == 1)
        return head;

        int count = listLength(head);

        Node dummy = new Node();
        dummy.next = head;
        Node curr = dummy, prev = dummy, nex = dummy;

        //Keep reversing k groups until the current count of nodes is greater than equal to K
        while(count >= k)
        {
            curr = prev.next;
            nex = curr.next;
            // for a k group we will be performing only k-1 operations to reverse the k set of nodes 
            for(int i = 1; i<k; i++)
            {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count-=k;
        }

        return dummy.next;
    }

    private static int listLength(Node head)
    {   
        Node temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }

        return count;
    }
}