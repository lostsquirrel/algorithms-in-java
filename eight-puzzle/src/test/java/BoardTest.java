import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BoardTest {

    @Test
    public void testInit() {
        int[][] blocks = TestUtils.read2blocks("puzzle01.txt");
        System.out.println(Arrays.toString(blocks));
        Board b = new Board(blocks);
        System.out.println(b);
    }

    @Test
    public void testDistance() {
        int[][] blocks = TestUtils.read2blocks("distance.txt");
        Board b = new Board(blocks);
        System.out.println(b);
        Assert.assertEquals(5, b.hamming());
        Assert.assertEquals(10, b.manhattan());

    }
}
