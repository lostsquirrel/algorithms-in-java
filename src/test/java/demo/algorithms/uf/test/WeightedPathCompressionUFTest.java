package demo.algorithms.uf.test;

import demo.algorithms.uf.WeightedPathCompressionUF;
import demo.algorithms.uf.WeightedUF;
import org.junit.Test;

public class WeightedPathCompressionUFTest {

    @Test
    public void test() {
        WeightedPathCompressionUF uf = new WeightedPathCompressionUF(10);
        UFTester.testComponent1(uf);
        UFTester.testComponent2(uf);
        UFTester.testComponent3(uf);
    }
}
