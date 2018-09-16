import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class BruteCollinearPointsTest {

    @Test(expected = IllegalArgumentException.class )
    public void testNullConstructor() {
        new BruteCollinearPoints(null);
    }
    @Test(expected = IllegalArgumentException.class )
    public void testNullPointFirst() {
        Point[] ps = new Point[]{
                null,
                new Point(    0,  10000),
                new Point( 3000,   7000),
                new Point( 7000,   3000),
                new Point(20000,  21000),
                new Point( 3000,   4000),
                new Point(14000,  15000),
                new Point( 6000,   7000)
        };
        draw(ps);
    }

    @Test(expected = IllegalArgumentException.class )
    public void testRepeatPoint() {
        Point[] ps = new Point[]{

                new Point(0, 10000),
                new Point(3000, 7000),
                new Point(7000, 3000),
                new Point(0, 10000),
                new Point(3000, 4000),
                new Point(14000, 15000),
                new Point(6000, 7000),
                new Point(10000, 0)
        };
        draw(ps);
    }
    @Test
    public void test8() {
        Point[] ps = new Point[]{
                new Point(10000,      0),
                new Point(    0,  10000),
                new Point( 3000,   7000),
                new Point( 7000,   3000),
                new Point(20000,  21000),
                new Point( 3000,   4000),
                new Point(14000,  15000),
                new Point( 6000,   7000)
        };
        draw(ps);
    }

    private void draw(Point[] points)  {
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
//        for (Point p : points) {
//            p.draw();
//        }
//        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
        try {
            TimeUnit.SECONDS.sleep(60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
