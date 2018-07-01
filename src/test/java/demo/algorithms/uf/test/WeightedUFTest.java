package demo.algorithms.uf.test;

import demo.algorithms.uf.QuickUnionUF;
import demo.algorithms.uf.WeightedUF;
import org.junit.Test;

public class WeightedUFTest {

    @Test
    public void test() {
        WeightedUF uf = new WeightedUF(10);
        UFTester.testComponent1(uf);
        UFTester.testComponent2(uf);
        UFTester.testComponent3(uf);
    }
}
