package ExtraCredit.SeeingForestForTrees;

import java.util.LinkedList;
import java.util.List;

public class RedBlackTree<E extends Comparable<E>> {
    private class Node {
        E val;
        Node left;
        Node right;
        boolean color; // red is true, black is false

        Node(E val, boolean color) {
            this.val = val;
            this.color = color;
        }
    }

    private Node root;

    public RedBlackTree() { // Creates an empty red-black tree
        root = null;
    }

    public void insert(E element) { // Approach 1 for duplicates, add as right child
        if (isEmpty()) {
            root = new Node(element, false);
            return;
        }

        Node current = root;
        while (current != null) {
            if (element.compareTo(current.val) < 0) {
                if (current.left == null) {
                    current.left = new Node(element, true);
                    // REBALANCE
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(element, true);
                    // REBALANCE
                    return;
                }
                current = current.right;
            }
        }
    }

    public boolean delete(E element) {
        if (isEmpty()) {
            return false;
        }

        Node deleted, successorParent;
        Node current = root;

        if (current.val == element) {
            if (current.right == null) {
                root = current.left;
                //REBALANCE
                return true;
            }
            successorParent = findSuccessorParent(current);
            if (successorParent == current) {
                root = current.right;
                //REBALANCE
                return true;
            }
            root = successorParent.left;
            successorParent.left = null;
            root.left = current.left;
            root.right = current.right;
            //REBALANCE
            return true;
        }

        while (current != null) {
            if (element.compareTo(current.val) < 0) {
                if (current.left == null) return false;
                if (current.left.val == element) {
                    deleted = current.left;
                    if (deleted.right == null) {
                        current.left = deleted.left;
                        //REBALANCE
                        return true;
                    }
                    successorParent = findSuccessorParent(deleted);
                    if (successorParent == deleted) {
                        current.left = deleted.right;
                        //REBALANCE
                        return true;
                    }
                    current.left = successorParent.left;
                    successorParent.left = null;
                    current.left.left = deleted.left;
                    current.left.right = deleted.right;
                    //REBALANCE
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) return false;
                if (current.right.val == element) {
                    deleted = current.right;
                    if (deleted.right == null) {
                        current.right = deleted.left;
                        //REBALANCE
                        return true;
                    }
                    successorParent = findSuccessorParent(deleted);
                    if (successorParent == deleted) {
                        current.right = deleted.right;
                        //REBALANCE
                        return true;
                    }
                    current.right = successorParent.left;
                    successorParent.left = null;
                    current.right.left = deleted.left;
                    current.right.right = deleted.right;
                    //REBALANCE
                    return true;
                }
                current = current.right;
            }
        }
        return false;
    }

    private Node findSuccessorParent(Node current) {
        if (current.right.left == null) return current;
        current = current.right;
        while(current.left.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean contains(E element) {
        Node current = root;
        while (current != null) {
            if (element.compareTo(current.val) < 0) {
                current = current.left;
            } else if (element.compareTo(current.val) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public List<E> inOrder() {
        List<E> output = new LinkedList<E>();
        inOrderRecurse(root, output);
        return output;
    }

    private void inOrderRecurse(Node current, List<E> output) {
        if (current.left != null) inOrderRecurse(current.left, output);
        output.add(current.val);
        if (current.right != null) inOrderRecurse(current.right, output);
    }

    public List<List<E>> levelOrder() { // From HW10
        if (root == null) return null;
        List<List<E>> output = new LinkedList<List<E>>();
        List<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<E> level = new LinkedList<E>();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.remove(0);
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            output.add(level);
        }
        return output;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.insert(10);
        tree.insert(23);
        tree.insert(15);
        tree.insert(45);
        tree.insert(34);
        tree.delete(23);
        System.out.println(tree.inOrder());
        System.out.println(tree.levelOrder());
        System.out.println(tree.contains(15));
        System.out.println(tree.contains(23));
    }

}
