package dsa.leetcode;
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        MaximumAverageSubarrayI solution = new MaximumAverageSubarrayI();
        System.out.print(solution.findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double average = sum / k;
        double maxAverage = average;
        int start = 0;
        for (int i = k; i < nums.length; i++) {
            average = (average * k - nums[start] + nums[i]) / k;
            maxAverage = Math.max(maxAverage, average);
            start++;
        }
        return maxAverage;
    }
}
