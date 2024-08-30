package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int size;

    private int[][] adjMatrix;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Graph(int size, int[][] adjMatrix) {
        this.size = size;
        this.adjMatrix = adjMatrix;
    }

    public Graph() {

    }

    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (adjMatrix[i][j] > 0) {
                    edges.add(new Edge(i, j , adjMatrix[i][j]));
                }
            }
        }

        return edges;
    }

    public void printGraph() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(STR."\{adjMatrix[i][j]} ");
            }

            System.out.println();
        }
    }
}
