

class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Since the graph is undirected
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        
        // 2. Iterate through all nodes
        for (int i = 0; i < n; i++) {
            // If the node is not visited, it belongs to a new component
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }
        
        return components;
    }
    
    // DFS helper to explore all reachable nodes in the current component
    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}