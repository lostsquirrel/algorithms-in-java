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
        segments = new LineSegment[(points.length + 3)];
        if (points == null) {
            throw new IllegalArgumentException();
        }
//        Arrays.sort(points, Point::compareTo);
//        Arrays.sort(points);


        for (int i = 0; i < points.length; i++) {
//            if (points[i].slopeOrder())
            Point px = points[i];
            Point[] tps = new Point[points.length - 1];
            for (int j = 0, k = 0; j < tps.length; ) {
              if (j == i) {
                  k++;
              }
              tps[j++] = points[k++];
            }
            Arrays.sort(tps, px.slopeOrder());
//            StdDraw.show();
            int x = 0;
            Point pp = null;
            for (int j = 0; j < tps.length - 2; j++) {
                Double s1 = px.slopeTo(tps[j + 1]);
                Double s2 = px.slopeTo(tps[j + 2]);
                System.out.printf("%f,%f\n", s1, s2);
                if (s1.equals(s2)) {
                    x++;
                    pp = tps[j + 2];
                }

            }
//
////            System.out.println(px.slopeTo(points[i + 1]));
            if (x >= 3) {
                segments[counter++] = new LineSegment(px, pp);
            }

            System.out.println("----------------------------");
        }
        LineSegment[] sx = new LineSegment[counter];
        for (int j = 0; j < counter; j++) {
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
