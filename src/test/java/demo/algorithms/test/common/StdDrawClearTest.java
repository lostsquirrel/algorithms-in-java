package demo.algorithms.test.common;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class StdDrawClearTest {
    public static void main(String[] args) {
        Color[] colors = new Color[]{StdDraw.RED, StdDraw.ORANGE,
                StdDraw.YELLOW, StdDraw.GREEN, StdDraw.CYAN, StdDraw.MAGENTA};
        StdDraw.setPenRadius(0.05);
        double x = 0.1;
        for (Color c : colors){
            StdDraw.setPenColor(c);
            StdDraw.point(x, x);
            x += 0.1;
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StdDraw.clear(c);
        }
    }
}
