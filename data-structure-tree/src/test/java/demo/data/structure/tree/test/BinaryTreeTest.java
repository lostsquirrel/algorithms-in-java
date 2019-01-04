package demo.data.structure.tree.test;

import demo.data.structure.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeTest {


    public static final String SAMPLE1_PRE_ORDER = "1234567";
    public static final String SAMPLE1_IN_ORDER = "3241657";
    public static final String SAMPLE1_POST_ORDER = "3426751";
    public static final String SAMPLE1_BSF = "1253467";

    @Test
    public void testConstructor() {
        BinaryTree<Integer> bt = new BinaryTree<>(1);
        Assert.assertTrue(1 == bt.getValue());
        Assert.assertNull(bt.getLeft());
        Assert.assertNull(bt.getRight());
    }

    @Test
    public void testInsertLeftEmpty() {
        BinaryTree<String> a = new BinaryTree<>("a");
        a.insertLeft("b");
        Assert.assertEquals(a.getLeft().getValue(), "b");
    }

    @Test
    public void testInsertLeftNotEmpty() {
        BinaryTree<String> a = new BinaryTree<>("a");
        a.insertLeft("c");
        a.insertLeft("b");
        Assert.assertEquals(a.getLeft().getValue(), "b");
        Assert.assertEquals(a.getLeft().getLeft().getValue(), "c");
    }

    @Test
    public void testInsertRightEmpty() {
        BinaryTree<String> a = new BinaryTree<>("a");
        a.insertRight("b");
        Assert.assertEquals(a.getLeft().getValue(), "b");
    }

    @Test
    public void testInsertRightNotEmpty() {
        BinaryTree<String> a = new BinaryTree<>("a");
        a.insertRight("c");
        a.insertRight("b");
        Assert.assertEquals(a.getRight().getValue(), "b");
        Assert.assertEquals(a.getRight().getRight().getValue(), "c");
    }

    @Test
    public void testInsertRightAndLeft() {
        BinaryTree<String> a = new BinaryTree<>("a");
        a.insertLeft("b");
        a.getLeft().insertRight("d");

        a.insertRight("c");
        a.getRight().insertLeft("e");
        a.getRight().insertRight("f");

        Assert.assertEquals(a.getLeft().getRight().getValue(), "d");
        Assert.assertEquals(a.getRight().getRight().getValue(), "f");
    }

    @Test
    public void testPreOrder() {
        List<Integer> res = sample1().preOrder();
        String s = joinAsString(res);
        Assert.assertEquals(s, SAMPLE1_PRE_ORDER);
    }

    @Test
    public void testInOrder() {
        List<Integer> res = sample1().inOrder();
        String s = joinAsString(res);
        Assert.assertEquals(SAMPLE1_IN_ORDER, s);
    }

    private String joinAsString(List<Integer> res) {
        return res.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    @Test
    public void testPostOrder() {
        List<Integer> res = sample1().postOrder();
        String s = joinAsString(res);
        Assert.assertEquals(SAMPLE1_POST_ORDER, s);
    }

    @Test
    public void testBSF() {
        List<Integer> res = sample1().BSF();
        Assert.assertEquals(SAMPLE1_BSF, joinAsString(res));
    }


    private BinaryTree<Integer> sample1() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.insertLeft(2).insertLeft(3);
        tree.getLeft().insertRight(4);


        tree.insertRight(5).insertLeft(6);
        tree.getRight().insertRight(7);
        return tree;
    }
}
