/*
Observation : If each node is initially not connected to any other node, when we add and edge 2 things can happen :
1. Size of the graph increases, which means we added an edge which added a node to the graph which was not connected earlier
2. size of the graph does not increase, which means we added an edge whihc simply linked existing nodes (no new node added to the graph).

Code plan :
1. maintain a parent array which will keep the parent links for each node, initialize with itself in the beginning.
2. create a method called connected(int p, int q), which will give us true if already connected (same root parent), else false. 
3. For each edge in edges, call connected(edge[0], edge[1]) 
 -> if true, int[] redundantEdge = edge, else call union(int p, int q) on the edges to form the tree;
4. Here the question clearly states that there is a redundant edge, if there was none, then I would have returned null when  redundantEdge was never populated. 
*/
class Solution {
    int[] parent;
    int[] size;
    int[] redundantEdge = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        //initialize parent array
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];

        for (int i=1; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                redundantEdge = edge;
            } 
        }
        return redundantEdge;
    }

    private int root(int p) {
        while (parent[p]!=p) {
            p = parent[p];
        }
        return p;
    }

    private boolean union(int p, int q) {
        if (p == q) return false; //means they are already connected
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq)  return false; 

        if (size[rootp] > size[rootq]) {
            size[rootp] += size[rootq];
            size[rootq] = 0; //to ensure only roots have sizes populated for clarity
            parent[rootq] = rootp;
        } else {
            size[rootq] += size[rootp];
            size[rootp] = 0; //to ensure only roots have sizes populated for clarity
            parent[rootp] = rootq;
        }
        return true;
    }
}