import java.util.Arrays;

/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P04
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Board in 8puzzle
 *  Performance requirements.
 *  Your implementation should support all Board methods in
 *  time proportional to n2 (or better) in the worst case.
 *
 *  Corner cases.
 *  You may assume that the constructor receives an n-by-n array containing
 *  the n2 integers between 0 and n2 − 1, where 0 represents the blank square.
 ******************************************************************************/
public class Board {

    private final int n;
    private final int[][] tiles;
    private final int hamming;
    private final int manhattan;
    private int bi;
    private int bj;
    /**
     * construct a board from an n-by-n array of blocks
     *
     * @param blocks board blocks
     */
    public Board(int[][] blocks) {
        if (blocks == null || blocks.length < 2 || blocks.length >= 128) {
            throw new IllegalArgumentException();
        }
        n = blocks.length;
        tiles = blocks;
        int h = 0;
        int m = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j + 1;
                int x = tiles[i][j];
                if (x == 0) {
                    bi = i;
                    bj = j;
                    continue;
                }
//                x is not in its position
                if (x != index) {
                    h++;
//                find x position

                    int r = x % n;
                    int xi;
                    int xj;
                    if (r == 0) {
                        xi = x / n  - 1;
                        xj = n - 1;
                    } else {
                        xi = x / n;
                        xj = r - 1;
                    }
                    m += Math.abs(xj - j) + Math.abs(xi - i);
                }
            }
        }
        hamming = h;
        manhattan = m;
    }

    /**
     * @return board dimension n
     */
    // (where blocks[i][j] = block in row i, column j)
    public int dimension() {
        return n;
    }

    /**
     * @return number of blocks out of place
     */
    public int hamming() {
        return hamming;
    }

    /**
     * @return sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {
        return manhattan;
    }

    /**
     * is this board the goal board?
     *
     * @return true if it is goal board
     */
    public boolean isGoal() {
        return hamming == 0;
    }

    /**
     * @return a board that is obtained by exchanging any pair of blocks
     */
    public Board twin() {
        return null;
    }

    /**
     * does this board equal y?
     *
     * @param y another board
     * @return true while the same board
     */
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (y == null || !(y instanceof Board)) {
            return false;
        }
        Board other = (Board) y;
        return Arrays.deepEquals(tiles, other.tiles);
    }

    /**
     * @return all neighboring boards
     */
    public Iterable<Board> neighbors() {
        return null;
    }

    /**
     * @return string representation of this board
     * (in the output format specified below)
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
//        unit tests (not graded)
    }
}
// Hamming priority function. The number of blocks in the wrong position,
// plus the number of moves made so far to get to the search node. Intuitively,
// a search node with a small number of blocks in the wrong position is
// close to the goal, and we prefer a search node
// that have been reached using a small number of moves.

//    Manhattan priority function.
// The sum of the Manhattan distances
// (sum of the vertical and horizontal distance)
// from the blocks to their goal positions,
// plus the number of moves made so far to get to the search node.