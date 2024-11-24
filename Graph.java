import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjList = new HashMap<>();

    static class Edge {
        String target;
        int weight;

        public Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Add Node
    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Add Edge
    public void addEdge(String src, String dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight)); // For undirected graph
    }

    // BFS Traversal
    public void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");

            for (Edge edge : adjList.get(node)) {
                if (!visited.contains(edge.target)) {
                    queue.add(edge.target);
                    visited.add(edge.target);
                }
            }
        }
    }

    // Dijkstra's Algorithm
    public void dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        adjList.keySet().forEach(node -> distances.put(node, Integer.MAX_VALUE));
        distances.put(start, 0);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            for (Edge edge : adjList.get(current.target)) {
                int newDist = distances.get(current.target) + edge.weight;
                if (newDist < distances.get(edge.target)) {
                    distances.put(edge.target, newDist);
                    pq.add(new Edge(edge.target, newDist));
                }
            }
        }

        distances.forEach((node, dist) -> System.out.println(node + " -> " + dist));
    }
}
