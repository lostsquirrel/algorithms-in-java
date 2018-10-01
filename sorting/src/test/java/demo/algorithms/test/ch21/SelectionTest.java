package demo.algorithms.test.ch21;

import demo.algorithms.elementary.Selection;
import org.junit.Assert;
import org.junit.Test;

public class SelectionTest {
    private static final String[] c1 = "SORTEXAMPLE".split("");

    @Test
    public void testCorrection() {
        Selection.sort(c1);
        Assert.assertTrue(Selection.isSorted(c1));
    }
}
