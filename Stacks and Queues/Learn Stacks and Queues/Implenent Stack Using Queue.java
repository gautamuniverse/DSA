import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{
    static class Stack {
        // Define the data members.
        Queue<Integer> q1;
        Queue<Integer> q2;
        public Stack() {
            // Implement the Constructor.
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            return q1.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return q1.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            q1.add(element);
        }

        public int pop() {
            if (q1.isEmpty())
                return -1;

            while (q1.size() > 1) {
                q2.add(q1.poll());
            }

            int popped = q1.poll();

            // Swap the names of q1 and q2.
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return popped;
        }


        public int top() {
            if (q1.isEmpty())
                return -1;

            while (q1.size() > 1) {
                q2.add(q1.poll());
            }

            int top = q1.poll();
            q2.add(top);

            // Swap the names of q1 and q2.
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }

    }
}