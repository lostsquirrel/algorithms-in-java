package demo.data.structure.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

@Data
public class BinaryTree<T> {

    private T value;

    private BinaryTree left;

    private BinaryTree right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree<T> insertLeft(T value) {
        BinaryTree t = new BinaryTree(value);
        if (left == null) {
            left = t;
        } else {
            BinaryTree x = left;
            left = t;
            t.setLeft(x);
        }

        return t;
    }

    public BinaryTree<T> insertRight(T value) {
        BinaryTree t = new BinaryTree(value);
        if (right == null) {
            right = t;
        } else {
            BinaryTree x = right;
            right = t;
            t.setRight(x);
        }
        return t;
    }

    public List<T> preOrder() {
        List<T> list = new ArrayList<>();
        preOrderHelper(this, list);
        return list;
    }


    public void preOrderHelper(BinaryTree<T> tree, List<T> res) {
        if (tree != null) {
            res.add(tree.getValue());
            preOrderHelper(tree.getLeft(), res);
            preOrderHelper(tree.getRight(), res);
        }
    }

    public List<T> inOrder() {
        List<T> list = new ArrayList<>();
        inOrderHelper(this, list);
        return list;
    }


    public void inOrderHelper(BinaryTree<T> tree, List<T> res) {
        if (tree != null) {
            inOrderHelper(tree.getLeft(), res);
            res.add(tree.getValue());
            inOrderHelper(tree.getRight(), res);
        }
    }


    public List<T> postOrder() {
        List<T> list = new ArrayList<>();
        postOrderHelper(this, list);
        return list;
    }


    public void postOrderHelper(BinaryTree<T> tree, List<T> res) {
        if (tree != null) {
            postOrderHelper(tree.getLeft(), res);
            postOrderHelper(tree.getRight(), res);
            res.add(tree.getValue());
        }
    }

    public List<T> BSF() {
        List<T> list = new ArrayList<>();
        Queue<BinaryTree<T>> u = new LinkedTransferQueue<>();
        u.add(this);
        while (!u.isEmpty()) {
            BinaryTree<T> x = u.poll();
            list.add(x.getValue());
            if (x.left != null) {
                u.add(x.left);
            }
            if (x.right != null) {
                u.add(x.right);
            }
        }
        return list;
    }


}
