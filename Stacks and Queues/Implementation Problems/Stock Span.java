//Type 1 -  Coding Ninjas
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] findStockSpans(int[] prices) {
		// Write your code here.

		Stack<Integer> st = new Stack<Integer>();
		int [] ngl = new int [prices.length];
		ngl[0] = 1;
		st.push(0);
		for(int i = 1; i<prices.length; i++)
		{
			while(!st.isEmpty() && prices[st.peek()] < prices[i])
			st.pop();

			if(!st.isEmpty())
			ngl[i] =i - st.peek(); //input the number of elements in between the ngl(also equal)

			else
			ngl[i] = i + 1; //If no ngl add the current index + 1 to represent all the numbers so far

			st.push(i);
		}

		return ngl;
	}
}


//Type 2 - Leetcode 901. Online Stock Span

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {
    private List<Integer> prices;
    private List<Integer> spans;

    public StockSpanner() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);

        int span = 1;
				// We iterate backward through the prices list, starting from the day before the current day (index prices.size() - 2).
        int index = prices.size() - 2;

			//While the current index span is less than equal to the current price we keep iterating backwards.
        while (index >= 0 && prices.get(index) <= price) {

						// If the price on the current iteration day is less than or equal to the current day's price, we add the span of that day to the current span (span += spans.get(index)).
            span += spans.get(index);

						// We also jump to the next day where we need to check (subtracting spans.get(index) from the current index).
            index -= spans.get(index);
        }

				//Add current accumulated span to the spans arraylist
        spans.add(span);
        return span;
    }
}
