package demo.algorithms.elementary;

import static demo.algorithms.utils.SortUtils.exch;
import static demo.algorithms.utils.SortUtils.less;

public class Shell {
    public static void sort(Comparable[] a) {
        int h = 1;
        int n = a.length;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
