package dsa.leetcode;

public class MaximumMatrixSum {
    public static void main(String[] args) {
        MaximumMatrixSum matrixSum = new MaximumMatrixSum();
        matrixSum.solve();
    }

    public String refLink() {
        return "https://leetcode.com/problems/maximum-matrix-sum";
    }

    public void solve() {
        System.out.println(maxMatrixSum(new int[][]{{1, -1}, {-1, 1}}));
    }

    public long maxMatrixSum(int[][] matrix) {
        long countNegative = 0;
        long sum = 0;
        int minNegative = Integer.MAX_VALUE;

        for (int[] rows : matrix) {
            for (int cell : rows) {
                sum += Math.abs(cell);
                minNegative = Math.min(minNegative, Math.abs(cell));
                if (cell < 0) {
                    countNegative++;
                }
            }
        }

        if (countNegative % 2 == 0) {
            return sum;
        }

        return sum - 2L * minNegative;
    }
}
