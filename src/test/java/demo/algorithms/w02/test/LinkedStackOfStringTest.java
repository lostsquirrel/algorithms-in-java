package demo.algorithms.w02.test;

import demo.algorithms.w02.LinkedStackOfString;
import org.junit.Assert;
import org.junit.Test;

public class LinkedStackOfStringTest {

    @Test
    public void test() {
        LinkedStackOfString ls = new LinkedStackOfString();
        Assert.assertTrue(ls.isEmpty());
        Assert.assertEquals(0, ls.size());
        ls.push("to");
        ls.push("be");
        ls.push("or");
        ls.push("not");
        ls.push("to");
        Assert.assertFalse(ls.isEmpty());
        Assert.assertEquals(5, ls.size());
        Assert.assertEquals("to", ls.pop());
        ls.push("be");
        Assert.assertEquals("be", ls.pop());
        Assert.assertEquals("not", ls.pop());
        ls.push("that");
        Assert.assertEquals("that", ls.pop());
        Assert.assertEquals("or", ls.pop());
        Assert.assertEquals("be", ls.pop());


    }
}
