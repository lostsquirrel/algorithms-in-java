package demo.algorithms.ch21;

public class Insertion extends Example {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean flag = false;
            Comparable x = a[i];
            for (int j = 0; j <= i; j++) {
                if (less(a[i], a[j])) {
                    flag = true;
                }
                if (flag) {
                    Comparable tmp = a[j];
                    a[j] = x;
                    x = tmp;
                }
            }
        }
    }
}
