import java.util.Arrays;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.

        // Idea: We are gonna sort both the at and dt in ascending order
        // Then we are going to traverse the at array and we will maintain a platforms
        // count and the maximum number of platforms that are required so far.
        // Whenever the arrival time for a train is less than or equal to the departure
        // time of a second train then we will increase the count of platforms.,
        // Whenver the arrival time is greater than the departure tinme of the other
        // train then we will decrement the count of platforms because now a train will
        // be departing before the arrival of a new train.

        Arrays.sort(at);
        Arrays.sort(dt);
        int i = 1;
        int j = 0;
        int platforms = 1;
        int maxPlatforms = 1;
        while (i < n) {
            if (at[i] <= dt[j]) {
                platforms++;
                i++;
            }

            else if (at[i] > dt[j]) {
                platforms--;
                j++;
            }

            if (platforms > maxPlatforms) {
                maxPlatforms = platforms;
            }
        }

        return maxPlatforms;
    }
}