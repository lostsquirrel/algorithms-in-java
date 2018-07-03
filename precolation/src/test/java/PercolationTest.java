import org.junit.Assert;
import org.junit.Test;

public class PercolationTest {

    Percolation p = new Percolation(10);
    @Test
    public void testLeftTopCorner() {
        p.open(1, 1);
        Assert.assertTrue(p.isOpen(1, 1));
        Assert.assertFalse(p.isFull(1, 1));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);

        p.open(1,2);
        p.open(2, 1);
        p.open(2, 2);
        Assert.assertTrue(p.isFull(1, 1));
    }

    @Test
    public void testLeftBottomCorner() {
        int row = 10;
        int col = 1;
        p.open(row, 1);
        Assert.assertTrue(p.isOpen(row, col));
        Assert.assertFalse(p.isFull(row, col));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);
    }

    @Test
    public void testRightTopCorner() {
        int row = 1;
        int col = 10;
        p.open(row, col);
        Assert.assertTrue(p.isOpen(row, col));
        Assert.assertFalse(p.isFull(row, col));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);
//        Assert.assertTrue(p);
    }
    @Test
    public void testRightBottomCorner() {
        int row = 10;
        int col = 10;
        p.open(row, col);
        Assert.assertTrue(p.isOpen(row, col));
        Assert.assertFalse(p.isFull(row, col));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);
//        Assert.assertTrue(p);
    }

    @Test
    public void testTopRow() {
        int row = 1;
        for (int col = 1; col <= 10 ; col++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
            Assert.assertFalse(p.isFull(row, col));
            Assert.assertFalse(p.percolates());
            Assert.assertEquals(p.numberOfOpenSites(), col);
        }
    }

    @Test
    public void testBottomRow() {
        int row = 10;
        for (int col = 1; col <= 10 ; col++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
            Assert.assertFalse(p.isFull(row, col));
            Assert.assertFalse(p.percolates());
            Assert.assertEquals(p.numberOfOpenSites(), col);
        }
    }

    @Test
    public void testLeftCol() {
        int col = 1;
        for (int row = 1; row <= 10; row++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
            Assert.assertFalse(p.isFull(row, col));
            if (row < 10) {
                Assert.assertFalse(p.percolates());
            } else {
                Assert.assertTrue(p.percolates());
            }

            Assert.assertEquals(p.numberOfOpenSites(), row);
        }
//        p.string();
        Assert.assertTrue(p.percolates());
    }
}
