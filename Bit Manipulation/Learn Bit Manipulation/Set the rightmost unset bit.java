public class Solution {
    public static int setBits(int N){
        // Write your code here.

        //Optimal Approach
        //Time - O(1)

        //Check if there's any unset bit
        if((N & (N+1)) == 0) //meaning all the bits are set so return N
        return N;

        //Since there is unset bits, make the right most unset bit as set
        //For example N=9 is 1001 and N+1=10 is 1010. So N | (N+1) = 1011 which is 11.
        return N | (N+1);



        //O(N) Solution
        // int temp = N;

        // int index = 0;
        // boolean zeroFound=false;
        // while(temp != 0)
        // {
        //     if((temp & 1) == 0)
        //     {   zeroFound=true;
        //         break;
        //     }

        //     index++;
        //     temp = temp>>1;
        // }

        // if(!zeroFound)
        // return N;

        // int mask = 1;
        // for(int i = 0; i<index; i++)
        // {
        //     mask = mask <<1;
        // }

        // N = N | mask;

        // return N;
    }
}
