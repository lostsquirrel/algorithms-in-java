package demo.algorithms.test.common;

import edu.princeton.cs.algs4.StdDraw;

public class StdDrawPointLineTest {
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.05); // 画笔粗细
        StdDraw.setPenColor(StdDraw.BLUE); // 画笔颜色
        StdDraw.point(0.5, 0.5);  // 画点
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2); // 画线
    }
}
