package dsa;

import dsa.comparator.EdgeComparator;
import dsa.graph.Edge;
import dsa.graph.Graph;

import java.util.PriorityQueue;

public class Kruskal {
    int find(int u, int[] parent) {
        if (parent[u] == u) {
            return u;
        }

        return parent[u] = find(parent[u], parent);
    }

    boolean join(int u, int v, int[] parent) {
        u = find(u, parent);
        v = find(v, parent);

        if (u != v) {
            parent[v] = u;
            return true;
        }

        return false;
    }

    public void implementAlgorithm(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        pq.addAll(graph.getEdges());
        int[][] mts = new int[graph.getSize()][graph.getSize()];

        int[] parent = new int[graph.getSize()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int total = 0;
        for (Edge edge : pq) {
            if (join(edge.getStart(), edge.getEnd(), parent)) {
                total += edge.getWeight();
                mts[edge.getStart()][edge.getEnd()] = edge.getWeight();
            }
        }

        this.showResult(mts, total);
    }

    private void showResult(int[][] mts, int total) {
        System.out.println("Kruskal algorithm: ");

        for (int i = 0; i < mts.length; i++) {
            for (int j = i + 1; j < mts.length; j++) {
                if (mts[i][j] > 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
        System.out.println("Total weight: " + total);
    }
}
