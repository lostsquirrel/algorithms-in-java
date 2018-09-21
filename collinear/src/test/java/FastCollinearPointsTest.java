import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class FastCollinearPointsTest {

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
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        drawPoints(points);

        drawLine(points);
        try {
            TimeUnit.SECONDS.sleep(60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void drawPoints(Point[] points) {
        StdDraw.setPenRadius(0.01);
        for (Point p : points) {
//            StdOut.println(p);
            p.draw();
        }
    }
    public static void drawLine(Point[] points) {
        StdDraw.setPenRadius(0.001);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
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
                int separator = s.indexOf(' ');
                String s1 = s.substring(0, separator);
                String s2 = s.substring(separator, s.length()).trim();
                int x = Integer.parseInt(s1);
                int y = Integer.parseInt(s2);
                points[i] = new Point(x, y);
            }

        }
        return points;
    }
}
