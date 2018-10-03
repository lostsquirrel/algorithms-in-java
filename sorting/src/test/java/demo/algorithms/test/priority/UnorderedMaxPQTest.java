package demo.algorithms.test.priority;

import demo.algorithms.priority.MaxPQ;
import demo.algorithms.priority.UnorderedMaxPQ;
import org.junit.Assert;
import org.junit.Test;

public class UnorderedMaxPQTest {

    @Test
    public void testSimple() {
        int n = 10;
        UnorderedMaxPQ<String> q = new UnorderedMaxPQ<>(n);
        simpleMaxPQTestCase(q);
    }

    public static void simpleMaxPQTestCase(MaxPQ<String> q) {
        q.insert("P");
        q.insert("Q");
        q.insert("E");
        Assert.assertEquals("Q", q.delMax());
        q.insert("X");
        q.insert("A");
        q.insert("M");
        Assert.assertEquals("X", q.delMax());
        q.insert("P");
        q.insert("L");
        q.insert("E");
        Assert.assertEquals("P", q.delMax());
    }

    @Test
    public void testX() {

    }
}
