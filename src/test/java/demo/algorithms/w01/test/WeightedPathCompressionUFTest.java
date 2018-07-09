package demo.algorithms.w01.test;

import demo.algorithms.w01.WeightedPathCompressionUF;
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
