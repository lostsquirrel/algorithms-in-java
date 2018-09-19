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
        int c = 0;
        for (int i = 0; i < points.length; i++) {
            Point px = points[i];
            Arrays.sort(copy, px.slopeOrder());
            if (px.compareTo(copy[1]) == 0) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < copy.length - 2; j++) {
                int z = px.slopeOrder().compare(copy[j], copy[j + 1]);
                int zx = px.slopeOrder().compare(copy[j + 1], copy[j + 2]);
                if (zx == 0 && z == 0) {
                    Point[] s = new Point[]{px,  copy[j], copy[j + 1], copy[j + 2]};
                    Arrays.sort(s, Point::compareTo);
                    if (!contains(countedHead, s[0], c)
                            || !contains(countedTail, s[3], c)) {
                        countedHead[c] = s[0];
                        countedTail[c] = s[3];
                        st[c++] = new LineSegment(s[0], s[3]);
                    }
                }
            }

        }
        counter = c;
        segments = Arrays.copyOf(st, c);
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
