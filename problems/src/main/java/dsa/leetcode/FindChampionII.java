package dsa.leetcode;

public class FindChampionII {
    public static void main(String[] args) {
        FindChampionII solution = new FindChampionII();
        System.out.println(solution.findChampion(3, new int[][]{{0,1}, {1,2}} ));
    }

    public int findChampion(int n, int[][] edges) {
        int[] array = new int[n+1];
        for (int[] edge: edges) {
            array[edge[1]]++;
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] > 0) {
                continue;
            }

            if (result == -1) {
                result = i;
            } else {
                return -1;
            }
        }

        return result;
    }
}
