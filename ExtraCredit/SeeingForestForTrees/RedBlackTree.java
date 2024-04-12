package ExtraCredit.SeeingForestForTrees;

import java.util.LinkedList;
import java.util.List;

public class RedBlackTree<E extends Comparable<E>> {
    private class Node {
        E val;
        Node left;
        Node right;
        Node parent;
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

    private Node rotateLeft(Node n) {
        Node parent = n.parent;
        Node pivot = n.right;
        n.right = pivot.left;
        if (pivot.left != null) pivot.left.parent = n;
        pivot.left = n;
        n.parent = pivot;
        if (parent == null) {
            root = pivot;
        } else {
            if (n == parent.left) parent.left = pivot;
            else parent.right = pivot;
        }
        return pivot;
    }

    private Node rotateRight(Node n) {
        Node parent = n.parent;
        Node pivot = n.left;
        n.left = pivot.right;
        if (pivot.right != null) pivot.right.parent = n;
        pivot.right = n;
        n.parent = pivot;
        if (parent == null) {
            root = pivot;
        } else {
            if (n == parent.left) parent.left = pivot;
            else parent.right = pivot;
        }
        return pivot;
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
                    current.left.parent = current;
                    rebalanceInsert(current.left);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(element, true);
                    current.right.parent = current;
                    rebalanceInsert(current.right);
                    return;
                }
                current = current.right;
            }
        }
    }
    
    private void rebalanceInsert(Node current) {
        if (!current.parent.color) return;
        Node grandparent = current.parent.parent;
        Node uncle = (current.parent == grandparent.left) ? grandparent.right : grandparent.left;

        if (uncle != null && uncle.color) {
            uncle.color = false;
            current.parent.color = false;
            if (grandparent != root) {
                grandparent.color = true;
                rebalanceInsert(grandparent);
            }
            return;
        }

        if (grandparent.left != null && current == grandparent.left.left) { // Case 1
            rotateRight(grandparent);
            boolean temp = grandparent.color;
            grandparent.color = current.parent.color;
            current.parent.color = temp;
        } else if (grandparent.left != null && current == grandparent.left.right) { // Case 2
            rotateLeft(current.parent);
            rotateRight(grandparent);
            boolean temp = grandparent.color;
            grandparent.color = current.color;
            current.color = temp;
        } else if (grandparent.right != null && current == grandparent.right.right) { // Case 3
            rotateLeft(grandparent);
            boolean temp = grandparent.color;
            grandparent.color = current.parent.color;
            current.parent.color = temp;
        } else { // Case 4
            rotateRight(current.parent);
            rotateLeft(grandparent);
            boolean temp = grandparent.color;
            grandparent.color = current.color;
            current.color = temp;
        }
    }

    public boolean delete(E element) {
        if (isEmpty()) {
            return false;
        }
        Node current = root;

        while (current != null) {
            if (element.compareTo(current.val) < 0) {
                current = current.left;
            } else if (element.compareTo(current.val) > 0) {
                current = current.right;
            } else {
                // Delete node if less than 2 children
                if (lessThan2Nodes(current)) return true;
                
                // Swap value node value with successor
                Node successor = current.right;
                while(successor.left != null) {
                    successor = successor.left;
                }
                current.val = successor.val;

                // Deleted successor node
                return lessThan2Nodes(successor);
            }
        }
        return false;
    }

    private boolean lessThan2Nodes(Node current) {
        if (current.left == null && current.right == null) {// Leaf node
            if (current == root) {
                root = null;
            } else if (current.color) { // Node is red
                if (current == current.parent.left) current.parent.left = null;
                else current.parent.right = null;
            } else { // Non-root black node

            }
            return true;
        }

        if (current.right == null) { // Only left child
            if (current == root) {
                root = current.left;
            } else {
                if (current == current.parent.left) current.parent.left = current.left;
                else current.parent.right = current.left;
            }
            if (current.left != null) {
                current.left.parent = current.parent;
                current.left.color = false; //Recolor black
            }   
            return true;
        }

        if (current.left == null) { // Only right child
            if (current == root) {
                root = current.right;
            } else {
                if (current == current.parent.left) current.parent.left = current.right;
                else current.parent.right = current.right;
            }
            if (current.right != null) {
                current.right.parent = current.parent;
                current.right.color = false; //Recolor black
            }   
            return true;
        }
        return false;
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
