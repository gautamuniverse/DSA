import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int largest = Integer.MIN_VALUE;

        for (int i : arr) {
            if(i >= largest)
            largest = i;
        }
        return largest;
    }
}