package dsa.leetcode;

public class DefuseTheBomb {
    public static void main(String[] args) {
        DefuseTheBomb solution = new DefuseTheBomb();
        solution.solve();
    }

    public void solve() {
        int[] result = decrypt(new int[]{10,5,7,7,3,2,10,3,6,9,1,6}, -4);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        int startIndex = k >= 0 ? 1 : indexByModulo(length, k);
        int endIndex = indexByModulo(length, startIndex + Math.abs(k) - 1);

        for (int i = startIndex; i <= endIndex; i++) {
            result[0] += code[indexByModulo(length, i)];
        }

        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] - code[indexByModulo(length, startIndex++)] + code[indexByModulo(length, ++endIndex)];
        }

        return result;
    }

    public int indexByModulo(int n, int k) {
        return k >= 0 ? k % n : (n + k % n) % n;
    }


}
