import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

public class DequeTest {

    @Test
    public void testEmpty() {
        Deque<Integer> deque = new Deque<>();
        Assert.assertTrue(deque.isEmpty());
        deque.addFirst(1);
        Assert.assertFalse(deque.isEmpty());
    }

    @Test
    public void testAddFirstRemoveLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
    }

    @Test
    public void testAddLastRemoveFirst() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        deque.addLast(3);
        deque.removeFirst();
    }
    @Test
    public void test() {
        String[] input = "A B C D E F G H I".split(" ");
        Deque<String> deque = new Deque<>();
        for (int i = 0; i < input.length; i++) {
            deque.addLast(input[i]);
        }
        for (int i = 0; i < 3; i++) {
            String x;
            if (StdRandom.bernoulli()) {
                x = deque.removeFirst();
            } else {
                x = deque.removeLast();
            }
            StdOut.println(x);
        }
    }

    @Test
    public void testIterator() {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
        }
        for (Integer x : deque) {
            System.out.println(x);
        }
    }
}
