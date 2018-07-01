package demo.algorithms.uf.test;

import demo.algorithms.uf.QuickFindUF;
import org.junit.Test;

public class QuickFindUFTest {

    private QuickFindUF uf = new QuickFindUF(10);

    @Test
    public void testComponent1() {
        String unions = "0_5,5_6";
        String conn = String.format("%s,0_6", unions);
        String notConn = "0_1,0_3,2_3";
        UFTester.test(uf, unions, conn, notConn);
    }

    @Test
    public void testComponent2() {
        String unions = "1_2,7_2";
        String conn = String.format("%s,1_7", unions);
        String notConn = "0_1,0_3,2_3";
        UFTester.test(uf, unions, conn, notConn);
    }

    @Test
    public void testComponent3() {
        String unions = "8_3,3_4,4_9";
        String conn = String.format("%s,8_9", unions);
        String notConn = "0_1,0_3,2_3";
        UFTester.test(uf, unions, conn, notConn);
    }
}
