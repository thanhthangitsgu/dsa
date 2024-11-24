package dsa.leetcode;
import java.util.Map;
import java.util.TreeMap;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        FlipColumnsForMaximumNumberOfEqualRows solution = new FlipColumnsForMaximumNumberOfEqualRows();
        solution.solve();
    }

    public void solve() {
        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0,1}, {1,0}}));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> mapCount = new TreeMap<>();
        int maxLength = 0;
        for (int[] row : matrix) {
            StringBuilder rowJoin = new StringBuilder();
            StringBuilder rowFlip = new StringBuilder();

            for (int cell: row) {
                rowJoin.append(cell);
                rowFlip.append(cell ^ 1);
            }

            String key = row[0] == 0 ? rowJoin.toString() : rowFlip.toString();
            int count = mapCount.getOrDefault(key, 0) + 1;
            mapCount.put(key, count);
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }

    public String refLink() {
        return "https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows";
    }
}
