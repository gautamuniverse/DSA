import java.util.ArrayList;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
       return binarySearchModified(arr, arr.size());
    }

    private static int binarySearchModified(ArrayList<Integer> arr, int n)
    {   
       //If the array size is 1
       if(n == 1)
       return arr.get(0);

       //Separately check for edge cases
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);


        //trim the search space as we have already processed the edge cases
        int low = 1;
        int high = n-2;

        //Perform binary search
        while(low <= high)
        {
            int mid= (low+ high)/2;

            //check if the current element is the unique element
            if(!arr.get(mid).equals(arr.get(mid-1)) && !arr.get(mid).equals(arr.get(mid+1)))
            return arr.get(mid);

            //check if the left half is in the (even, odd) index position sorted
            //that is check if equal numbers are placed in even, odd indexes respectively

            if((mid%2 != 0 && arr.get(mid).equals(arr.get(mid-1)) )|| (mid%2 == 0 && arr.get(mid).equals(arr.get(mid+1))))
            {
                //this condition is true that means the unique element can never be in the this half
                //search in the right half
                low = mid+1;
            }
            //else if the order is, odd, even then the element can never be in the right half
            //therefore search in the left half
            else
            high = mid-1;
        }

        return -1;
    }
}