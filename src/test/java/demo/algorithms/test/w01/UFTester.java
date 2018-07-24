package demo.algorithms.test.w01;

import demo.algorithms.w01.UF;
import org.junit.Assert;

public class UFTester {

    public static void test(UF target, String union, String conn, String notConn) {
        for (int[] caze : parse(union)) {
            target.union(caze[0], caze[1]);
        }
        for (int[] caze : parse(conn)) {
            Assert.assertTrue(target.connected(caze[0], caze[1]));
        }
        for (int[] caze : parse(notConn)) {
            Assert.assertFalse(target.connected(caze[0], caze[1]));
        }
    }

    private static int[][] parse(String source) {
        String[] _source = source.split(",");
        int[][] cs = new int[_source.length][];
        for (int i = 0; i < _source.length; i++) {
            String[] item = _source[i].split("_");
            cs[i] = new int[]{Integer.parseInt(item[0]), Integer.parseInt(item[1])};
        }
        return cs;
    }

    public static void testComponent1(UF target) {
        String unions = "0_5,5_6";
        String conn = String.format("%s,0_6", unions);
        String notConn = "0_1,0_3,2_3";
        test(target, unions, conn, notConn);
    }

    public static void testComponent2(UF target) {
        String unions = "1_2,7_2";
        String conn = String.format("%s,1_7", unions);
        String notConn = "0_1,0_3,2_3";
        test(target, unions, conn, notConn);
    }

    public static void testComponent3(UF target) {
        String unions = "8_3,3_4,4_9";
        String conn = String.format("%s,8_9", unions);
        String notConn = "0_1,0_3,2_3";
        test(target, unions, conn, notConn);
    }
}
