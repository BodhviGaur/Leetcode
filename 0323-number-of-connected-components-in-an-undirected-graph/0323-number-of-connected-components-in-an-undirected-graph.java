class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> notVisited = new HashSet<Integer>();
        int count = 0;
        for(int i=0; i<n; i++) {
            notVisited.add(i);
        }

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
        for (int[] edge: edges) {
           if(!adjList.containsKey(edge[0])){
               ArrayList<Integer> list = new ArrayList<Integer>();
               list.add(edge[1]);
               adjList.put(edge[0], list);
           } else {
               ArrayList<Integer> list = adjList.get(edge[0]);
               list.add(edge[1]);
               adjList.put(edge[0], list);
           }
           //adding connections in opp direction
           if(!adjList.containsKey(edge[1])){
               ArrayList<Integer> list = new ArrayList<Integer>();
               list.add(edge[0]);
               adjList.put(edge[1], list);
           } else {
               ArrayList<Integer> list = adjList.get(edge[1]);
               list.add(edge[0]);
               adjList.put(edge[1], list);
           }
        }   

        while (notVisited.size() > 0) {
            count++;
            dfs(notVisited.iterator().next(), adjList, notVisited, visited);
        }

        return count;
    }


    public void dfs(int curr, HashMap<Integer, ArrayList<Integer>> adjList, HashSet<Integer> notVisited, HashSet<Integer> visited) {
        if(!visited.contains(curr)){
            visited.add(curr);
            if(notVisited.contains(curr)){
                notVisited.remove(curr);        
            }

            if(adjList.containsKey(curr)){
                for (int neigh: adjList.get(curr)) {
                    dfs(neigh, adjList, notVisited, visited);
                }
            } else return;
        }
        else return;
        
    }
}