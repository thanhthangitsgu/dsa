package dsa.leetcode;
import java.util.Deque;
import java.util.LinkedList;

public class MinimumObstacleRemovalToReachCorner {
    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner solution = new MinimumObstacleRemovalToReachCorner();
        solution.solve();
    }

    public void solve() {
        System.out.println(minimumObstacles(new int[][]{{0,0,1,1,1,1,0,0,0,1},{0,1,1,1,1,1,1,0,1,1},{1,1,0,1,1,1,1,0,1,0},{0,0,1,1,1,1,0,0,1,1},{1,0,1,0,0,0,1,1,1,0}}));

    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Point startPoint = new Point(0, 0);
        Deque<Point> queue = new LinkedList<>();
        queue.offer(startPoint);

        int[][] distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }

                if (distance[x][y] > distance[point.x][point.y] + grid[x][y]) {
                    distance[x][y] = distance[point.x][point.y] + grid[x][y];
                    if (grid[x][y] == 1) {
                        queue.offerLast(new Point(x, y));
                    } else {
                        queue.offerFirst(new Point(x, y));
                    }
                }
            }
        }

        return distance[m-1][n-1];
    }
}

class Point  {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}