import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
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
//        2
        draw("input8.txt");
    }
    @Test
    public void test40() {
//        4
        draw("input40.txt");
    }
    @Test
    public void input48() {
//        6
        draw("input48.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void duplicate5() {
        draw("duplicate5.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void duplicate3() {
        draw("duplicate3.txt");
    }

    private void draw(String file)  {
        Point[] points = getPoints(file);
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

    public static Point[] getPoints(String file) {
        In in = new In(file);
        int n = Integer.parseInt(in.readLine().trim());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            if (s == null || s.trim().length() == 0) {
                continue;
            }
            if ("null".equals(s.trim())) {
                points[i] = null;
            } else {
                s = s.trim();
                int seperator = s.indexOf(' ');
                String s1 = s.substring(0, seperator);
                String s2 = s.substring(seperator, s.length()).trim();
                int x = Integer.parseInt(s1);
                int y = Integer.parseInt(s2);
                points[i] = new Point(x, y);
            }

        }
        return points;
    }

    public static void drawPoints(Point[] points) {
        StdDraw.setPenRadius(0.005);
        for (Point p : points) {
//            StdOut.println(p);
            p.draw();
        }
    }

    public static void drawLine(Point[] points) {
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
    @Test
    public void testInOfNull() {
        In in = new In("nulloneinten.txt");
        int n = Integer.parseInt(in.readLine().trim());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            if (s == null || s.trim().length() == 0) {
                continue;
            }
            if ("null".equals(s.trim())) {
                points[i] = null;
            } else {
                s = s.trim();
                int seperator = s.indexOf(' ');
                String s1 = s.substring(0, seperator);
                String s2 = s.substring(seperator, s.length()).trim();
                int x = Integer.parseInt(s1);
                int y = Integer.parseInt(s2);
                points[i] = new Point(x, y);
            }

        }
        StdOut.println(Arrays.toString(points));
    }
}
