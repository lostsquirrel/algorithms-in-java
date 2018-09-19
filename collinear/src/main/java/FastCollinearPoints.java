/*************************************************************************
 *  Compilation:  javac FastCollinearPoints.java
 *  Execution:    none
 *  Dependencies: Point.java
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P03

 *
 *************************************************************************/

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class FastCollinearPoints {
    private final LineSegment[] segments;

    private final int counter;

    /**
     * // finds all line segments containing 4 points
     *
     * @param points 4 points
     */
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            counter = 0;
            segments = new LineSegment[0];
            throw new IllegalArgumentException();
        }
        int n = points.length;

        if (n < 4) {
            segments = new LineSegment[0];
            counter = 0;
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
                if (points[2] == null || points[0].compareTo(points[2]) == 0
                        || points[1].compareTo(points[2]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
            return;
        }
        LineSegment[] st = new LineSegment[n];
        Point[] copy = Arrays.copyOf(points, n);
        Point[] countedHead = new Point[n];
        Point[] countedTail = new Point[n];
        Point[] s = new Point[n];


        int sc = 0;
        for (int i = 0; i < points.length; i++) {
            Point px = points[i];
            Arrays.sort(copy, px.slopeOrder());
            if (px.compareTo(copy[1]) == 0) {
                throw new IllegalArgumentException();
            }
            Double prevSlop = null;
            Double ppSlop = null;
            s[0] = px;
            int c = 1;
            for (int j = 1; j < copy.length; j++) {
                double slopj = px.slopeTo(copy[j]);
                StdOut.println(slopj);
                if (j > 1) {
                    if (ppSlop != null && Double.compare(prevSlop, slopj) == 0) {
                        if (Double.compare(ppSlop, prevSlop) != 0) {
                            s[c++] = copy[j - 1];
                        }
                        s[c++] = copy[j];
                    } else {

                        if (c >= 4) {
                            Arrays.sort(s, 0, c, Point::compareTo);
                            if (!contains(countedHead, s[0], sc)
                                    || !contains(countedTail, s[c - 1], sc)) {
                                countedHead[sc] = s[0];
                                countedTail[sc] = s[c - 1];
                                st[sc++] = new LineSegment(s[0], s[c - 1]);
                                break;
                            } else {
                                c = 1;
                            }
                        } else {
                            c = 1;
                        }
                    }

                }
                ppSlop = prevSlop;
                prevSlop = slopj;

            }

        }
        counter = sc;
        segments = Arrays.copyOf(st, sc);
    }

    private boolean contains(Point[] points, Point point, int n) {
        for (int i = 0; i < n; i++) {
            Point px = points[i];
            if (px.compareTo(point) == 0) {
                return true;
            }
        }
        return false;
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

    }
}
