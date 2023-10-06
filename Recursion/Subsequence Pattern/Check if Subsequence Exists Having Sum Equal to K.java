//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
    
    return helper(arr, K, 0, 0);
  }
  
  private static boolean helper(int [] arr, int k, int sum, int index)
  {     
        //Base case
        if(index == arr.length)
        {
            if(sum == k)
            return true;
            else
            return false;
        }
        
        if(sum > k)
        return false;
        
        //Because we need only one subsequence to prove presence, therefore no need to perform further recursion calls
        //Just return true from there.
        //Take case
        if(helper(arr, k, sum+arr[index], index+1))
        return true;
        //Not take case
        if(helper(arr, k, sum, index+1))
        return true;
        
        //If none of the take and not take recursion calls generate a subsequence, return false.
        return false;
  }
}
     