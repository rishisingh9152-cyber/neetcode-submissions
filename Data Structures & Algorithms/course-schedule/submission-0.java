
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        // Populate the graph: pair[1] is the prerequisite for pair[0]
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++; // course has one more incoming dependency
        }
        
        // 2. Add all courses with 0 in-degree (no prerequisites) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process courses level by level
        int completedCourses = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;
            
            // Reduce in-degree for all neighboring courses dependent on this one
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                // If in-degree drops to 0, it can now be taken
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 4. If we successfully processed all courses, there are no cycles
        return completedCourses == numCourses;
    }
}