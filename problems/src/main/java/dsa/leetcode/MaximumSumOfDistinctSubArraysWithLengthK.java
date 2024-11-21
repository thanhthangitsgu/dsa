package dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubArraysWithLengthK {
    public static void main(String[] args) {
        MaximumSumOfDistinctSubArraysWithLengthK solution = new MaximumSumOfDistinctSubArraysWithLengthK();
        solution.solve();
    }

    public void solve() {
        int[] nums = new int[]{100,1,2,100};
        int k = 2;

        System.out.println(maximumSubarraySum(nums, k));
    }

    public String refLink() {
        return "https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k";
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] frequency = new int[maxNum + 1];

        long sum = 0;
        long maxSum = 0;
        int startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            frequency[nums[i]]++;

            while (frequency[nums[i]] > 1 || i - startIndex + 1 > k) {
                sum -= nums[startIndex];
                frequency[nums[startIndex]]--;
                startIndex++;
            }

            if (i - startIndex + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
