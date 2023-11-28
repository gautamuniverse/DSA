class Solution {
    public int lengthOfLongestSubstring(String input) {
        // write your code here
		// Naive - time - O(N^2) space - O(N)
		// int longest = 1;
		// for (int i = 0; i < input.length(); i++) {
		// String currentLongest = "";
		// boolean unique = true;
		// for (int j = i; j < input.length(); j++) {
		// if (currentLongest.contains(input.charAt(j) + "")) {
		// unique = false;
		// break;
		// } else {
		// currentLongest += input.charAt(j);
		// longest = Math.max(longest, currentLongest.length());
		// }

		// }
		// }

		// return longest;

		// =========================================================================

		// Better - O(2N) space - O(N) for set

		// Set<Character> set = new HashSet<>();

		// int maxLength = Integer.MIN_VALUE;
		// int l = 0, r = 0;
		// while (r < input.length()) {
		// // Check if the current character is there in the set or not
		// // If the set contains the current rth pos character that means there's a
		// // repeating character in the current l-r range, move l pointer and keep
		// // removing the lth positiion character from the set such that the rth pos
		// // character is not there in the set.
		// while (set.contains(input.charAt(r))) {
		// set.remove(input.charAt(l++));
		// }

		// set.add(input.charAt(r));
		// maxLength = Math.max(maxLength, r - l + 1);
		// r++;
		// }

		// return maxLength;

		// =================================================================================

		// Optimal Solution - Space - O(N) time - O(N)

		// Intuition:
		// AS we had to move the left pointer one by one to the position such that there
		// are no repeating character in the set, this costed us O(N) time in the worst
		// case incresing our time complexity to 2N, now to fix this issue we will use
		// map instead of set and we wil push the character along with its position,
		// this way we will be able to track the positions of character last time where
		// it occurred. WHenver we find that there are going to be repearing characters
		// in the map we will simply move the left pointer to the last position of the
		// repeating character + 1, saving us the time to move it one by one.
		// Suppose abcadfa here when the r pointer is at the second 'a' then the l
		// pointer should be moved directly to the 'b' position hence moving the l
		// pointer by one make it move to 'b' character which will make the current
		// string have unique characters.

		int l = 0, r = 0;
		Map<Character, Integer> map = new HashMap<>();

		int maxLength = 0;
		int n = input.length();
		while (r < n) {
			if (map.containsKey(input.charAt(r)))
				l = Math.max(map.get(input.charAt(r)) + 1, l);

			// update the value of the current character in the map.
			map.put(input.charAt(r), r);
			maxLength = Math.max(maxLength, r - l + 1);
			r++;
		}
		return maxLength;
    }
}