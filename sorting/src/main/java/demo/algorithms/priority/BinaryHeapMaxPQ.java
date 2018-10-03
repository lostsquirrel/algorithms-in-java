package demo.algorithms.priority;

import static demo.algorithms.utils.SortUtils.exch;
import static demo.algorithms.utils.SortUtils.less;

public class BinaryHeapMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    private Key[] pq;
    private int n;

    public BinaryHeapMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
        this.n = 0;
    }

    @Override
    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less(pq[k / 2], pq[k])) {
            exch(pq, k / 2, k);
            k = k / 2;
        }
    }

    @Override
    public Key max() {
        return pq[1];
    }

    @Override
    public Key delMax() {
        Key max = pq[1];
        exch(pq, 1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j], pq[j + 1])) {
                j++;
            }
            if (!less(pq[k], pq[j])) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
