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

import java.util.Arrays;

public class Permutation {
    public Permutation() {

    }
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = Integer.parseInt(args[0]);
//        System.out.println(Arrays.toString(args));
        RandomizedQueue<String> q = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
//            System.out.println(item);
            q.enqueue(item);
        }
//        System.out.println("-----------------");
        for (int i = 0; i < n; i++) {
            StdOut.println(q.dequeue());
        }
    }

}
