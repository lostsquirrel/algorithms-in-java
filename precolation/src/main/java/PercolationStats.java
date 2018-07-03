/**
 * song li
 * 2018.07.03
 * Programming Assignment 1: Percolation
 * Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.
 */
public class PercolationStats {

    /**
     * // perform trials independent experiments on an n-by-n grid
     * @param n grid size
     * @param trials trials number
     */
    public PercolationStats(int n, int trials) {

    }

    /**
     * // sample mean of percolation threshold
     * @return sample mean
     */
    public double mean() {
        return 0;
    }

    /**
     * // sample standard deviation of percolation threshold
     * @return sample standard deviation
     */
    public double stddev() {
        return 0;
    }

    /**
     * // low  endpoint of 95% confidence interval
     * @return low  endpoint
     */
    public double confidenceLo() {
        return 0;
    }

    /**
     * // high endpoint of 95% confidence interval
     * @return high endpoint
     */
    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {
        // test client (described below)
        if (args.length != 2 || Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
            throw new IllegalArgumentException("n ≤ 0 or trials ≤ 0.");
        }

    }
}
