package demo.algorithms.w01;

public class QuickFindUF implements UF {

    private int[] data;

    public QuickFindUF(int n) {
        data = init(n);
    }

    @Override
    public void union(int p, int q) {
        int pv = data[p];
        int qv = data[q];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == pv) {
                data[i] = qv;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return data[p] == data[q];
    }

    @Override
    public int find(int p) {
        return 0;
    }
}
