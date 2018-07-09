package demo.algorithms.w01.test;

import demo.algorithms.w01.QuickFindUF;
import org.junit.Test;

public class QuickFindUFTest {


    @Test
    public void test() {
        QuickFindUF uf = new QuickFindUF(10);
        UFTester.testComponent1(uf);
        UFTester.testComponent2(uf);
        UFTester.testComponent3(uf);
    }


}
