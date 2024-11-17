package dsa.leetcode;

import java.util.Arrays;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        MinimizedMaximumOfProductsDistributedToAnyStore solution = new MinimizedMaximumOfProductsDistributedToAnyStore();
        solution.resolve();;
    }

    public String refLink() {
        return "https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/";
    }

    public void resolve() {
        int n = 6;
        int[] arr = {11, 6};
        System.out.print(this.minimizedMaximum(n, arr));
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = Arrays.stream(quantities).max().orElse(0);

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistribute(mid, quantities, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canDistribute(int k, int[] quantities, int n) {
        int total = 0;
        if (k == 0) {
            return false;
        }
        for (int number: quantities) {
            total += (double) number/k > number/k ? number/k + 1 : number/k;
            if (total > n) {
                return false;
            }
        }

        return true;
    }
}
