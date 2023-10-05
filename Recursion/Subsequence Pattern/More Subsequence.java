import java.util.HashSet;

public class Solution {
    public static String moreSubsequence(int n, int m, String a, String b) {
        // Write your code here

        int sizeA = uniqueChars(a);
        int sizeB = uniqueChars(b);

        if(sizeA > sizeB)
        {
            return a; 
        }

        else if (sizeB > sizeA)
        return b;

        else
        {
            return a.length()>=b.length()?a:b;
        }
    }

    private static int uniqueChars(String st)
    {
        HashSet<Character> set = new HashSet<>();

        for(char i : st.toCharArray())
        {
            set.add(i);
        }

        return set.size();
    }
}


// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;

// public class Solution {
//     public static String moreSubsequence(int n, int m, String a, String b) {
//         // Write your code here

//         long sizeA = subsequences(a).size();
//         long sizeB = subsequences(b).size();

//         if(sizeA >= sizeB)
//         return a;

//         else
//         return b;

//     }

//     private static Set<String> subsequences(String a)
//     {
//         if(a.length() == 0)
//         {   Set<String> st = new HashSet<>();
//             st.add("");
//             return st;
//         }
//         char firstChar = a.charAt(0);
//         Set<String> small = subsequences(a.substring(1));

        
//         ArrayList<String> arr = new ArrayList<>();
//         for(String i : small)
//         {
//             arr.add(i);
//         }
//         int size = small.size();
//         int k = 0;
//         while(k < arr.size())
//         {
//             small.add(firstChar + arr.get(k));
//             k++;

//             if(small.size() >= Integer.MAX_VALUE)
//             return small;
//         }

//         return small;
//     }
// }
