import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PointTest {

    private static final Logger logger = LoggerFactory.getLogger(PointTest.class);
    @Test
    public void testCompareTo() {
        Point p0 = new Point(1, 1);
        Assert.assertEquals(1, p0.compareTo(new Point(0, 0)));
        Assert.assertEquals(1, p0.compareTo(new Point(1, 0)));
        Assert.assertEquals(1, p0.compareTo(new Point(2, 0)));
        Assert.assertEquals(-1, p0.compareTo(new Point(2, 1)));
        Assert.assertEquals(-1, p0.compareTo(new Point(2, 2)));
        Assert.assertEquals(-1, p0.compareTo(new Point(1, 2)));
        Assert.assertEquals(-1, p0.compareTo(new Point(0, 2)));
        Assert.assertEquals(1, p0.compareTo(new Point(0, 1)));
        Assert.assertEquals(0, p0.compareTo(new Point(1, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNull() {
        new Point(1, 1).compareTo(null);
    }

    @Test
    public void testSlopeTo() {
        Point p0 = new Point(1, 1);
        Assert.assertTrue(0 == p0.slopeTo(new Point(2, 1)));
        Assert.assertTrue(0 == p0.slopeTo(new Point(0, 1)));
        Assert.assertTrue(1 == p0.slopeTo(new Point(2, 2)));
        Assert.assertTrue(-1 == p0.slopeTo(new Point(0, 2)));
        Assert.assertTrue(Double.POSITIVE_INFINITY == p0.slopeTo(new Point(1, 2)));
//        logger.debug("{}",p0.slopeTo(new Point(1, 1)));
        Assert.assertTrue(Double.NEGATIVE_INFINITY == p0.slopeTo(new Point(1, 1)));
        Assert.assertTrue(Double.POSITIVE_INFINITY == p0.slopeTo(new Point(1, 0)));
        Assert.assertTrue(Double.POSITIVE_INFINITY == new Point(68, 361).slopeTo(new Point(68, 466)));


    }

    @Test
    public void test10() {
        Assert.assertTrue(Double.NEGATIVE_INFINITY == new Point(433, 235).slopeTo(new Point(433, 106)));
    }

    @Test
    public void testSlopOrder() {
        Point p                         = new Point(4, 5);
        Point q                         = new Point(2, 5);
        Point r                         = new Point(6, 5);
        int compare = p.slopeOrder().compare(q, r);
        double d1 = p.slopeTo(q);
        double d2 = p.slopeTo(r);
        logger.debug("{},{}, {}", d1, d2, compare);
        Assert.assertTrue(Double.compare(0, compare) == 0);
        Assert.assertTrue(Double.compare(0, d1) == 0);
        Assert.assertTrue(Double.compare(0, d2) == 0);
    }

    @Test
    public void testSlopOrder1() {
        Point p                         = new Point(4, 5);
        Point q                         = new Point(2, 5);
        p.slopeOrder().compare(q, null);
    }


}
