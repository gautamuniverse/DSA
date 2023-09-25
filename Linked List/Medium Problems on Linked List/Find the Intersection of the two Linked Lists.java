/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Optimal 1 - Time - O(2N) Space - O(1) , n being the length of the larger linked list
        //Not recommended, because very lengthy

        // int dist1 = getDistance(headA);
        // int dist2 = getDistance(headB);

        // // System.out.println("Distance 1 :"+dist1+" Distance 2: "+dist2);

        // ListNode commonNode = null;
        // if(dist1 == dist2)
        // {
        //     while(headA != null && headB!= null)
        //     {
        //         if(headA.equals(headB))
        //         return headA;

        //         headA = headA.next;
        //         headB = headB.next;
        //     }
        // }
        // else if(dist1 > dist2)
        // {
        //     int stepsAhead = dist1 - dist2;
        //     int  i = 0;
        //     while(i < stepsAhead)
        //     {
        //         headA = headA.next;
        //         i++;
        //     }

        //     while(headA != null && headB !=null)
        //     {
        //         if(headA.equals(headB))
        //         return headA;

        //         headA = headA.next;
        //         headB = headB.next;
        //     }
        // }
        // else
        // {
        //     int stepsAhead = dist2 - dist1;
        //     int  i = 0;
        //     while(i < stepsAhead)
        //     {
        //         headB = headB.next;
        //         i++;
        //     }

        //     while(headA != null && headB !=null)
        //     {
        //         if(headA.equals(headB))
        //         return headA;

        //         headA = headA.next;
        //         headB = headB.next;
        //     }
        // }

        // return commonNode;

        //Optimal 2 -  Time - O(2M) , M being the length of the larger linked list
        //Space - O(1). recommended beause the code is clean.

        //Algo
        // The difference of length method requires various steps to work on it. Using the same concept of difference of
        // length, a different approach can be implemented. The process is as follows:-

        // Take two dummy nodes for each list. Point each to the head of the lists.
        // Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating
        // until they collide.

        //Why this works?
        //Well because since we are switching between the heads, this way we are actually covering the extra length
        // the other list may have

        ListNode a = headA;
        ListNode b = headB;

        while(a != b)
        {
            a = a==null ? headB:a.next;
            b = b==null ? headA:b.next;
        }

        return a;

    }

    private static int getDistance(ListNode head)
    {
        if(head == null)
        return 0;

        ListNode temp  =head;
        int count = 0;
        while(temp.next != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }
}