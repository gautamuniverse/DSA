public class Solution {
    static boolean isKthBitSet(int n, int k) {
        // Write your code here.
        if(((1<<(k-1)) & n) == 0)return false;
        return true;
    }
}