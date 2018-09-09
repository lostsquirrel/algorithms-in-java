package demo.algorithms.ch21;

public class Selection extends Example {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            Comparable smallest = a[i];
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], smallest)) {
                    smallest = a[j];
                    k = j;
                }
            }
            exch(a, i, k);
        }
    } 
}
