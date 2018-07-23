import java.util.Arrays;

/*************************************************************************
 *  Compilation:  javac BruteCollinearPoints.java
 *  Execution:    none
 *  Dependencies: Point.java
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P03

 *
 *************************************************************************/

public class BruteCollinearPoints {
    private LineSegment[] segments;

    private int counter;
    /**
     * // finds all line segments containing 4 points
     * @param points 4 points
     */
    public BruteCollinearPoints(Point[] points) {
        counter = 0;
        if (points == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(points, Point::compareTo);
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
//            if (points[i].slopeOrder())
        }
        segments = new LineSegment[(points.length + 3) / 4];
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
}
