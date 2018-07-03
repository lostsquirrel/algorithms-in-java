import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

/**
 * song li
 * 2018.07.02
 * Programming Assignment 1: Percolation
 * Write a program to estimate the value of the percolation threshold via Monte Carlo simulation.
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
     * initial of grid
     */
    private int n;

    private int vTop = 0;

    private int vBottom;

    public Percolation(int n) {
        /*
      size union find data
     */
        int size = (n + 2) * (n + 1);
        uf = new WeightedQuickUnionUF(size);
        openState = new int[n + 1][n + 1];
        this.n = n;
        vBottom = size - 1;
    }

    /**
     * // open site (row, col) if it is not open already
     *
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
            uf.union(vTop, getThisSite(row, col));
            if (col == 1) {
//                the left top corner
                openState[row][col] += 3;
                checkRight(row, col);
            } else if (col == n) {
//                the right top corner
                openState[row][col] += 3;
                checkLeft(row, col);
            } else {
//                other in top
                openState[row][col] += 2;
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkBottom(row, col);
        } else if (row == n) {
//          last row
            uf.union(vBottom, getThisSite(row, col));
            if (col == 1) {
//                the left bottom corner
                openState[row][col] += 3;
                checkRight(row, col);
            } else if (col == n) {
//                the right bottom corner
                openState[row][col] += 3;
                checkLeft(row, col);
            } else {
//                other in bottom
                openState[row][col] += 2;
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkTop(row, col);
        } else {
            if (col == 1) {
//                the left col
                openState[row][col] += 2;
                checkRight(row, col);
            } else if (col == n) {
//                the right col
                openState[row][col] += 2;
                checkLeft(row, col);
            } else {
//                other in bottom
                openState[row][col] += 1;
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkTop(row, col);
            checkBottom(row, col);
        }
    }

    private void checkTop(int row, int col) {
        if (isOpen(row - 1, col)) {
            uf.union(getThisSite(row, col), getTopSite(row, col));
            openState[row][col] += 1;
            openState[row - 1][col] += 1;
        }
    }

    private void checkBottom(int row, int col) {
        if (isOpen(row + 1, col)) {
            int thisSite = getThisSite(row, col);
            int bottomSite = getBottomSite(row, col);
            uf.union(thisSite, bottomSite);
            openState[row][col] += 1;
            openState[row + 1][col] += 1;
        }
    }

    private int getThisSite(int row, int col) {
        return (n + 1) * row + col;
    }

    private int getTopSite(int row, int col) {
        return getThisSite(row, col) - (n + 1);
    }
    private int getRightSite(int row, int col) {
        int thisSite = getThisSite(row, col);
        return thisSite + 1;
    }

    private int getBottomSite(int row, int col) {
        return getThisSite(row, col) + (n + 1);
    }

    private int getLeftSite(int row, int col) {
        return getThisSite(row, col) - 1;
    }

    private void checkRight(int row, int col) {
        if (isOpen(row, col + 1)) {
            uf.union(getThisSite(row, col), getRightSite(row, col));
            openState[row][col] += 1;
            openState[row][col + 1] += 1;
        }
    }

    private void checkLeft(int row, int col) {
        if (isOpen(row, col - 1)) {
            uf.union(getThisSite(row, col), getLeftSite(row, col));
            openState[row][col] += 1;
            openState[row][col - 1] += 1;
        }
    }

    /**
     * is site (row, col) open?
     *
     * @param row row in grid
     * @param col column in grid
     * @return true if the site if open
     */
    public boolean isOpen(int row, int col) {
        return openState[row][col] > 0;
    }

    /**
     * is site (row, col) full?
     *
     * @param row row in grid
     * @param col column in grid
     * @return true if the site is full
     */
    public boolean isFull(int row, int col) {
        return openState[row][col] == 5;
    }

    /**
     * number of open sites
     *
     * @return number of open sites
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * // does the system percolate?
     *
     * @return true percolate, false otherwise
     */
    public boolean percolates() {
//        set the 0 as the virtual-top
//        size -1 as the virtual-bottom
        return uf.connected(vTop, vBottom);
    }

//    public void string() {
//        int index = 0;
//        for (int i = 0; i < n + 2; i++) {
//            for (int j = 0; j < n + 1; j++) {
////                System.out.print(openState[i][j]);
//                System.out.printf("% 4d", index);
//                index++;
//            }
//            System.out.println();
//        }
//       System.out.println(uf.connected(vTop, 12));
//       System.out.println(uf.connected(23, 12));
//       System.out.println(uf.connected(23, 34));
//       System.out.println(uf.connected(45, 34));
//       System.out.println(uf.connected(45, 56));
//       System.out.println(uf.connected(67, 56));
//       System.out.println(uf.connected(67, 78));
//       System.out.println(uf.connected(89, 78));
//       System.out.println(uf.connected(89, 100));
//       System.out.println(uf.connected(111, 100));
//       System.out.println(uf.connected(111, vBottom));
//       System.out.println(uf.connected(vTop, vBottom));
//    }
    public static void main(String[] args) {

    }
}
