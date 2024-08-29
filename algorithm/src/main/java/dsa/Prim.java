package dsa;

import dsa.graph.Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prim {
    public void implementAlgorithm(Graph graph) {
        Set<Integer> closeSet = new HashSet<>();
        int size = graph.getSize();
        int[] d = new int[size];
        int[] parent = new int[size];
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        closeSet.add(0);
        d[0] = 0;
        while (closeSet.size() < size) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0; i < size; i++) {
                if (!closeSet.contains(i) && d[i] < min) {
                    min = d[i];
                    minIndex = i;
                }
            }
            closeSet.add(minIndex);

            for (int i = 0; i < size; i++) {
                if (!closeSet.contains(i) && graph.getAdjMatrix()[minIndex][i] > 0 && graph.getAdjMatrix()[minIndex][i] < d[i]) {
                    d[i] = graph.getAdjMatrix()[minIndex][i];
                    parent[i] = minIndex;
                }
            }
        }

        int total = 0;
        for (int i = 0; i < size; i++) {
            total += d[i];
            System.out.println(i + " " + parent[i]);
        }

        System.out.println(total);
    }
}
