package demo.algorithms.ch14.exercise;

import demo.algorithms.ch14.demo.analysis.Stopwatch;
import demo.algorithms.ch14.demo.analysis.ThreeSum;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class E142DoublingTest {
    public static double timeTrial(int N) { // Time ThreeSum.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) { // Print table of running times.
        int[] x = new int[7];
        double[] y = new double[7];
        int limit = 25000;
        for (int N = 250, i = 0; N <= limit; N += N, i++) { // Print time for problem size N.
            double time = timeTrial(N);
            x[i] = N;
            y[i] = time;
            StdOut.printf("%7d %5.1f\n", N, time);
        }
        int prevX = 0;
        double prevY = 0;
        StdDraw.setXscale(0, x[6]);
        StdDraw.setYscale(0, y[6]);
        for (int i = 0 ; i < x.length; i++) {
            StdDraw.line(prevX, prevY, x[i], y[i]);
            prevX = x[i];
            prevY = y[i];
        }
    }
}
