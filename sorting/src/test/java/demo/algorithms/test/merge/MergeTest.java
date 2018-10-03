package demo.algorithms.test.merge;

import demo.algorithms.merge.Merge;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeTest {

    @Test
    public void test() {
        int size = 100000;
        int[] t = new int[size];
        for (int i = 0; i < size; i++) {
            Integer[] a = randomIntArray(30);
//            printArray(a);
            long x = System.nanoTime();
            Merge.sort(a);
            t[i] = (int) (System.nanoTime() - x);
//            printArray(a);
            Assert.assertTrue(isSorted(a));
        }
        System.out.println(StdStats.mean(t));
    }

    private boolean isSorted(Integer[] a) {
        Integer c = null;
        Integer p = null;
        for (Integer i : a) {
            if (p != null) {
                if (p.compareTo(i) > 0) {
                    return false;
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

    @Test
    public void testIsSorted() {
        Integer[] a = new Integer[]{0, 0, 2, 8, 10, 13, 16, 16, 20, 21, 23, 26, 31, 31, 34, 35, 44, 50, 53, 54, 57, 58, 60, 60, 63, 73, 73, 77, 83, 94};
        isSorted(a);
    }

    private void printArray(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testCompare() {
        System.out.println(new Integer(6).compareTo(5));
    }
}
