package it.giobr.jogogourmet;

public class Tree {
    private final Node root;
    private Node current;
    private Node previous;

    public Tree() {
        root = new Node("massa");
        root.setLeft(new Node("Lasanha"));
        root.setRight(new Node("Bolo de Chocolate"));

        reset();
    }

    public void reset() {
        current = root;
        previous = null;
    }

    public boolean goLeft() {
        if (!current.hasLeft()) {
            return false;
        }

        previous = current;
        current = current.getLeft();
        return true;
    }

    public boolean goRight() {
        if (!current.hasRight()) {
            return false;
        }

        previous = current;
        current = current.getRight();
        return true;
    }

    public String getCurrentLabel() {
        return current.getLabel();
    }

    public void add(String type, String food) {
        var typeNode = new Node(type);
        typeNode.setLeft(new Node(food));

        typeNode.setRight(current);

        if (previous.getLeft().equals(current)) {
            previous.setLeft(typeNode);
        } else {
            previous.setRight(typeNode);
        }
    }
}
