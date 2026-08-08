class Solution {

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (rank[pu] < rank[pv])
                parent[pu] = pv;
            else if (rank[pu] > rank[pv])
                parent[pv] = pu;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public int minEdgesReq(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int extra = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) == dsu.find(v))
                extra++;
            else
                dsu.union(u, v);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i)
                components++;
        }

        int need = components - 1;
        return (extra >= need) ? need : -1;
    }
}
