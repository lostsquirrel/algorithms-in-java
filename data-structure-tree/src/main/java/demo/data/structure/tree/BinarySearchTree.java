package demo.data.structure.tree;

import lombok.Data;

import javax.swing.text.html.Option;
import java.util.Optional;

@Data
public class BinarySearchTree<T extends Comparable<T>> {


    private Node root;
    public BinarySearchTree(T value) {
        root = new Node(value);
    }

    public void insert(T value) {
        insert_node(value, root);
    }

    public void insert_node(T value, Node parent) {
        if (parent.value.compareTo(value) <= 0) {
            if (parent.right == null) {
                parent.right = new Node(value);
            } else {
                insert_node(value, parent.right);
            }
        } else {
            if (parent.left == null) {
                parent.left = new Node(value);
            } else {
                insert_node(value, parent.left);
            }
        }
    }

    public Optional<T> find(T value) {
        return find_node(value, root);
    }

    private Optional<T> find_node(T value, Node parent) {
        Optional<T> opt = Optional.empty();
        if (parent.value.compareTo(value) == 0) {
            opt = Optional.of(value);
            return opt;
        } else if (parent.value.compareTo(value) > 0) {
            if (parent.left != null) {
                return find_node(value, parent.left);
            }
        } else {
            if (parent.right != null) {
                return find_node(value, parent.right);
            }
        }

        return opt;
    }
    public boolean contains(T value) {
        return find(value).isPresent();
    }

    public void remove(T value) {
        remove_node(value, root);
    }

    private boolean remove_node(T value, Node parent) {
        boolean removed = false;

        return removed;
    }

    private class Node {
        Node(T value) {
            this.value = value;
        }
        private T value;

        private Node left;

        private Node right;
    }
}
