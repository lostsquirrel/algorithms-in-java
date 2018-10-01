package demo.algorithms.test.ch21;

import demo.algorithms.elementary.Example;
import demo.algorithms.elementary.Insertion;
import org.junit.Assert;
import org.junit.Test;

public class InsectionTest {
    private static final String[] c1 = "SORTEXAMPLE".split("");

    @Test
    public void testCorrection() {
        Insertion.sort(c1);
        Example.show(c1);
        Assert.assertTrue(Example.isSorted(c1));
    }
}
