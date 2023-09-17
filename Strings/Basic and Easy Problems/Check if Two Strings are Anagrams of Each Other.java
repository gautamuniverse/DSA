
public class Solution {

    public static boolean isAnagram(String str1, String str2) {
        //Your code goes here

        //Naive solution
        //Check length of the string
        //Time -  O(n * n) = O(n^2)
        // if(str1.length() != str2.length())
        // return false;

        // for(int i = 0; i<str1.length(); i++)
        // {   
        //     String stringChar = String.valueOf(str1.charAt(i));
        //     if(!str2.contains(stringChar))
        //     return false;
        // }

        // return true;

        //Optimal Solution
        //Using frequency arrays
        int [] count1 = new int[26];
        int [] count2 = new int[26];

        //Coun tht frequencies of the characters of the first string
        for(int i = 0; i<str1.length(); i++)
        {
            count1[str1.charAt(i)-'a']++;
        }

        //Count the frequencies of the characters of the second string
        for(int i= 0; i< str2.length(); i++)
        {
            count2[str2.charAt(i) - 'a']++;
        }


        //Compare both the arrays
        for(int i = 0; i<26; i++)
        {
            if(count1[i] != count2[i])
            return false;

        } 

        return true; 
    }


}