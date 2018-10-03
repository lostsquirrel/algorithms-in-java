package demo.algorithms.test.elemntary;

import demo.algorithms.elementary.Selection;
import org.junit.Assert;
import org.junit.Test;

import static demo.algorithms.utils.SortUtils.isSorted;

public class SelectionTest {
    private static final String[] c1 = "SORTEXAMPLE".split("");

    @Test
    public void testCorrection() {
        Selection.sort(c1);
        Assert.assertTrue(isSorted(c1));
    }
}
