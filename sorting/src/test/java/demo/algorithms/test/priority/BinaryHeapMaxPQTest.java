package demo.algorithms.test.priority;

import demo.algorithms.priority.BinaryHeapMaxPQ;
import org.junit.Test;

import static demo.algorithms.test.priority.UnorderedMaxPQTest.simpleMaxPQTestCase;

public class BinaryHeapMaxPQTest {
    @Test
    public void testSimple() {
        int n = 10;
        BinaryHeapMaxPQ<String> q = new BinaryHeapMaxPQ<>(n);
        simpleMaxPQTestCase(q);
    }
}
