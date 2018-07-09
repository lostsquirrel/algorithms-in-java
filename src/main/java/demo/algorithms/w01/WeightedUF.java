package demo.algorithms.w01;

public class WeightedUF implements UF {
    private int[] data;
    private int[] sz;

    public WeightedUF(int n) {
        data = init(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (data[i] != i) {
            i = data[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (rp != rq) {
            if (sz[rp] > sz[rq]) {
                data[rq] = rp;
                sz[rp] += sz[rq];
            } else {
                data[rp] = rq;
                sz[rq] += sz[rp];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return 0;
    }
}
