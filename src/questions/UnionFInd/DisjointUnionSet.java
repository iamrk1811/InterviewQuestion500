package questions.UnionFInd;

public class DisjointUnionSet {
    int[] parent;
    int[] rank;
    int size;
    public DisjointUnionSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.size = n;
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (this.parent[i] == i) return i;
        return this.parent[i] = find(parent[i]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        int aRank = this.rank[a];
        int bRank = this.rank[b];

        if (aRank > bRank) {
            this.parent[b] = a;
        } else if (bRank > aRank) {
            this.parent[a] = b;
        } else {
            this.parent[b] = a;
            this.rank[a]++;
        }
    }
}
