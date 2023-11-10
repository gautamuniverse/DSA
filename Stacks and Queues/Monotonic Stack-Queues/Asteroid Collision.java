/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where 'N' is the number of elements in the given array/list
*/
import java.util.ArrayList;
import java.util.List;
import java.util.List;
public class Solution {
    public static List< Integer > collidingAsteroids(int[] asteroids) {
        int n = asteroids.length;

        // Using an ArrayList as a stack since we can pop the last element of an ArrayList in O(1) and the add() operation also takes O(1) time.
        List<Integer> remainingAsteroids = new ArrayList<>();

        // Iterate through the given array.
        for (int i = 0; i < n; i++) {
            // Push the current asteroid in the stack.
            if (asteroids[i] > 0 || remainingAsteroids.size() == 0 || remainingAsteroids.get(remainingAsteroids.size() - 1) < 0) {
                remainingAsteroids.add(asteroids[i]);
            } else {
                // Pop the asteroids from the stack.
                while (remainingAsteroids.size() > 0 && remainingAsteroids.get(remainingAsteroids.size() - 1) > 0
                        && remainingAsteroids.get(remainingAsteroids.size() - 1) < -asteroids[i]) {
                    remainingAsteroids.remove(remainingAsteroids.size() - 1);
                }

                // If the size of both asteroids is the same, then destroy both asteroids.
                if (remainingAsteroids.size() > 0 && remainingAsteroids.get(remainingAsteroids.size() - 1) == -asteroids[i]) {
                    remainingAsteroids.remove(remainingAsteroids.size() - 1);
                }

                // If the current asteroid has not been destroyed, then push the current asteroid to the stack.
                else if (remainingAsteroids.size() == 0 || remainingAsteroids.get(remainingAsteroids.size() - 1) <= 0) {
                    remainingAsteroids.add(asteroids[i]);
                }
            }
        }

        // Return the final state of the asteroids as an array.
        return remainingAsteroids;
    }
}