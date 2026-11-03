
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        // Start DFS from node 0 with no parent (-1)
        if (!dfs(0, -1, adj, visited)) {
            return false; // Cycle detected
        }
        
        // Check if all nodes were visited (ensures the graph is fully connected)
        for (boolean v : visited) {
            if (!v) {
                return false; // Disconnected component found
            }
        }
        
        return true;
    }
    
    private boolean dfs(int curr, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        
        for (int neighbor : adj.get(curr)) {
            // If the neighbor is the parent we just came from, ignore it
            if (neighbor == parent) {
                continue;
            }
            // If the neighbor is already visited and NOT the parent, we found a cycle
            if (visited[neighbor]) {
                return false;
            }
            // Recursively visit the unvisited neighbor
            if (!dfs(neighbor, curr, adj, visited)) {
                return false;
            }
        }
        
        return true;
    }
}