/**
 * Modify ThreeSum to work properly even when the int values are so large that
 adding two of them might cause overflow.
 */
package demo.algorithms.ch14.exercise;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class E142ThreeSum {
    public static int count(int[] a) { // Count triples that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                Long x = (long)-a[i] - a[j];
                if (x.compareTo((long)Integer.MAX_VALUE  + 1) < 1 && BinarySearch.indexOf(a, x.intValue()) > j)
                    cnt++;
            }

        return cnt;
    }
}
