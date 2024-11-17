package dsa;

import dsa.graph.Graph;

import java.util.*;

public class Dijkstra {
    public void implementAlgorithm(Graph graph) {
        int size = graph.getSize();
        int[][] adjMatrix = graph.getAdjMatrix();

        int[] cost = new int[size];
        int[] parent = new int[size];
        Arrays.fill(parent, -1);
        Arrays.fill(cost, Integer.MAX_VALUE);
        Set<Integer> closeSet = new HashSet<>();

        int start = inputStart();
        int current = start;
        closeSet.add(current);
        cost[current] = 0;

        while (closeSet.size() < size) {
            int minCost = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int i = 0; i < size; i++) {
                if (closeSet.contains(i) || adjMatrix[current][i] == 0) {
                    continue;
                }

                if (cost[i] > cost[current] + adjMatrix[current][i]) {
                    cost[i] = cost[current] + adjMatrix[current][i];
                    parent[i] = current;
                }

                if (cost[i] < minCost) {
                    minCost = cost[i];
                    minVertex = i;
                }
            }

            current = minVertex;
            closeSet.add(current);
        }

        for (int i = 0; i < cost.length; i++) {
//            System.out.print(STR."\{start} -> \{i} : cost = \{cost[i]}");
            traceParent(i, parent);
        }
    }

    private int inputStart() {
        System.out.print("Nhap dinh bat dau: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void traceParent(int end, int[] parent) {
        System.out.println();
        System.out.print("Path: ");

        int temp = end;
        List<Integer> rs = new ArrayList<>();
        while (temp != -1) {
            rs.add(temp);
            temp = parent[temp];
        }

        for (int vertex: rs.reversed()) {
//            System.out.print(STR."\{vertex} ");
        }

        System.out.println();
        System.out.println();
    }
}
