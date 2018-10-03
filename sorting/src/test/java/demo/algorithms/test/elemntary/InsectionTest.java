package demo.algorithms.test.elemntary;

import demo.algorithms.elementary.Insertion;
import demo.algorithms.utils.SortUtils;
import org.junit.Assert;
import org.junit.Test;

public class InsectionTest {
    private static final String[] c1 = "SORTEXAMPLE".split("");

    @Test
    public void testCorrection() {
        Insertion.sort(c1);
        SortUtils.show(c1);
        Assert.assertTrue(SortUtils.isSorted(c1));
    }
}
