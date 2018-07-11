/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  main
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public Permutation() {

    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        RandomizedQueue<String> q = new RandomizedQueue<>();
        for (int i = 1; i < args.length; i++) {
            q.enqueue(StdIn.readString());
        }
        for (int i = 0; i < n; i++) {
            StdOut.println(q.dequeue());
        }
    }

}
