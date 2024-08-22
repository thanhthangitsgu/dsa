package dsa;


import dsa.graph.Graph;
import dsa.supporter.FileReader;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Graph graph = fileReader.readGraphFromFile("D:/Project/dsa/domain/src/main/java/dsa/asset/graph-9.txt");

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.implementAlgorithm(graph);
    }
}