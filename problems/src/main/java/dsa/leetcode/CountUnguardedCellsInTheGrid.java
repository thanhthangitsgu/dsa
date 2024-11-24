package dsa.leetcode;

public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid solution = new CountUnguardedCellsInTheGrid();
        solution.solve();
    }

    public void solve() {
        int m = 4;
        int n = 6;
        int[][] guards = new int[][]{{0,0}, {1,1}, {2,3}};
        int[][] walls = new int[][]{{0,1}, {2,2}, {1,4}};

        System.out.println(countUnguarded(m, n, guards, walls));
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] positions: guards) {
            grid[positions[0]][positions[1]] = -1;
        }

        for (int[] positions: walls) {
            grid[positions[0]][positions[1]] = -1;
        }

        for (int[] positions: guards) {
            int x = positions[0];
            int y = positions[1];

            for (int i = x - 1; i >= 0 && grid[i][y] != -1; i--) {
                grid[i][y] = 1;
            }

            for (int i = y - 1; i >= 0 && grid[x][i] != -1; i--) {
                grid[x][i] = 1;
            }

            for (int i = x + 1; i < m && grid[i][y] != -1; i++) {
                grid[i][y] = 1;
            }

            for (int i = y + 1; i < n && grid[x][i] != -1; i++) {
                grid[x][i] = 1;
            }
        }

        int count = 0;
        for (int[] row: grid) {
            for (int cell: row) {
                if (cell == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
