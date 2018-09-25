/*************************************************************************
 *  Compilation:  javac FastCollinearPoints.java
 *  Execution:    none
 *  Dependencies: Point.java
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P03

 *
 *************************************************************************/

import edu.princeton.cs.algs4.Stack;

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
        MyLine[] findLines = new MyLine[n + 1];

        int sc = 0;
        for (int i = 0; i < points.length; i++) {
            Point px = points[i];
            Arrays.sort(copy, px.slopeOrder());
            if (px.compareTo(copy[1]) == 0) {
                throw new IllegalArgumentException();
            }
            double prevSlop = Double.NEGATIVE_INFINITY;
            Point[] s = new Point[n];
            Stack<Point> stack = new Stack<>();

            int c = 0;
            for (int j = 1; j < copy.length; j++) {
                Point pj = copy[j];
                double slopj = px.slopeTo(pj);

                if (j > 1) {
                    if (Double.compare(prevSlop, slopj) == 0) {
                        stack.push(pj);
                        if (j == copy.length - 1) {
                            c = transfer(s, stack);
                            if (c > 2) {
                                s[c++] = px;
                                Arrays.sort(s, 0, c, Point::compareTo);
                                Point head = s[0];
                                Point tail = s[c - 1];
                                MyLine newLine = new MyLine(head, tail);
                                if (newLine(findLines, newLine, sc)) {
                                    findLines[sc] = newLine;
                                    st[sc++] = new LineSegment(s[0], s[c - 1]);
                                }
                            }

                        }
                    } else {
                        c = transfer(s, stack);
                        if (c > 2) {
                            s[c++] = px;
                            Arrays.sort(s, 0, c, Point::compareTo);
                            Point head = s[0];
                            Point tail = s[c - 1];
                            MyLine newLine = new MyLine(head, tail);
                            if (newLine(findLines, newLine, sc)) {
                                findLines[sc] = newLine;
                                st[sc++] = new LineSegment(s[0], s[c - 1]);
                            }
                        }
                        stack.push(pj);
                    }

                } else {
                    stack.push(pj);
                }
                prevSlop = slopj;
            }
        }
        counter = sc;
        segments = Arrays.copyOf(st, sc);
    }

    private class MyLine {
        Point head;
        Point tail;

        MyLine(Point head, Point tail) {
            this.head = head;
            this.tail = tail;
        }

        boolean isSame(MyLine other) {
            return head.compareTo(other.head) == 0
                    && tail.compareTo(other.tail) == 0;
        }
    }

    private int transfer(Point[] s, Stack<Point> stack) {
        clean(s);
        int c = 0;
        while (!stack.isEmpty()) {
            s[c++] = stack.pop();
        }
        return c;
    }

    private boolean newLine(MyLine[] findLines, MyLine newLine, int n) {
        for (int i = 0; i < n; i++) {
            if (newLine.isSame(findLines[i])) {
                return false;
            }
        }
        return true;
    }

    private void clean(Point[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                s[i] = null;
            } else {
                break;
            }
        }
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
