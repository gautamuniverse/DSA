import java.util.*;

import java.io.*;

public class Solution {

    static class MinStack {

        Node head;

        static class Node {

            int val;

            Node next;

            int small;

            Node(int val) {

                this.val = val;

            }

        }

        int size;

        MinStack() {

            size = 0;

            head = null;

        }

        void push(int num) {

            if (head == null) {

                head = new Node(num);

                head.small = num;

            }

            else {

                Node temp = new Node(num);

                temp.next = head;

                temp.small = Math.min(head.small, num);

                head = temp;

            }

            size++;

        }

        int pop() {

            if (size == 0)
                return -1;

            size--;

            int m = head.val;

            head = head.next;

            return m;

        }

        int top() {

            if (size == 0)
                return -1;

            return head.val;

        }

        int getMin() {

            if (size == 0)
                return -1;

            return head.small;

        }

    }

}