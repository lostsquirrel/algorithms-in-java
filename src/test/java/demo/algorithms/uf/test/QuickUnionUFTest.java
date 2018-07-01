package demo.algorithms.uf.test;

import demo.algorithms.uf.QuickUnionUF;
import org.junit.Test;

public class QuickUnionUFTest {

    @Test
    public void test() {
        QuickUnionUF uf = new QuickUnionUF(10);
        UFTester.testComponent1(uf);
        UFTester.testComponent2(uf);
        UFTester.testComponent3(uf);
    }
}
