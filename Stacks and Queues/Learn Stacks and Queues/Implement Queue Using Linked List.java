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

 class Queue{
     Node front;
     Node rear;
     void push(){};
     Queue() {
         front = null;
         rear = null;
     }
 }

 *****************************************************************/

public class Solution extends Queue{

    Node head;
    Node temp;
    int size = 0;
    public void push(int x) {
        // Write Your Code Here
        if(size == 0)
        {
            head = new Node(x);
            temp = head;
        }
        else
        {
            temp.next = new Node(x);
            temp = temp.next;
        }

        size++;
    }

    public int pop() {
        // Write Your Code Here
        if(size == 0)
        return -1;

        else
        {   
            int front = head.data;
            head = head.next;
            size--;
            return front;
        }
    }
}