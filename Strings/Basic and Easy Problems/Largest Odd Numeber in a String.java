class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int lastChar = num.charAt(n-1);
        int lastNum = lastChar - 48;
        //String is already ODD return the original num
        if(lastNum%2 != 0)
        return num;

        // Last character is not odd, traverse from the backward to find the first occurance of the odd number
        else
        {
            int i = n-1;
            while(i >= 0)
            {
                int currNum = num.charAt(i) - 48;
                //first odd occurance found from backward, return the substring from 0 to this index
                if(currNum%2 !=0)
                {
                    return (num.substring(0, i+1));
                }
                i--;
            }
        }
    //No odd number found in the entire num string return empty string
    return "";
    }
}