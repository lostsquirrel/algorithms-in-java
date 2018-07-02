import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * song li
 * 2018.07.02
 * Programming Assignment 1: Percolation
 Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.
 */
public class Percolation {

    /**
     * container to hold the grid
     */
    private final WeightedQuickUnionUF uf;

    /**
     * keep the open state of each site
     */
    private int[][] openState;

    /**
     * number of open site
     */
    private int openSites;

    /**
     * size union find data
     */
    private int size;

    /**
     * initial of grid
     */
    private int n;

    public Percolation(int n){
        size = (n + 2) * n; // make size for virtual-top/virtual-bottom
        uf = new WeightedQuickUnionUF(size);
        openState = new int[n + 1][n + 1];
    }

    /**
     *  // open site (row, col) if it is not open already
     * @param row row in grid
     * @param col column in grid
     */
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        openSites += 1;
        if (row == 1) {
//            first row
            int thisSite = n + row - 1;
            uf.connected(0, thisSite);
            if (col == 1) {
                openState[row][col] += 2;
//                the left top corner
                if (isOpen(row, col + 1)) {
                    int rightSite = thisSite + 1;
                    uf.connected(thisSite, rightSite);
                    openState[row][col] += 1;
                }
                if (isOpen(row + 1, col)) {
                    int bottomSite = thisSite + n;
                    uf.connected(thisSite, bottomSite);
                    openState[row][col] += 1;
                }
            } else if (col == n) {
//                the right top corner

            } else {
//                other in top

            }
        } else if (row == n) {
//          last row
        } else {

        }
    }

    /**
     * is site (row, col) open?
     * @param row row in grid
     * @param col column in grid
     * @return true if the site if open
     */
    public boolean isOpen(int row, int col) {
        return openState[row][col] > 0;
    }

    /**
     * is site (row, col) full?
     * @param row row in grid
     * @param col column in grid
     * @return true if the site is full
     */
    public boolean isFull(int row, int col) {
        return openState[row][col] == 4;
    }

    /**
     * number of open sites
     * @return number of open sites
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * // does the system percolate?
     * @return true percolate, false otherwise
     */
    public boolean percolates() {
//        set the 0 as the virtual-top
//        size -1 as the virtual-bottom
        return uf.connected(0, size - 1);
    }

    public static void main(String[] args) {

    }
}
