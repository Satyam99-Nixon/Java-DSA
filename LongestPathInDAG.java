class Solution {
    
    public int[] maxDistance(int V, int src,
                             java.util.ArrayList<java.util.ArrayList<Integer>> edges) {
        
        // Adjacency List
        java.util.ArrayList<int[]>[] adj = new java.util.ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            adj[i] = new java.util.ArrayList<>();
        }
        
        int[] indegree = new int[V];
        
        // Build graph
        for (java.util.ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            
            adj[u].add(new int[]{v, w});
            indegree[v]++;
        }
        
        // Topological Sort
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] topo = new int[V];
        int idx = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                
                indegree[v]--;
                
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        // Initialize distances
        int[] dist = new int[V];
        
        java.util.Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;
        
        // Find longest path
        for (int i = 0; i < V; i++) {
            
            int u = topo[i];
            
            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];
                
                dist[v] = Math.max(dist[v], dist[u] + w);
            }
        }
        
        return dist;
    }
}
