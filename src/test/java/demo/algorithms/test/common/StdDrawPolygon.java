package demo.algorithms.test.common;

import edu.princeton.cs.algs4.StdDraw;

public class StdDrawPolygon {
    public static void main(String[] args) {
        double[] x = {0.1, 0.2, 0.3, 0.2};
        double[] y = {0.2, 0.3, 0.2, 0.1};
        StdDraw.filledPolygon(x, y);
    }
}
