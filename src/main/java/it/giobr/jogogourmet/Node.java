package it.giobr.jogogourmet;

public class Node {
    private final String label;

    private Node left;

    private Node right;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
