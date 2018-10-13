import edu.princeton.cs.algs4.In;

public class TestUtils {

    public static int[][] read2blocks(String file) {
        // create initial board from file
        In in = new In(file);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();

        return blocks;
    }
}
