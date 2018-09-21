import edu.princeton.cs.algs4.StdDraw;

public class LineCheck {
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(9000, 1000),
                new Point(6000, 2000),
                new Point(12000, 10000),
                new Point(15000, 19000)};
        drawPoints(points);
    }

    public static void drawPoints(Point[] points) {
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
//            StdOut.println(p);
            p.draw();
        }
        StdDraw.show();
    }
}
