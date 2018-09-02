package demo.algorithms.test.common;

import edu.princeton.cs.algs4.StdDraw;

public class StdDrawCoordinateTest {
    public static void main(String[] args) {
        StdDraw.setXscale(-10, 10);

        StdDraw.setYscale(-10, 10);
        StdDraw.line(-5, 1, 5, 2);
        StdDraw.line(-10, 0, 10, 0);
        StdDraw.line(0, -10, 0,10);
    }
}
