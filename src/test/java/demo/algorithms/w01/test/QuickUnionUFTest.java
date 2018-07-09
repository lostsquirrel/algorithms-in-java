package demo.algorithms.w01.test;

import demo.algorithms.w01.QuickUnionUF;
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
