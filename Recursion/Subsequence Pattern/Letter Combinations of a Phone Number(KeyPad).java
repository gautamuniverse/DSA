class Solution {
     private String[] mapping = {
        "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        letterCombinationsHelper(digits, 0, "", result);
        return result;
    }

    private void letterCombinationsHelper(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits, index + 1, current + letters.charAt(i), result);
        }
    }

}