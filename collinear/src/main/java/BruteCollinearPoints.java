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
    private final LineSegment[] segments;

    private int counter;

    /**
     * // finds all line segments containing 4 points
     *
     * @param points 4 points
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        counter = 0;
        segments = new LineSegment[points.length];
//        Arrays.sort(points, Point::compareTo);
//        Arrays.sort(points);
        for (int i = 0; i <= points.length - 4; i++) {
//            if (points[i].slopeOrder())
            Arrays.sort(points, i, i + 4, Point::compareTo);
            Point pp = null;
            Double slop = null;
            boolean hasLine = true;
            for (int j = 0; j < 4; j++) {
                Point px = points[i + j];
                if (px == null) {
                    throw new IllegalArgumentException();
                }
                if (pp != null && px.compareTo(pp) == 0) {
                    throw new IllegalArgumentException();
                }
                if (j == 1) {
                    slop = pp.slopeTo(px);
                }
                if (j > 1 && Double.compare(slop, pp.slopeTo(px)) != 0) {
                    break;
                }

                pp = px;
                StdOut.println(px);
            }
            StdOut.println();
            if (hasLine) {
                segments[counter++] = new LineSegment(points[i], points[i + 3]);
            }
        }
    }

    /**
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return counter;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, counter);
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
//            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
