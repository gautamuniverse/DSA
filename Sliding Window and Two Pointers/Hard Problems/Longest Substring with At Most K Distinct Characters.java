import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here

		// Naive
		// int longest = 0;
		// for(int i = 0; i< str.length(); i++)
		// {
		// Set<Character> st = new HashSet<>();
		// ArrayList<Character> al = new ArrayList<>();
		// for(int j = i; j< str.length(); j++)
		// {
		// st.add(str.charAt(j));
		// al.add(str.charAt(j));
		// if(st.size() <= k)
		// {
		// longest = Math.max(longest, al.size());
		// }
		// }
		// }

		// return longest;

		// Optimal

		int left = 0;
		int right = 0;

		int longest = 0;
		Map<Character, Integer> charCount = new HashMap<>();

		while (right < str.length()) {
			char ch = str.charAt(right);
			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

			// below condition can be if or while doesn't matter as it will adjust only one
			// iteration
			if (charCount.size() > k) {
				char leftChar = str.charAt(left);
				charCount.put(leftChar, charCount.get(leftChar) - 1);
				if (charCount.get(leftChar) == 0) {
					charCount.remove(leftChar);
				}
				left++;
			}

			longest = Math.max(longest, right - left + 1);
			right++;
		}

		return longest;

	}

}
