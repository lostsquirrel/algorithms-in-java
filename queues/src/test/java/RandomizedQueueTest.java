import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RandomizedQueueTest {


    @Test
    public void testIterator() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        for(int i = 0; i < 50; i++) {
            q.enqueue(i);
        }
        for (int x : q) {
            System.out.println(x);
        }
    }

    @Test
    public void testDequeue() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        for(int i = 0; i < 50; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }

    @Test
    public void testSample() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        for(int i = 0; i < 50; i++) {
            q.enqueue(i);
        }
        for(int i = 0; i < 500; i++) {
            q.sample();
            q.size();
        }
    }
    @Test
    public void test() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(37);
        rq.enqueue(47);
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        rq.enqueue(11);
        System.out.println(rq.dequeue());
//        System.out.println(rq.dequeue());
    }

    @Test
    public void testRandom() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(0);
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        int[] x = new int[4];
        for (int i = 0; i < 1000; i++) {
            x[rq.sample()] += 1;
        }

        System.out.println(Arrays.toString(x));
    }

    @Test
    public void testRandomDequeue() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        Map<String, Integer> r = new HashMap<>();
        r.put( "AB", 0);
        r.put( "BA", 0);
        for (int i = 0; i < 12000; i++) {
            rq.enqueue("A");
            rq.enqueue("B");
            String key = String.format("%s%s", rq.dequeue(), rq.dequeue());
            r.put(key, r.get(key) + 1);
        }
        System.out.println(r);
    }
}
