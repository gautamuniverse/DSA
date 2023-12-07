//No Inbuilt functions solution

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
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public ListNode mergeKLists(ListNode[] lists) {
      //Base cases
        if(lists.length == 0 || (lists.length == 1 && lists[0] == null)) return null;

        int k = lists.length;
        for(int i = 0; i< k; i++)
        {
            ListNode head = lists[i];
            if(head == null) continue;
            while(head != null){
              //Insert into the heap each node's value
                insertIntoHeap(head.val);
                head = head.next;
            }
        }

        //If all the linked lists are empty
        if(arr.size() == 0) return null;


        //Create a new Linked List and fetch node values from the heap in ascending order using the remove function
        ListNode head = new ListNode(remove());
        ListNode temp = head;
        while(!arr.isEmpty()){
            temp.next = new ListNode(remove());
            temp = temp.next;
        }
        return head;
    }

    private void insertIntoHeap(int num){
        arr.add(num);
        int index = arr.size() - 1;

        if(index == 0)return;

        while(index > 0){
            int parentIndex = (index - 1)/2;
            if(arr.get(parentIndex) > arr.get(index))
            {
                int temp = arr.get(parentIndex);
                arr.set(parentIndex, arr.get(index));
                arr.set(index, temp);
                index = parentIndex;
            }
            else
            break;
        }
    }

    private int remove(){
        if(arr.size() == 1) return arr.remove(0);

        int ans = arr.get(0);
        arr.set(0, arr.remove(arr.size()-1));

        int parentIndex = 0;
        int smaller, child1, child2;

        while(true){

        child1 = (parentIndex * 2) + 1;
        child2 = (parentIndex * 2) + 2;
        smaller = parentIndex;

        if(child1 < arr.size() && arr.get(child1) < arr.get(smaller))
        {
            smaller = child1;
        }

        if(child2 < arr.size() && arr.get(child2) < arr.get(smaller)){
            smaller = child2;
        }
            if(smaller != parentIndex){
            int temp = arr.get(smaller);
            arr.set(smaller, arr.get(parentIndex));
            arr.set(parentIndex, temp);
            parentIndex = smaller;
            }
            else
            break;
        }

        return ans;
    }
}


// Using inbuilt priority queue solution


import java.util.PriorityQueue;

/****************************************************
	Following is the Node class for the Singly Linked List

		class LinkedListNode<Integer> {
			int data;
			LinkedListNode<Integer> next;

			public LinkedListNode(int data) {
				this.data = data;
			}
		}

****************************************************/

public class Solution {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        // Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int k = listArray.length;
		for(int i = 0; i< k; i++)
		{
			LinkedListNode<Integer> head = listArray[i];
			while(head != null)
			{
				pq.add(head.data);
				head = head.next;
			}
		}

		LinkedListNode<Integer> head = new LinkedListNode<Integer>(pq.remove());
		LinkedListNode<Integer> temp = head;
		while(!pq.isEmpty()){
			temp.next = new LinkedListNode<Integer>(pq.remove());
			temp = temp.next;
		}

		return head;
    }
}