package demo.algorithms.w02;

public class LinkedStackOfString implements StackOfStrings {

    private Node top = null;

    private int size = 0;

    @Override
    public void push(String item) {
        Node n = new Node(item, top);
        top = n;
        size++;
    }

    @Override
    public String pop() {
        String item = null;
        if (top != null) {
            item = top.item;
            top = top.prev;
            size--;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        Node(String item, Node prev) {
            this.item = item;
            this.prev = prev;
        }
        String item;
        Node prev;
    }
}
