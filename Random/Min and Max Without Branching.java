import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> findMinMax(int a, int b) {
		// Write your code here
		
		int dif = a-b;
		int sign = (dif>>31) & 1; //Get the sign bit, 1 if a < b, 0 if a >=b
		int max = a - sign * dif; // If a < b, subtract diff; otherwise, subtract 0
		int min = b + sign * dif; // If a < b, add diff; otherwise, add 0
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(min);
		ans.add(max);

		return ans;
	}

}