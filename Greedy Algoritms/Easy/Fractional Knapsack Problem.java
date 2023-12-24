import java.util.*;
import java.io.*;

/****************************************************************
 * 
 * Following is the class structure of the Pair class:
 * 
 * class Pair
 * {
 * int weight;
 * int value;
 * Pair(int weight, int value)
 * {
 * this.weight = weight;
 * this.value = value;
 * }
 * 
 * }
 * 
 *****************************************************************/

public class Solution {
	public static double maximumValue(Pair[] items, int n, int w) {
		// Write your code here.
		// ITEMS contains {weight, value} pairs.

		// More Optimal way is to use the comparator on the array itself.
		// Sorting the items based on the value/weight ratios to follow a greedy
		// approach
		Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

		double totalValue = 0.0;

		for (int i = 0; i < items.length; i++) {
			Pair currentPair = items[i];
			if ((w - currentPair.weight) >= 0) {
				totalValue += currentPair.value;
				w -= currentPair.weight;
			} else {
				double partialWeight = (double) w / currentPair.weight;
				double partialValue = (double) partialWeight * currentPair.value;
				totalValue += partialValue;
				break;
			}
		}
		return totalValue;
	}
}
