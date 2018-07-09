package demo.algorithms.w01;

public class QuickUnionUF implements UF {

    private int[] data;

    public QuickUnionUF(int n) {
        data = init(n);
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

            data[rq] = rp;
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
