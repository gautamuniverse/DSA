import java.util.Stack;

public class Solution{
    static class Queue {
        // Define the data members(if any) here.

        Stack<Integer> st;
        Stack<Integer> st2;
        Queue() {
            // Initialize your data structure here.
            st = new Stack<>();
            st2 = new Stack<>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            st.push(val);
        }

        int deQueue() {
            // Implement the dequeue() function.
            if(isEmpty())
            return -1;

            while(st.size() > 1)
            {
                st2.push(st.pop());
            }

            int front = st.pop();

            while(st2.size() > 0)
            {
                st.push(st2.pop());
            }

            return front;
        }

        int peek() {
            // Implement the peek() function here.
            if(isEmpty())
            return -1;

            while(st.size() > 1)
            {
                st2.push(st.pop());
            }

            int front = st.peek();
            
            while(st2.size() > 0)
            {
                st.push(st2.pop());
            }
            

            return front;
        }

        boolean isEmpty() {
            // Implement the isEmpty() function here.
            return st.isEmpty();
        }
    }
}