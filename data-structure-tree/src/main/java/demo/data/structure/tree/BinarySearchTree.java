package demo.data.structure.tree;

import lombok.Data;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

//@Data
public class BinarySearchTree<T extends Comparable<T>> {


    private Node root;

    public BinarySearchTree(T value) {
        root = new Node(value);
    }
    public BinarySearchTree() {

    }
    public void insert(T value) {
        insert_node(value, root);
    }

    public void insert_node(T value, Node parent) {
        if (parent == null) {
            root = new Node(value);
            return;
        }
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

    private T minValue(Node p) {
        T v = p.value;
        while (p.left != null) {
            v = p.value;
            p = p.left;
        }
        return v;
    }
    public boolean contains(T value) {
        return find(value).isPresent();
    }

    public void remove(T value) {
        remove_node(value, root);
    }

    private Node remove_node(T value, Node parent) {
        if (parent == null) return parent;
        if (value.compareTo(parent.value) < 0) {
           parent.left = remove_node(value, parent.left);
        } else if (value.compareTo(parent.value) > 0) {
            parent.right = remove_node(value, parent.right);
        } else {
            if (parent.left == null) {
                return parent.right;
            } else if (parent.right == null) {
                return parent.left;
            }
            parent.value = minValue(parent.right);
            parent.right = remove_node(parent.value, parent.right);
        }
        return parent;
    }

    public void forEach(Consumer<T> hander) {
        inorderRec(root, hander);
    }

    void inorderRec(Node root, Consumer<T> hander)
    {
        if (root != null)
        {
            inorderRec(root.left, hander);
            hander.accept(root.value);
            inorderRec(root.right, hander);
        }
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
