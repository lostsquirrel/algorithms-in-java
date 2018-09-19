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
import java.util.Comparator;


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
        int n = points.length;
        segments = new LineSegment[n];
//        Arrays.sort(points, Point::compareTo);
//        Arrays.sort(points);
        if (n < 4) {
            if (n > 0) {
                if (points[0] == null) {
                    throw new IllegalArgumentException();
                }
            }
            if (n > 1) {
                if (points[1] == null || points[0].compareTo(points[1]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
            if (n > 2) {
                if (points[2] == null || points[0].compareTo(points[2]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
            return;
        }
        for (int i = 0; i < n - 3; i++) {
//            if (points[i].slopeOrder())
            Point pi = points[i];
            if (pi == null) {
                throw new IllegalArgumentException();
            }
            for (int j = i + 1; j < n - 2; j++) {
                Point pj = points[j];
                if (pj == null || pi.compareTo(pj) == 0) {
                    throw new IllegalArgumentException();
                }
                double sij = pi.slopeTo(pj);
                for (int k = j + 1; k < n - 1; k++) {
                    Point pk = points[k];
                    if (pk == null
                            || pi.compareTo(pk) == 0
                            || pj.compareTo(pk) == 0) {
                        throw new IllegalArgumentException();
                    }
                    double sik = pi.slopeTo(pk);
                    if (Double.compare(sij, sik) != 0) {
//                        StdOut.println(pi);
//                        StdOut.println(pj);
//                        StdOut.println(pk);
//                        StdOut.println();
                        continue;
                    }
                    for (int m = k + 1; m < n; m++) {
                        Point pl = points[m];
                        if (pl == null
                                || pi.compareTo(pl) == 0
                                || pj.compareTo(pl) == 0
                                || pk.compareTo(pl) == 0) {
                            throw new IllegalArgumentException();
                        }
                        double sil = pi.slopeTo(pl);
                        if (Double.compare(sij, sil) == 0) {
                            Point[] s = new Point[]{pi, pj, pk, pl};
                            Arrays.sort(s, Point::compareTo);
                            segments[counter++] = new LineSegment(s[0], s[3]);
                        }
                    }
                }
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
