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

//TIme complexity : O(max length of(list1,list2))
//Space Complexity : O(N)

class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        
        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode;


        int carry = 0;

        while(head1 != null || head2 != null || carry == 1)
        {   
            //Make the current sum of digits, also add the previous carry if there.
            int currentSum = carry + (head1!=null?head1.val:0) + (head2!=null?head2.val:0);
            carry = currentSum/10;
            int currentDigit = currentSum%10;

            //Create a new node with the current Digit and assign to next of temp 
            temp.next = new ListNode(currentDigit);
            temp = temp.next;

            //move head only if they are not null
            head1 = head1!=null?head1.next:head1;
            head2 = head2!=null?head2.next:head2;
        }

        //return dummy's next node, i.e from where the digits start.
        return dummyNode.next;
    }
}