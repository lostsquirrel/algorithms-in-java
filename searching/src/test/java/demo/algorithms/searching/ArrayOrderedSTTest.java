package demo.algorithms.searching;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ArrayOrderedSTTest {

    private static final Logger logger = LoggerFactory.getLogger(ArrayOrderedSTTest.class);
    
    private ArrayOrderedST<String, Integer> st = new ArrayOrderedST<>();

    private String[] alpha = "abcdefghijklmnopqrstuvwxyz".split("");

    @Test
    public void testMinMax() {
        for (int i = 0; i < 20; i++) {
            int x = new Double(Math.random() * 100).intValue();
            String key = "" + x;
            logger.debug(key);
            st.put(key, x);
        }
       logger.debug("Max: " + st.max());
       logger.debug("Min: " + st.min());
       logger.debug(st.toString());
    }

    @Test
    public void testFloor() {
        for (int i = 0; i < 10; i++) {
//            logger.debug(alpha[i]);
            st.put(alpha[i], i);
        }
       logger.debug(st.floor("k"));
        Assert.assertEquals("j", st.floor("k"));
       logger.debug(st.floor("j"));
        Assert.assertEquals("j", st.floor("j"));
    }
    @Test
    public void testCeiling() {
        for (int i = 0; i < 10; i += 2) {
            logger.debug(alpha[i]);
            st.put(alpha[i], i);
        }
       logger.debug(st.ceiling("h"));
        Assert.assertEquals("i", st.ceiling("h"));
       logger.debug(st.ceiling("i"));
        Assert.assertEquals("i", st.ceiling("i"));
    }

    @Test
    public void testRandSelect() {
        for (int i = 0; i < 20; i++) {
//            int x = new Double(Math.random() * 100).intValue();
            st.put(alpha[i], i);
        }
        int i = 2;
        Assert.assertTrue(i == st.rank(st.select(i)));
    }
}
