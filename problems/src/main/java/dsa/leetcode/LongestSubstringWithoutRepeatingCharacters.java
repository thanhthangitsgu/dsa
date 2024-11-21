package dsa.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        solution.solve();
    }

    public void solve() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int startIndex = 0;
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            maxIndex = Math.max(s.charAt(i), maxIndex);
        }
        int[] fr = new int[maxIndex + 1];

        for (int i = 0; i < s.length(); i++) {
            fr[s.charAt(i)]++;

            while (fr[s.charAt(i)] > 1) {
                fr[s.charAt(startIndex)]--;
                startIndex++;
            }

            maxLength = Math.max(maxLength, i - startIndex + 1);
        }

        return maxLength;
    }
}
