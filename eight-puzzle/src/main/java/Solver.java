import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P04
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *  Corner cases.
 *  The constructor should throw a java.lang.IllegalArgumentException
 *  if passed a null argument.
 *  Your program should work correctly for
 *  arbitrary n-by-n boards (for any 2 ≤ n < 128),
 *  even if it is too slow to solve some of them in a reasonable amount of time.
 ******************************************************************************/

public class Solver {
    /**
     * find a solution to the initial board (using the A* algorithm)
     * @param initial initial board
     */
    public Solver(Board initial){
        if (initial == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * is the initial board solvable?
     * @return
     */
    public boolean isSolvable(){
        return false;
    }

    /**
     *
     * @return min number of moves to solve initial board; -1 if unsolvable
     */
    public int moves(){
        return 0;
    }

    /**
     * @return sequence of boards in a shortest solution; null if unsolvable
     */
    public Iterable<Board> solution(){
        return null;
    }
    public static void main(String[] args){
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}