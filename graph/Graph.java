import java.util.*;

public class Graph {
    private int V; // Số đỉnh
    private LinkedList<Integer>[] adj; // Danh sách kề

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int v, int w) {
        adj[v].add(w); // Thêm w vào danh sách kề của v
    }

    // BFS: Duyệt đồ thị theo chiều rộng từ đỉnh s
    public void BFS(int s) {
        // Đánh dấu tất cả các đỉnh chưa được thăm
        boolean[] visited = new boolean[V];

        // Tạo hàng đợi cho BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Đánh dấu đỉnh hiện tại là đã thăm và thêm vào hàng đợi
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Lấy đỉnh từ hàng đợi và in ra
            s = queue.poll();
            System.out.print(s + " ");

            // Duyệt tất cả các đỉnh kề của đỉnh vừa lấy
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // DFS: Duyệt đồ thị theo chiều sâu từ đỉnh v
    public void DFS(int v) {
        // Đánh dấu tất cả các đỉnh chưa được thăm
        boolean[] visited = new boolean[V];

        // Gọi hàm đệ quy để thực hiện DFS
        DFSUtil(v, visited);
    }

    // Hàm đệ quy hỗ trợ cho DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Đánh dấu đỉnh hiện tại là đã thăm và in ra
        visited[v] = true;
        System.out.print(v + " ");

        // Duyệt tất cả các đỉnh kề của đỉnh hiện tại
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Main để test
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2):");
        g.BFS(2);

        System.out.println("\nDepth First Traversal (starting from vertex 2):");
        g.DFS(2);
    }
}