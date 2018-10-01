package demo.algorithms.merge;

public class Merge {

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
//        System.out.println(Arrays.toString(aux));
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
//                System.out.println(String.format("%s,%s", k, j));
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else {

                if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
//        System.out.println(String.format("%s,%s", lo, hi));
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (!less(a[mid + 1], a[mid])) {
            return;
        }
        merge(a, aux, lo, mid, hi);

    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
