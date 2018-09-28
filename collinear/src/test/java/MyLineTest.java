import org.junit.Assert;
import org.junit.Test;

public class MyLineTest {

    @Test
    public void testSame() {
        MyLine a = new MyLine(new Point(0, 0), new Point(20000, 20000));
        MyLine b = new MyLine(new Point(0, 0), new Point(20000, 20000));
        Assert.assertTrue(a.isSame(b));
    }

    private class MyLine {
        Point head;
        Point tail;
        double slop;

        MyLine(Point head, Point tail) {
            this.head = head;
            this.tail = tail;
            this.slop = head.slopeTo(tail);
        }

        boolean isSame(MyLine other) {
            return head.compareTo(other.head) == 0
                    && tail.compareTo(other.tail) == 0;
        }

        boolean sameSlop(MyLine other) {
            return Double.compare(slop, other.slop) == 0;
        }

        boolean onSameLine(MyLine other) {
            return Double.compare(slop, other.slop) == 0 &&
                    Double.compare(head.slopeTo(other.head),
                            tail.slopeTo(other.tail)) == 0;
        }

        public String toString() {
            return String.format("%s -> %s", head, tail);
        }
    }
}

