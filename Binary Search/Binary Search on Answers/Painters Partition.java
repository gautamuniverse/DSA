import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //This problem can be solved with the same approach used to solve the book allocation problem
        //This problem is exactly similar to the Split Array-Largest Sum problem

        int low = Collections.max(boards);
        int high = 0;
        for(Integer i : boards)
        {
            high+=i;
        }

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(countOfPainters(boards, mid) > k)
            {
                low = mid+1;
            }
            else
            high = mid-1;
        }

        return low;
    }

    private static int countOfPainters(ArrayList<Integer> boards, int maxArea)
    {
        int currentArea = 0;
        int painters = 1;

        for(int i = 0; i< boards.size(); i++)
        {
            if(currentArea+boards.get(i) <= maxArea)
            {
                currentArea+=boards.get(i);
            }
            else
            {
                painters++;
                currentArea= boards.get(i);
            }
        }
    return painters;
    }
}