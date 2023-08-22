class Solution {
    //Majority Element -  Moore's Voting Algorithm
    //intuition -  if a number is a majority element, it will not get cancelled by the other elements
    //We find the majority element by looping through the array and considering the 1st element to the majority
    //element, if the i'th element is not the majority element we decrease the count, if the count at any point becomes 0
    //we change the majority element to i+1th element and continue the iteration, at the end we will have our majority element
    //We must verify if the majority element that we got is really the majority element and appears more than n/2 times,
    //to do this we need to again iterate the array and count the number of times the majority element appears, if it appears
    // more than n/2 times it is the majority element.
    public int majorityElement(int[] nums) {
        //Initially set  the count to 0
        int count = 0;
        //Initially we didn't consider any candidate
        int candidate = 0;
        
        for (int num : nums) {
            //At any point if count becomes 0, means till this array we didn't find any majority element
            if (count == 0) {
                candidate = num;
            }
            //If the current array element is the candidate then increase the counter
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        //This is the majority element, since the question mentioned that there will always be a majority element
        //Therefore we didn't have to check explicitly if the majority element appears more than n/2 times or not
        return candidate;
    }

}
