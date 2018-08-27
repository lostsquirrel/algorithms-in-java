package demo.algorithms.ch01.demo.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
    private String[] a; // stack entries
    private int N; // size

    // create an empty stack of capacity cap
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    // add a string
    public void push(String item) {
        a[N++] = item;
    }

    // remove the most recently added string
    public String pop() {
        return a[--N];
    }

    // is the stack empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // number of strings on the stac
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
