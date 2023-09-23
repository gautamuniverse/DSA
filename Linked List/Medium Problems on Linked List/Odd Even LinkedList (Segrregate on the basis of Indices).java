/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //Base case
        if(head == null || head.next ==null){
            return head;
        }

        //Iterative approach - Optimal

        ListNode curr = head;
        ListNode oddNode = null;
        ListNode evenStart = null;
        ListNode evenNode = null;

        int index = 1;
        
        while(curr != null)
        {
            if(index %2 == 0)
            {
                if(evenStart == null)
                {
                    evenStart = curr;
                    evenNode = curr;
                }
                else
                {
                    evenNode.next = curr;
                    evenNode = evenNode.next;
                }
            }
            else
            {
                if(oddNode == null)
                {
                    oddNode = curr;
                }
                else
                {
                    oddNode.next = curr;
                    oddNode = oddNode.next;
                }
            }

            curr = curr.next;
            index++;
        }

        oddNode.next = evenStart;
        evenNode.next = null;

        return head;
    }
}