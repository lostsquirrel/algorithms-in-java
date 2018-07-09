package demo.algorithms.w01.test;

import demo.algorithms.w01.WeightedUF;
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
