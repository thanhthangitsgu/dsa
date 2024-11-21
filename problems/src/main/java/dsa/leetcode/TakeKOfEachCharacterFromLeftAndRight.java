package dsa.leetcode;

public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        TakeKOfEachCharacterFromLeftAndRight solution = new TakeKOfEachCharacterFromLeftAndRight();
        solution.solve();
    }

    public String refLink() {
        return "https://leetcode.com/problems/take-k-of-each-character-from-left-and-right";
    }

    public void solve() {
        System.out.println(takeCharacters("aabaaaacaabc",2));
    }

    public int takeCharacters(String s, int k) {
        int[] maxFred = new int[100];
        for (int i = 0; i < s.length(); i++) {
            maxFred[s.charAt(i)]++;
        }

        for (int i = 'a'; i <= 'c'; i++) {
            if (maxFred[i] < k) {
                return -1;
            }
            maxFred[i] = maxFred [i] - k;
        }

        int maxLength = 0;
        int startIndex = 0;
        int[] fred = new int[100];

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            fred[s.charAt(endIndex)]++;

            if (fred['a'] > maxFred['a'] || fred['b'] > maxFred['b'] || fred['c'] > maxFred['c']) {
                fred[s.charAt(startIndex)]--;
                startIndex++;
            }

            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
        }
        return s.length() - maxLength;
    }
}
