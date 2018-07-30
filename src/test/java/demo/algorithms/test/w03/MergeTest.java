package demo.algorithms.test.w03;

import demo.algorithms.w03.Merge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeTest {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            Integer[] a = randomIntArray(10);
            printArray(a);
            Merge.sort(a);
            Assert.assertTrue(isSorted(a));
            printArray(a);

        }
    }

    private boolean isSorted(Integer[] a) {
        Integer c = null;
        Integer p = null;
        for (Integer i : a) {
            if (p != null) {
                if (c == null) {
                    c = p.compareTo(i);
                } else {
                    if (c > p.compareTo(i)) {
                        return false;
                    }
                }
            }

            p = i;
        }
        return true;
    }

    private Integer[] randomIntArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100);
        }
        return a;
    }

    private void printArray(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }
}
