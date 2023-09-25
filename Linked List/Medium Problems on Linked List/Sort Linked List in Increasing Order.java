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
    public ListNode sortList(ListNode head) {

        //Naive -
        //time - O(nLogN)
        //Space - O(n)

        // ArrayList<Integer> arr = new ArrayList<Integer>();

        // ListNode temp = head;
        // while(temp != null)
        // {
        //     arr.add(temp.val);
        //     temp = temp.next;
        // }

        // Collections.sort(arr);

        // temp = head;
        // for(Integer i : arr)
        // {
        //     temp.val = i;
        //     temp= temp.next;
        // }

        // return head;

        //Optimal Approach - Merge Sort
        
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = get_mid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    public ListNode get_mid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode tail = dummyhead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyhead.next;
    }
}