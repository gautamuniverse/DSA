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
    public static Node sortList(Node head) {
        //Write your code here
        //Merge Sort

        //base case
        if(head == null || head.next == null)
        {
            return head;
        }

        //Make the two sorted linked lists
        Node list1 = new Node(head.data);
        Node list2 = new Node(head.next.data);
        Node temp = head;
        Node l1 = list1;
        while(temp.next != null)
        {

            if(temp.next.next == null)
            {
                break;
            }
            l1.next = new Node(temp.next.next.data);
            l1 = l1.next;
            temp=temp.next.next;
        }

        temp = head.next;
        Node l2 = list2;
        while(temp.next != null)
        {
            if(temp.next.next == null)
            {
                break;
            }

            l2.next = new Node(temp.next.next.data);
            l2 = l2.next;
            temp = temp.next.next;
        }
        //reverse the list 2, as it is in decreasing order.
        list2 = reverseList(list2); 


        //Merge the two sorted lists and get the new head.
        Node newhead = mergeSortedLists(list1, list2);
        return newhead;
    }


    private static Node reverseList(Node head)
    {
        //base case
        if(head == null || head.next == null)
        return head;

        Node reversedHead = reverseList(head.next);

        Node temp = head.next;
        head.next = null;
        temp.next = head;

        return reversedHead;
    }

    //Code to merge two sorted lists
    private static Node mergeSortedLists(Node list1, Node list2)
    {
        //base cases
        if(list1 == null)
        return list2;
        if(list2 == null)
        return list1;


        Node head = null;
        Node tail = null;

        Node l1 = list1;
        Node l2 = list2;

        if(l1.data < l2.data)
        {
            head = l1;
            tail = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            tail=l2;
            l2 = l2.next;
        }


        while(l1 != null && l2 != null)
        {
            if(l1.data < l2.data)
            {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        if(l1 == null)
        {
            tail.next = l2;
        }
        else
        tail.next = l1;

        return head;
    }
}