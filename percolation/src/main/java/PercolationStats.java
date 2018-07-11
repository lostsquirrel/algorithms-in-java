/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P01
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Model an n-by-n percolation system using the union-find
 *                data structure.
 ******************************************************************************/
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Programming Assignment 1: Percolation
 * Write a program to estimate the value of the percolation threshold
 * via Monte Carlo simulation.
 */
public class PercolationStats {

    /**
     * mean for trials
     */
    private final double mean;
    /**
     * stddev for trial
     */
    private final double stddev;
    /**
     * low confidence interval
     */
    private final double confidenceLo;
    /**
     * high confidence interval
     */
    private final double confidenceHi;

    /**
     * // perform trials independent experiments on an n-by-n grid
     * @param n grid size
     * @param trials trials number
     */
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n ≤ 0 or trials ≤ 0.");
        }

        double[] res = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            int j = 0;
            while (!p.percolates()) {
                int row = random(n);
                int col = random(n);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    j++;
                }

            }
//            System.out.printf("%d, %d\n",j, (n * n) );
            res[i] = (j * 1.0) / (n * n);
        }
        mean = StdStats.mean(res);
        stddev = StdStats.stddev(res);
        double ci = stddev * 1.96 / Math.sqrt(res.length);
        confidenceLo = mean - ci;
        confidenceHi = mean + ci;
//        System.out.println(Arrays.toString(res));
    }

    private int random(int n) {
        return StdRandom.uniform(n) + 1;
    }

    /**
     * // sample mean of percolation threshold
     * @return sample mean
     */
    public double mean() {

        return mean;
    }

    /**
     * // sample standard deviation of percolation threshold
     * @return sample standard deviation
     */
    public double stddev() {
        return stddev;
    }

    /**
     * // low  endpoint of 95% confidence interval
     * @return low  endpoint
     */
    public double confidenceLo() {
        return confidenceLo;
    }

    /**
     * // high endpoint of 95% confidence interval
     * @return high endpoint
     */
    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        // test client (described below)

        PercolationStats ps =
                new PercolationStats(Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]));

        System.out.println(
                String.format("mean                    = %f", ps.mean()));
        System.out.println(
                String.format("stddev                  = %f", ps.stddev()));
        System.out.println(
                String.format(
                        "95%% confidence interval = [%f, %f]",
                        ps.confidenceLo(), ps.confidenceHi()));
    }

}
