package dsa.supporter;

import dsa.graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    public Graph readGraphFromFile(String fileName) {
        Graph graph = new Graph();
        try {
            Scanner sc = new Scanner(new File(fileName));
            int size = sc.nextInt();
            int[][] adjMatrix = new int[size * size][size * size];
            graph.setSize(size);

            int count = 0;
            while (sc.hasNextInt()) {
                adjMatrix[count / size][count % size] = sc.nextInt();
                count++;
            }

            graph.setAdjMatrix(adjMatrix);

        } catch (IOException e) {
            System.out.println(STR."Error when read file: \{e.getMessage()}");
        }

        return graph;
    }
}
