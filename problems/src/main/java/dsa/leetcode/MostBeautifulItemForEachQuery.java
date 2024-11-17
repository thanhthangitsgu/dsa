package dsa.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        MostBeautifulItemForEachQuery solution = new MostBeautifulItemForEachQuery();
        solution.solve();
    }

    public static String refLink() {
        return "https://leetcode.com/problems/most-beautiful-item-for-each-query/description/";
    }

    public void solve() {
        int[][] items = new int[][]{{10,1000}};
        int[] queries =new int[]{5};
        System.out.print(maximumBeauty(items, queries).length);
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int[] beautyProcessArr = new int[items.length];
        int[] priceProcessArr = new int[items.length];
        beautyProcessArr[0] = items[0][1];
        priceProcessArr[0] = items[0][0];

        for (int i = 1; i < items.length; i++) {
            beautyProcessArr[i] = Math.max(beautyProcessArr[i - 1], items[i][1]);
            priceProcessArr[i] = items[i][0];
        }

        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(queries[i], priceProcessArr) - 1;
            if (index >= 0 && priceProcessArr[index] <= queries[i]) {
                result[i] = beautyProcessArr[index];
            }
        }
        return result;
    }

    public int binarySearch(int key, int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (key < arr[mid]) {
                right = mid;
                continue;
            }

            left = mid + 1;
        }
        return left;
    }
}
