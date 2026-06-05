package com.pranay.interview.graph;

import java.util.HashSet;
import java.util.Set;

class DSU {
    int[] root;

    public DSU(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++)
            root[i] = i;
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }

        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int provinces() {
        Set<Integer> hs = new HashSet<>();
        for (int n: root)
            hs.add(n);

        return hs.size();
    }
}

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        NumberOfProvinces np = new NumberOfProvinces();
        int provinces = np.findProvinces(A);
        System.out.println("Ans: " + provinces);
    }

    public int findProvinces(int[][] A) {
        DSU dsu = new DSU(A.length);
        int nr = A.length;
        int nc = A[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (A[r][c] == 1)
                    dsu.union(r, c);
            }
        }

        return dsu.provinces();
    }
}
