/*************************************************************************
 *  Compilation:  javac BruteCollinearPoints.java
 *  Execution:    none
 *  Dependencies: Point.java
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P03

 *
 *************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class BruteCollinearPoints {
    private LineSegment[] segments;

    private int counter;

    /**
     * // finds all line segments containing 4 points
     *
     * @param points 4 points
     */
    public BruteCollinearPoints(Point[] points) {
        counter = 0;
        segments = new LineSegment[(points.length + 3) / 4];
        if (points == null) {
            throw new IllegalArgumentException();
        }
//        Arrays.sort(points, Point::compareTo);
//        Arrays.sort(points);
        for (int i = 0; i < points.length; i += 4) {
//            if (points[i].slopeOrder())
            Arrays.sort(points, i, i + 4, Point::compareTo);
            Point p0 = points[i];
            Point px = null;
            Double s1 = null;
            for (int j = 1; j < 4; j++) {
                px = points[i + j];
                Double sx = p0.slopeTo(px);
                System.out.println(String.format("%f, %f", s1, sx));
                if (s1 == null) {
                    s1 = sx;
                } else if (!s1.equals(sx)) {
                    break;
                }

            }
            segments[counter++] = new LineSegment(p0, px);
        }
        LineSegment[] sx = new LineSegment[counter];
        for (int i = 0; i < counter; i++) {
            sx[i] = segments[i];
        }
        segments = sx;

    }

    /**
     * @return the number of line segments
     */
    public int numberOfSegments() {

        return counter;
    }

    public LineSegment[] segments() {
        return segments;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
