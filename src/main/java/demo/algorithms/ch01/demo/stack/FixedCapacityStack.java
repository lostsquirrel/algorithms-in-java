package demo.algorithms.ch01.demo.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {

    private Item[] a; // stack entries
    private int N; // size

    //create an empty stack of capacity cap
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    //add an item
    public void push(Item item) {
        a[N++] = item;
    }

    //remove the most recently added item
    public Item pop() {
        return a[--N];
    }

    //is the stack empty?
    public boolean isEmpty() {
        return N == 0;
    }

    //number of items on the stack
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
