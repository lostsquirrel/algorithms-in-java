package demo.algorithms.elementary;

import static demo.algorithms.utils.SortUtils.exch;
import static demo.algorithms.utils.SortUtils.less;

public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int mini = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[mini])) {
                    mini = j;
                }
            }
            exch(a, i, mini);
        }
    } 
}
