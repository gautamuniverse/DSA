public class Solution {
    public static int flipBits(int A, int B){
        // Write your code here.

        //Approach 2
        //Calculate the XOR of A and B, which will essentially result in the number of different bits
        //between A and B
        //Then simply calculate those bits
        int count = 0;
        int xor = A ^ B;
        while(xor != 0)
        {
            if((xor & 1) == 1)
            count++;

            xor = xor>>1;
        }
        return count;

        //Approach 1, O(K), k is total number of bits required to convert to B

        // int tempA = A;
        // int tempB = B;

        // int count = 0;
        // while(tempA!=0 && tempB !=0)
        // {
        //     if(((tempA & 1) == 0 && (tempB & 1) == 1) || (((tempA & 1) == 1) && ((tempB & 1) == 0)))
        //     count++;

        //     tempA = tempA>>1;
        //     tempB = tempB>>1;
        // }

        // while(tempA != 0)
        // {
        //     if((tempA&1) == 1)
        //     count++;

        //     tempA = tempA>>1;
        // }   

        // while(tempB != 0)
        // {
        //     if((tempB & 1) == 1)
        //     count++;

        //     tempB = tempB>>1;
        // }

        // return count;

    }
}