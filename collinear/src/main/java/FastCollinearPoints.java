/*************************************************************************
 *  Compilation:  javac FastCollinearPoints.java
 *  Execution:    none
 *  Dependencies: Point.java
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P03

 *
 *************************************************************************/

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
            double prevSlop = Double.NEGATIVE_INFINITY;
            s[0] = px;
            int c = 1;
            for (int j = 1; j < copy.length; j++) {
                double slopj = px.slopeTo(copy[j]);
                if (j > 1) {
                    if (Double.compare(prevSlop, slopj) == 0) {
                        s[c] = copy[j - 1];
                        s[++c] = copy[j];
                        if (c >= 3 && j == copy.length - 1) {
                            Arrays.sort(s, 0, c + 1, Point::compareTo);
                            if (!(contains(countedHead, s[0], sc)
                                    && contains(countedTail, s[c], sc))) {
                                countedHead[sc] = s[0];
                                countedTail[sc] = s[c];
                                st[sc++] = new LineSegment(s[0], s[c]);
                            }


                        }
                    } else {
                        if (c >= 3) {

                            Arrays.sort(s, 0, c + 1, Point::compareTo);
                            if (!(contains(countedHead, s[0], sc)
                                    && contains(countedTail, s[c], sc))) {
                                countedHead[sc] = s[0];
                                countedTail[sc] = s[c];
                                st[sc++] = new LineSegment(s[0], s[c]);
                            }
                            c = 1;

                        } else {
                            c = 1;
                        }
                    }

                }
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
        return Arrays.copyOf(segments, counter);
    }

    public static void main(String[] args) {
//    nothing here
    }
}
