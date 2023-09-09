import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        //If the number of students are greater than the number of books
        //Not possible case, therefore return -1
        if(m>n)
        return -1;

        //Naive approach - O((sum)arr - (max)arr)*N;

        //we will define a possible range of maximum pages a student can get
        //Then we will check the possibility of these max pages such that we are able to
        //assign the pages to exactly m students

        //Min possible max pages can be the max paged book of the array
        //Max possible pages a student can hold is all the books of the array

        int low = Collections.max(arr);
        int high = 0;
        for(Integer i : arr)
        {
            high+=i;
        }

        // while(low <= high)
        // {
        //     if(countOfStudents(arr, low) == m)
        //     {
        //         return low;
        //     }
        //     else
        //     {
        //         low++;
        //     }
        // }

        // return -1;

        //Optimal solution: O(Log(sum - max) * n)

        //Here we use binary search to solve this problem. 
        //If we encouter a point where the number of students are less than
        //That of required(m) then we will simply discard the right half, because only from the
        //right half less students are possible, because the more the number of pages, the less
        //the number of students they could be allocated to

        while(low <= high)
        {
            int mid = (low+high)/2;

            if(countOfStudents(arr, mid) > m)
            {
                low = mid+1;
            }
            else
            high = mid-1;
        }

        return low;
    }

    private static int countOfStudents(ArrayList<Integer> arr, int pages)
    {   int currentPages = 0;
        int students = 1;

        for(int i = 0; i< arr.size(); i++)
        {
            if(currentPages+arr.get(i) <= pages)
            {
                currentPages+=arr.get(i);
            }
            else
            {
                students++;
                currentPages= arr.get(i);
            }
        }
    return students;
    }
}