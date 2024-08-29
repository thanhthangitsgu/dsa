package dsa;

public class Kruskal {
    int find(int u, int parent[]) {
        if (parent[u] == u) {
            return u;
        }

        return parent[u] = find(parent[u], parent);
    }

    boolean join(int u, int v, int parent[]) {
        u = find(u, parent);
        v = find(v, parent);

        if (u != v) {
            parent[v] = u;
            return true;
        }

        return false;
    }

    public void implementAlgorithm() {

    }
}
