package model;

public class Board {

    private Node root;

    public Board() {
        root = new BoardNode();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}