package dsa.leetcode;
import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesI solution = new ShortestDistanceAfterRoadAdditionQueriesI();
        solution.solve();
    }

    public void solve() {
        int[] result = shortestDistanceAfterQueries(14, new int[][]{{1,7}, {6,9}, {6,13}});
        for (int j : result) {
            System.out.println(j);
        }
    }

    private int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < n; i++) {
            List<Integer> init = new ArrayList<>();
            init.add(i+1);
            adjList.add(init);
        }

        for (int i = 0; i < queries.length; i++) {
            adjList.get(queries[i][0]).add(queries[i][1]);
            result[i] = findShortestDistance(n, adjList);
        }

        return result;
    }

    private int findShortestDistance(int n, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        queue.add(0);
        distances[0] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();

            if (currentVertex == n - 1) {
                return distances[n-1];
            }

            for (int adj : adjList.get(currentVertex)) {
                if (distances[adj] > distances[currentVertex] + 1) {
                    queue.add(adj);
                    distances[adj] = distances[currentVertex] + 1;
                }
            }
        }

        return -1;
    }

    private String refLink() {
        return "https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i";
    }
}
