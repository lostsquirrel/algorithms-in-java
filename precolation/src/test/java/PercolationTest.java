import org.junit.Assert;
import org.junit.Test;

public class PercolationTest {

    Percolation p = new Percolation(10);
    @Test
    public void testLeftCorner() {
        p.open(1, 1);
        Assert.assertTrue(p.isOpen(1, 1));
        Assert.assertFalse(p.isFull(1, 1));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);
    }
}
