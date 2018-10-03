package demo.algorithms.test.heap;

import demo.algorithms.heap.Heap;
import demo.algorithms.utils.SortUtils;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapTest {

    @Test
    public void testSimple() {
        String[] caze = " S O R T E X A M P L E".split(" ");
        StdOut.println(Arrays.toString(caze));
        Heap.sort(caze);
        Assert.assertTrue(SortUtils.isSorted(caze));
        StdOut.println(Arrays.toString(caze));
    }
}
