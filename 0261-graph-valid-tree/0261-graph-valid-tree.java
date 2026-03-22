class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<String>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(String.valueOf(edge[1]));
            neighbors.get(edge[1]).add(String.valueOf(edge[0]));
        }

        Stack<String> stack = new Stack<>();
        stack.push("0");
        Set<String> seen = new HashSet<>();
        seen.add("0");

        while (!stack.isEmpty()) {
            String node = stack.pop();
            for (String neighbor : neighbors.get(Integer.valueOf(node))) {
                if (seen.contains(neighbor)) {
                    return false;
                }
                neighbors.get(Integer.valueOf(neighbor)).remove(node); 
                stack.push(neighbor);
                seen.add(neighbor);
                // this way we are conerting undirected graph to directed. This allows us to 
                // not count 1->2->1 incorrectly as a cycle 
            }
        }

        return seen.size() == n;
        
    }
}