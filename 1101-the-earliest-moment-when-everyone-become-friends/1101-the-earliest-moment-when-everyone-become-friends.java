    /*
    It is not mentioned that the timestamps are unique, we will have to arrange the array based on increasing time. 
    1. define the parent array of size n where we will store the parent info for the member node. Here, node represents the person, and parent represent the immidiate link. 
    2. We will maintain a leader for each group (in tree structure think of it as root). We will maintain a size array where on every union, we will update the root's size (by adding up the size of individual groups)
    3. define a function union(int p, int q) where p and q are nodes, when called - this function will merge the 2 groups that p and q belong to.
    -> if p and q are same, do nothing
    -> If the root of both entries is same, do nothing, else proceed
    ->  We will merge the smaller group into the larger, in terms of tree implementtation that means making the smaller tree's root a child of the large tree's root. 
    4. For each entry in logs array [ts, p, q] -> call union and check the size of the root of the tree, if it's equal to n, we return ts. 
    5. at the end return -1;
    
    */

class Solution {

    int[] parent, size;

    public int earliestAcq(int[][] logs, int n) {
        //intitialize parent of every node as itself and size as 1, because we start with each node being a root:

        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(logs, Comparator.comparingInt(a-> a[0]));
        //call union on each log entry :
        for (int[] log : logs) {
            int root = union(log[1], log[2]);
            if (size[root] == n) return log[0];
        }
        return -1;
    }

    //finds the root of the tree, helps to find of two nodes are connected
    private int root(int p) {
        if (parent[p] == p) {
            return p;
        }
        while (parent[p]!=p) {
            p = parent[p];
        }
        return p;
    }

    //performs union of both nodes and updates the size array, returns the root
    private int union (int p, int q) {
        if (p == q) return p;
        
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return rootp;

        if (size[rootp] >= size[rootq]) {
            //the smaller tree is merged into the larger to ensure that the depth remians ln(n)
            size[rootp] += size[rootq];
            size[rootq] = 0;
            parent[rootq] = rootp;
            return rootp;
        } 
        size[rootq] += size[rootp];
        size[rootp] = 0;
        parent[rootp] = rootq;
        return rootq;
        
    }
} 