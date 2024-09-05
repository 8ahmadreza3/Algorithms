import java.util.*;

class SingleSource {
    int V;
    List<List<Pair>> adj;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    SingleSourceShortestPaths(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (Pair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new Pair(dist[v.first], v.first));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + "   " + dist[i]);
        }
    }

}
