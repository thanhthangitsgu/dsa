package dsa.leetcode;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK solution = new ShortestSubarrayWithSumAtLeastK();
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = -100000;
        }
        System.out.println(solution.shortestSubarray(arr, 1000000000));
    }

    public int shortestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peek()] >= k) {
                int startIndex = deque.removeFirst();
                minLength = Math.min(minLength, i - startIndex);
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public String refLink() {
        return "https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k";
    }
}
