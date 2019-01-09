package demo.data.structure.tree;

import lombok.Data;

@Data
public class BinarySearchTree<T extends Comparable<T>> {

    private T value;

    private BinarySearchTree left;

    private BinarySearchTree right;

    public BinarySearchTree(T node) {
        this.value = node;
    }

    public void insert(T node) {
        if (node.compareTo(value) <= 0) {
            if (left == null) {
                left = new BinarySearchTree(node);
            } else {
                left.insert(node);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTree(node);
            } else {
                right.insert(node);
            }
        }
    }

    public boolean contains(T value) {
        if (this.value.compareTo(value) == 0) {
            return true;
        } else if (this.value.compareTo(value) > 0) {
            if (this.left != null) {
                return this.left.contains(value);
            }
        } else {
            if (this.right != null) {
                return this.right.contains(value);
            }
        }

        return false;
    }
}