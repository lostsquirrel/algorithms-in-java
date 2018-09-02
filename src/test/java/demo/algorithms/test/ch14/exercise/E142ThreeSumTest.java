package demo.algorithms.test.ch14.exercise;

import demo.algorithms.ch14.demo.analysis.ThreeSum;
import demo.algorithms.ch14.exercise.E142ThreeSum;
import edu.princeton.cs.algs4.In;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;

public class E142ThreeSumTest {
    private static final Logger logger = LoggerFactory.getLogger(E142ThreeSumTest.class);

    int[] a = new int[]{Integer.MAX_VALUE, 2, Integer.MAX_VALUE};
    @Test
    public void testThreeSum() {
        System.out.println(Integer.MAX_VALUE + 2 + Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 2 + Integer.MIN_VALUE);
        logger.info("sum {}",IntStream.of(a).sum());
        Assert.assertEquals(1, ThreeSum.count(a)); // overflow
        Assert.assertEquals(0, E142ThreeSum.count(a));
    }
}
