package dsa.comparator;

import dsa.graph.Edge;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        }
        return 0;
    }
}
