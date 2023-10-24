public class Solution {
    public static int[] bitManipulation(int num, int i){
        // Write your code here.

        //O(N)
        // String binaryNumber = Integer.toBinaryString(num);

        // int ans [] = new int [3];
        // ans[0] =Integer.parseInt("" + binaryNumber.charAt(i));
        // if(ans[0] == 1)
        // {
        //     ans[1] = num;
        //     ans[2] = num;
        // }
        // else
        // {
        //     char [] binaryNumArray = binaryNumber.toCharArray();
        //     binaryNumArray[i] = '1';
        //     String s = new String(binaryNumArray);

        //     //Here 2 represent that the number represented by the string is a binary number
        //     ans[1] = Integer.parseInt(s, 2);

        //     ans[2] = num;

        // }

        // return ans;


        //Using Binary Operators
        //Time - O(1)

        int bitAtI = (1<<(i-1) & num) == 0?0:1;
        int setBit = 1<<(i-1) | num;
        int clearBit = ~(1<<(i-1)) & num;

        int [] ans = {bitAtI, setBit, clearBit};
        return ans;
    }
}
