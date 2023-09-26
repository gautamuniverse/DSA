#https://practice.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab


class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        //Base case 
        if(head == null)
        return null;

        //Handle the case of head being duplicate
        while(head.next != null)
        {
            if(head.data == head.next.data)
            {   Node prevNode = head;
                head = head.next;
                head.prev =null;
                prevNode.next = null;
            }
            else
            break;
        }

        Node temp = head;
        while(temp.next != null)
        {
            if(temp.data == temp.next.data)
            {
                Node prevNode = temp.prev;
                Node next = temp.next;
                prevNode.next = next;
                next.prev = prevNode;
                temp = next;
            }
            else
            {
                temp = temp.next;
            }
        }

        return head;
    }
}