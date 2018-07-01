package demo.algorithms.uf.test;

import com.sun.istack.internal.NotNull;
import demo.algorithms.uf.UF;
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
}
