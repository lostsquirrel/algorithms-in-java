package demo.algorithms.test;

import org.junit.Test;

public class NumberTest {
    @Test
    public void testIntegerOverflow() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println((long)Integer.MAX_VALUE + 1);
        System.out.println((long)Integer.MIN_VALUE - 1 + Integer.MAX_VALUE);
    }
}
