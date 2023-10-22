import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        rec(0, "", 0, 0, num, target);
        return ans;
    }

    private void rec(int i, String s, long sum, long prev, String nums, int target) {
        // Base case
        if (i == nums.length()) {
            if (sum == target) {
                ans.add(s);
                return;
            }
        }

        // Recursion
        for (int j = i; j < nums.length(); j++) {
            // Handle leading zeros
            if (j > i && nums.charAt(i) == '0') {
                return;
            }

            long number = Long.parseLong(nums.substring(i, j + 1));
            if (i == 0) {
                rec(j + 1, s + nums.substring(i, j + 1), number, number, nums, target);
            } else {
                rec(j + 1, s + "+" + nums.substring(i, j + 1), sum + number, number, nums, target);
                rec(j + 1, s + "-" + nums.substring(i, j + 1), sum - number, -number, nums, target);
                rec(j + 1, s + "*" + nums.substring(i, j + 1), sum - prev + (prev * number), prev * number, nums, target);
            }
        }
    }
}
s