package dsa.leetcode;

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        SlidingPuzzle solution= new SlidingPuzzle();
        solution.solve();
    }

    public void solve() {
      System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }

    public int slidingPuzzle(int[][] board) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        StringBuilder startBoard = new StringBuilder();
        for (int[] ints : board) {
            for (int cell : ints) {
                startBoard.append(cell);
            }
        }

        queue.add(startBoard.toString());
        map.put(startBoard.toString(), 0);
        while (!queue.isEmpty()) {
            String currentBoard = queue.remove();
            if (Objects.equals(currentBoard, "123450")) {
                return map.get(currentBoard);
            }

            List<String> nextBoards = nextBoards(currentBoard);
            for (String nextBoard : nextBoards) {
                if (!map.containsKey(nextBoard)) {
                    map.put(nextBoard, map.get(currentBoard) + 1);
                    queue.add(nextBoard);
                }
            }

        }

        return -1;
    }

    public List<String> nextBoards(String currentBoard) {
        List<String> result = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int indexEmpty = currentBoard.indexOf('0');

        for (int i = 0; i < 4; i++) {
            int colIndexEmpty = indexEmpty % 3 + dy[i];
            int rowIndexEmpty = (indexEmpty - indexEmpty % 3) / 3 + dx[i];
            int index = rowIndexEmpty * 3 + colIndexEmpty;

            if (rowIndexEmpty >= 0 && colIndexEmpty >= 0 && rowIndexEmpty <= 1 && colIndexEmpty <= 2) {
                result.add(swapCharacter(currentBoard, indexEmpty, index));
            }
        }

        return result;
    }

    public String swapCharacter(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}
