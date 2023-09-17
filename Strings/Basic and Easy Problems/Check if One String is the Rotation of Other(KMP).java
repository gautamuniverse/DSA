class Solution {
    public boolean rotateString(String p, String q) {
         // // bases cases
        // if(p.length() !=  q.length())
        // return 0;
        
        // // If both the strings are equal return 1
        // if(p.equals(q))
        // return 1;

        // // Naive Solution; One by one rotate the q string and compare with p
        // // String
        // // Time - O(N*N)

        // // start iteration and rotate the string one by one to the right
        // int i = 0;
        // String newString = q;
        // while(i < q.length())
        // {
        //    newString = newString.substring(1, q.length()) + newString.charAt(0);
        //    if(newString.equals(p))
        //    return 1;

        //    i++;
        // }

        // return 0;

        //Optimal approach, using KMP algorithm
        //Steps: 1- Make a new string by adding string 1 to itself.
        //2- now the string 2 if rotated will be present in the new string as a substring.
      if(p.length() != q.length())
      return false;
      
       p= p+p;

        if(p.contains(q))

        {

            return true;

        }

    return false;
    }
}