import java.util.Arrays;

public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        Arrays.sort(a);




        int arr[] = {a[a.length-2], a[1]};
        return arr;
    }
}