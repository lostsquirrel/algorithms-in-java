package demo.algorithms.test.w03;

import demo.algorithms.w03.Merge;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Arrays;

public class MergeTest {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            Integer[]a = randomIntArray(10);
            printArray(a);
            Merge.sort(a);
            printArray(a);

        }
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
