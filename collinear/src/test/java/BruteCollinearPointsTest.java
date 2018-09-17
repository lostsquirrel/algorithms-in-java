import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BruteCollinearPointsTest {

    @Test(expected = IllegalArgumentException.class )
    public void testNullConstructor() {
        new BruteCollinearPoints(null);
    }
    @Test(expected = IllegalArgumentException.class )
    public void testNullPointFirst() {

        draw(null);
    }

    @Test(expected = IllegalArgumentException.class )
    public void testRepeatPoint() {
        draw(null);
    }
    @Test
    public void test8() {
        draw("input8.txt");
    }
    @Test
    public void test40() {
        draw("input40.txt");
    }
    @Test
    public void equidistant() {
        draw("equidistant.txt");
    }
    private void draw(String file)  {
        In in = new In(file);
        int[] inputs = in.readAllInts();
        Point[] points = new Point[inputs[0]];
        for (int i = 0; i < inputs.length / 2; i++) {
            int a = (i + 1) * 2;
            int p = a - 1;
            points[i] = new Point(inputs[p], inputs[a]);
        }
        // draw the points
//        StdDraw.enableDoubleBuffering();

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
//        StdDraw.line(0, 0, 0, 32768);
////        StdDraw.line(0, 0, 32768, 0);
//        Arrays.sort(points,0, 3, Point::compareTo);
//        Arrays.sort(points,4, 7, Point::compareTo);
        drawPoints(points);
//        StdDraw.show();

        // print and draw the line segments
        drawLine(points);
        try {

            TimeUnit.SECONDS.sleep(60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void drawPoints(Point[] points) {
        StdDraw.setPenRadius(0.005);
        for (Point p : points) {
            StdOut.println(p);
            p.draw();
        }
    }

    private void drawLine(Point[] points) {
        StdDraw.setPenRadius(0.001);
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    @Test
    public void testIn() {
        In in = new In("input8.txt");
        StdOut.println();
    }
}
