package demo.data.structure.tree.test;

import demo.data.structure.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class BinarySearchTreeTest {

    private int[] insertData = new int[]{50, 76, 21, 4, 32, 100, 64, 52};

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst = initTree();

        Assert.assertEquals(4, bst.getLeft().getLeft().getValue());
        Assert.assertEquals(100, bst.getRight().getRight().getValue());

    }

    @Test
    public void testContainTrue() {
        BinarySearchTree<Integer> bst = initTree();
        Arrays.stream(insertData).forEach(x -> Assert.assertTrue(bst.contains(x)));
    }

    @Test
    public void testContainsFalse() {
        BinarySearchTree<Integer> bst = initTree();
        Stream.of(1, 12, 23, 34, 45, 56, 67, 78, 89, 94, 108).forEach(x -> Assert.assertFalse(bst.contains(x)));
    }
    private BinarySearchTree<Integer> initTree() {
        BinarySearchTree<Integer> bst = null;
        for (Integer x : insertData) {
            if (bst == null) {
                bst = new BinarySearchTree<>(x);
            } else {
                bst.insert(x);
            }
        }

        return bst;
    }
}
