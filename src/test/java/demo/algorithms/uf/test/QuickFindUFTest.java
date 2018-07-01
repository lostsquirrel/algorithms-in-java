package demo.algorithms.uf.test;

import demo.algorithms.uf.QuickFindUF;
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
