/*************************************************************************
 *  Compilation:  javac FastCollinearPoints.java
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
import java.util.Comparator;


public class FastCollinearPoints {
    private LineSegment[] segments;

    private int counter;

    /**
     * // finds all line segments containing 4 points
     *
     * @param points 4 points
     */
    public FastCollinearPoints(Point[] points) {
        counter = 0;
        segments = new LineSegment[(points.length + 3) / 4];
        if (points == null) {
            throw new IllegalArgumentException();
        }
//        Arrays.sort(points, Point::compareTo);
//        Arrays.sort(points);
        int i = 0;
        while (i < points.length - 2) {
//            if (points[i].slopeOrder())
            Point px = points[i];
            Arrays.sort(points, i + 1, points.length, px.slopeOrder());

            int x = 0;
            for (int j = i + 1; j < points.length; j++) {
                System.out.println(px.slopeTo(points[j]));
            }
            while (new Double(px.slopeTo(points[i + 1]))
                    .equals(px.slopeTo(points[i + 2]))) {
                i++;
                x++;
            }
//            System.out.println(px.slopeTo(points[i + 1]));
            if (x >= 4) {
                segments[counter++] = new LineSegment(px, points[i + 1]);
            }
            if (x == 0) {
                i++;
            }
        }
        LineSegment[] sx = new LineSegment[counter];
        for (int j = 0; j < counter; i++) {
            sx[j] = segments[j];
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
