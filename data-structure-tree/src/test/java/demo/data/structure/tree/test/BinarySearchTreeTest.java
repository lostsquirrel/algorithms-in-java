package demo.data.structure.tree.test;

import demo.data.structure.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    private int[] insertData = new int[]{50, 76, 21, 4, 32, 100, 64, 52};

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst = initTree();

        Assert.assertEquals(4, bst.getLeft().getLeft().getValue());
        Assert.assertEquals(100, bst.getRight().getRight().getValue());

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
