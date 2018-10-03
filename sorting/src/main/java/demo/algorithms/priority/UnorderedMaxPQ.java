package demo.algorithms.priority;

import static demo.algorithms.utils.SortUtils.exch;
import static demo.algorithms.utils.SortUtils.less;

public class UnorderedMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    private Key[] pq;

    private int n = 0;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    @Override
    public void insert(Key v) {
        pq[n++] = v;
    }

    @Override
    public Key max() {
        return pq[getMax()];
    }

    @Override
    public Key delMax() {
        int max = getMax();
        exch(pq, n - 1, max);
        return pq[--n];
    }

    private int getMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (less(pq[max], pq[i])) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }
}
