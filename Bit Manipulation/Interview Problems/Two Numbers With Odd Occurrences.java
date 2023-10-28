public class Solution {

    public static int[] twoOddNum(int[] arr) {

       int xorOfAll = 0;

       for(int i : arr)
       {
           xorOfAll = xorOfAll ^ i;
       }

       //Find the right most set bit mask of the xorOfAll
       int rmsbm = xorOfAll & (-xorOfAll);

       //Find the two unique numbers by seggregating them in two lists and xor them separately
       //Seggregate them in the condition that the rmsb is on or off
       int num1 = 0;
       int num2 = 0;
       for(int i : arr)
       {
           if((i & rmsbm) == 0)
           {    
               num1 = num1^i;
           }
            else
            {
                num2 = num2^i;
            }
       }

       int [] ans = new int[2];
       if(num1 > num2)
       {
           ans[0] = num1;
           ans[1] = num2;
       }
       else
       {
           ans[0] = num2;
           ans[1] = num1;
       }

       return ans;
    }

}
