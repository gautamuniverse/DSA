public class Solution{
    static class Stack {
        int size;
        int index;
        int [] arr;
        Stack(int capacity) {
            // Write your code here.
            arr = new int [capacity];
            size = capacity;
            index = -1;
            
        }
        public void push(int num) {
            // Write your code here.
            if(isFull() == 0)
            {
                index++;
            arr[index] = num; 
            }
            
        }
        public int pop() {
            // Write your code here.
            int top = -1;
            if(isEmpty() == 0)
            {
                top = arr[index];
                index--;
                return top;
            }
            return top;
        }
        public int top() {
            // Write your code here.
            int top = -1;
            if(isEmpty() == 0)
            return arr[index];
            
            return top;
        }
        public int isEmpty() {
            // Write your code here.
            return index == -1?1:0;
        }
        public int isFull() {
            // Write your code here.
            return index+1 == size?1:0;
        }
    }
}