class Solution {
    public int beautySum(String s) {
        //Naive
        //We will follow the basic steps of forming the substrings of a string
        //We will use a frequency character array to store the frequencies of each character in the Substring and then we will find the max and min occuring character in the freq array. Then we will substract them, and add the result in the total beauty
        
        //time- O(N^2)
        //Space - O(26) or O(1)
        int totalBeauty = 0;

        for(int i =0;i<s.length(); i++) 
        {   int [] freq = new int [26]; 
            for(int j = i; j<s.length(); j++)
            {
                freq[s.charAt(j) - 'a']++;

                int minOccuring = Integer.MAX_VALUE;
                 int maxOccuring = Integer.MIN_VALUE;
            for(int k = 0; k<freq.length; k++)
            {
                if(freq[k] != 0)
                {
                maxOccuring = Math.max(maxOccuring, freq[k]);
                minOccuring = Math.min(minOccuring, freq[k]);
                }
            }
            totalBeauty+= (maxOccuring-minOccuring);
            }
            
        }


        return totalBeauty;
    }
}