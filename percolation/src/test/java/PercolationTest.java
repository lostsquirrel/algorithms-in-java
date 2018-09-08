import org.junit.Assert;
import org.junit.Test;

public class PercolationTest {


    @Test
    public void testLeftTopCorner() {
        Percolation p = new Percolation(10);
        p.open(1, 1);
        Assert.assertTrue(p.isOpen(1, 1));
//        Assert.assertFalse(p.isFull(1, 1));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);

        p.open(1, 2);
        p.open(2, 1);
        p.open(2, 2);
//        Assert.assertTrue(p.isFull(1, 1));
    }

    @Test
    public void testLeftBottomCorner() {
        Percolation p = new Percolation(10);
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
        Percolation p = new Percolation(10);
        int row = 1;
        int col = 10;
        p.open(row, col);
        Assert.assertTrue(p.isOpen(row, col));
//        Assert.assertFalse(p.isFull(row, col));
        Assert.assertFalse(p.percolates());
        Assert.assertEquals(p.numberOfOpenSites(), 1);
//        Assert.assertTrue(p);
    }

    @Test
    public void testRightBottomCorner() {
        Percolation p = new Percolation(10);
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
        Percolation p = new Percolation(10);
        int row = 1;
        for (int col = 1; col <= 10; col++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
//            Assert.assertFalse(p.isFull(row, col));
            Assert.assertFalse(p.percolates());
            Assert.assertEquals(p.numberOfOpenSites(), col);
        }
    }

    @Test
    public void testBottomRow() {
        Percolation p = new Percolation(10);
        int row = 10;
        for (int col = 1; col <= 10; col++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
            Assert.assertFalse(p.isFull(row, col));
            Assert.assertFalse(p.percolates());
            Assert.assertEquals(p.numberOfOpenSites(), col);
        }
    }

    @Test
    public void testLeftCol() {
        Percolation p = new Percolation(10);
        int col = 1;
        for (int row = 1; row <= 10; row++) {
            p.open(row, col);
            Assert.assertTrue(p.isOpen(row, col));
//            Assert.assertFalse(p.isFull(row, col));
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

    @Test
    public void test1() {
        int n = 1;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void test2() {
        int n = 2;
        Percolation p = new Percolation(n);
        p.open(1, 1);
        p.open(2, 2);
        p.open(1, 2);
        Assert.assertTrue(p.percolates());
    }
    @Test
    public void test6() {
        int n = 6;
        Percolation p = new Percolation(n);
        p.open(1, 6);
        p.open(2, 6);
        Assert.assertTrue(p.isFull(2, 6));
        p.open(3, 6);

        p.open(4, 6);
        p.open(5, 6);
        Assert.assertTrue(p.isFull(5, 6));
        p.open(5, 5);
        Assert.assertTrue(p.isFull(5, 5));
        p.open(4, 4);
        p.open(3, 4);
        p.open(2, 4);

        p.open(2, 3);
        p.open(2, 2);
        p.open(2, 1);
        p.open(3, 1);
        p.open(4, 1);
        p.open(5, 1);
        p.open(5, 2);
        p.open(6, 2);
        p.open(5, 4);
        Assert.assertTrue(p.isFull(5, 4));
        Assert.assertTrue(p.isFull(6, 2));
        Assert.assertTrue(p.isFull(1, 6));
        Assert.assertTrue(p.isOpen(1, 6));
        Assert.assertTrue(p.percolates());
    }

    @Test
    public void test8() {
        int n = 8;
        Percolation p = new Percolation(n);
        p.open(1, 6);
        p.open(1, 6);
        p.open(1, 6);
        p.open(1, 6);
        Assert.assertEquals(1, p.numberOfOpenSites());
        Assert.assertTrue(p.isFull(1, 6));
        Assert.assertTrue(p.isOpen(1, 6));
    }
}
