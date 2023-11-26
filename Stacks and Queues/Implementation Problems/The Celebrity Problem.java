import java.util.*;
import java.io.*;
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

public class Solution {
	public static int findCelebrity(int n) {
		// Write your code here.
		// Naive - O(N^2)
		// int celeb = -1;

		// for (int i = 0; i < n; i++) {
		// int currentCeleb = -1;
		// for (int j = 0; j < n; j++) {
		// if (i != j) {
		// if (Runner.knows(j, i) && !Runner.knows(i, j))
		// currentCeleb = i;
		// else {
		// currentCeleb = -1;
		// break;
		// }

		// }

		// }
		// if (currentCeleb != -1) {
		// celeb = currentCeleb;
		// break;
		// }
		// }
		// return celeb;

		// Optimal - O(N)
		/*
		 * Approach: We are going to use a stack, where we will be pushing all the
		 * then we will pop two elements at once, and then we will check if the two
		 * popped elements we will check if the first one knows second, meaning first
		 * one
		 * cant be the celebrity, hence push it back, else we will check the same thing
		 * for the second element, against first element and push it back to the stack
		 * if it knows the fist element. Now after this we will be end up with one
		 * element
		 * in the stack which is our potential celebrity, so now we will check it
		 * against
		 * the other elements, two conditions, if there exists any element that doesn't
		 * knows
		 * the potential celebrity, or there exists an element which the celebrity
		 * knows, then
		 * is is not the celebrity, if the above two conditions are not fulfilled
		 * meaning
		 * the potential celebrity is indeed the celebrity hence return it
		 */

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() >= 2) {
			// pop first two elements out of the stack
			int A = st.pop();
			int B = st.pop();

			if (Runner.knows(A, B)) {
				// if A knows B, then A is not a celebrity. push B back to the stack as it is
				// potential celebrity
				st.push(B);
			} else {
				// If B knows A, B is not a celebrity, Push A back
				st.push(A);
			}
		}

		int potential = st.pop();

		// Check the potential element against other elements
		for (int i = 0; i < n; i++) {
			if (i != potential) {
				if (Runner.knows(potential, i) || !Runner.knows(i, potential))
					return -1;
			}
		}

		return potential;

	}
}