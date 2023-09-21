/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        //Copy the values of the next nodes to the current node
        ListNode temp = node;
        while(temp.next != null)
        {
            temp.val = temp.next.val;
            temp=temp.next;
        }


        temp = node;
        //Traverse again to delete the last node.
        while(temp.next.next != null)
        {
            temp=temp.next;
        }
        temp.next = null;
        
    }
}