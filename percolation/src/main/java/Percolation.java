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
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Programming Assignment 1: Percolation
 * Write a program to estimate the value of the percolation threshold
 * via Monte Carlo simulation.
 */
public class Percolation {

    /**
     * container to hold the grid
     */
    private final WeightedQuickUnionUF uf;

    /**
     * keep the open state of each site
     */
    private boolean[] openState;

    /**
     * number of open site
     */
    private int openSites;

    /**
     * initial of grid
     */
    private final int n;

    /**
     * v top
     */
    private final int vTop;
//
    /**
     * v bottom
     */
    private final int vBottom;
    /**
     * bottom
     */
    private final int[] bottom;

    /**
     * percolates state
     */
    private boolean percolates;
//    /**
//     * only check after reach the top
//     */
//    private boolean percolatesPre;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n ≤ 0 ");
        }
        /*
      size union find data
     */
        int size = n * n + 2;
        uf = new WeightedQuickUnionUF(size);
        openState = new boolean[size - 2];
        bottom = new int[n];
        this.n = n;
        vTop = size - 1;
        vBottom = size - 2;
    }

    /**
     * // open site (row, col) if it is not open already
     *
     * @param row row in grid
     * @param col column in grid
     */
    public void open(int row, int col) {
        validate(row, col);
        int thisSite = getThisSite(row, col);
        if (isOpen(row, col)) {
            return;
        }
        openSites += 1;
        openState[thisSite] = true;

        if (n == 1) {
            return;
        }
        if (row == 1) {
//            first row
            uf.union(vTop, thisSite);
            if (col == 1) {
//                the left top corner
                checkRight(row, col);
            } else if (col == n) {
//                the right top corner
                checkLeft(row, col);
            } else {
//                other in top
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkBottom(row, col);
        } else if (row == n) {
//          last row
//            uf.union(vBottom, );
            bottom[col - 1] = getThisSite(row, col);
            if (col == 1) {
//                the left bottom corner
                checkRight(row, col);
            } else if (col == n) {
//                the right bottom corner
                checkLeft(row, col);
            } else {
//                other in bottom
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkTop(row, col);
        } else {
            if (col == 1) {
//                the left col
                checkRight(row, col);
            } else if (col == n) {
//                the right col
                checkLeft(row, col);
            } else {
//                other in bottom
                checkRight(row, col);
                checkLeft(row, col);
            }
            checkTop(row, col);
            checkBottom(row, col);
        }

        if (!percolates) {
            for (int i = 0; i < n; i++) {
                int site = bottom[i];
                int rowx = n;
                int colx = i + 1;
                if (site > 0 && isFull(rowx, colx)) {
                    percolates = true;
                }
            }
        }
    }

    private void checkTop(int row, int col) {
        if (isOpen(row - 1, col)) {
            uf.union(getThisSite(row, col), getTopSite(row, col));
        }
    }

    private void checkBottom(int row, int col) {
        if (isOpen(row + 1, col)) {
            int thisSite = getThisSite(row, col);
            int bottomSite = getBottomSite(row, col);
            uf.union(thisSite, bottomSite);
        }
    }

    private int getThisSite(int row, int col) {
        return n * (row - 1) + (col - 1);
    }

    private int getTopSite(int row, int col) {
        return getThisSite(row, col) - n;
    }
    private int getRightSite(int row, int col) {
        int thisSite = getThisSite(row, col);
        return thisSite + 1;
    }

    private int getBottomSite(int row, int col) {
        return getThisSite(row, col) + n;
    }

    private int getLeftSite(int row, int col) {
        return getThisSite(row, col) - 1;
    }

    private void checkRight(int row, int col) {
        if (isOpen(row, col + 1)) {
            uf.union(getThisSite(row, col), getRightSite(row, col));
        }
    }

    private void checkLeft(int row, int col) {
        if (isOpen(row, col - 1)) {
            uf.union(getThisSite(row, col), getLeftSite(row, col));
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
        validate(row, col);
        return openState[getThisSite(row, col)];
    }

    /**
     * is site (row, col) full?
     *
     * @param row row in grid
     * @param col column in grid
     * @return true if the site is full
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        if (row == 1) {
            return true;
        }
        int s = getThisSite(row, col);
//        uf.find()
        return uf.connected(s, vTop);
    }

//    private boolean isToTop(int x) {
//        return isToRow(x, 1);
//    }

//    private boolean isToBottom(int x) {
//        return isToRow(x, n);
//    }
//    private boolean isToRow(int x, int row) {
//        boolean isToTop = false;
//        for (int col = 1; col <= n; col++) {
//            if (uf.connected(x, getThisSite(row, col))) {
//                isToTop = true;
//                break;
//            }
//        }
//        return isToTop;
//    }
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
        return percolates;
    }

    private void validate(int row, int col) {
        if (row <= 0 || col <= 0) {
            throw new IllegalArgumentException("row ≤ 0 or col ≤ 0.");
        }
        if (row > n || col > n) {
            throw new IllegalArgumentException("" + Math.max(row, col));
        }
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
//      test in junit
    }
}
