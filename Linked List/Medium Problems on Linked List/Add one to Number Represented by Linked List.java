//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    public static Node addOne(Node head) {
        if (head == null)
            return new Node(1); // If the input is null, return a new node with value 1.

        // Reverse the list, add one, and reverse it again
        head = reverseList(head);
        head = addOneHelper(head);
        head = reverseList(head);

        return head;
    }

    private static Node addOneHelper(Node head) {
        // Base case
        if (head == null)
            return head;

        head.data = head.data + 1;
        int carry = head.data / 10;
        head.data = head.data % 10;

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
            curr.data = curr.data + carry;
            carry = curr.data / 10;
            curr.data = curr.data % 10;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }

        return head;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
