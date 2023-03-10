package model;

public class ScoreTree {
	private Node right;
	private Node left;

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node aRight) {
		this.right = aRight;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node aLeft) {
		this.left = aLeft;
	}

	public void sort() {
		throw new UnsupportedOperationException();
	}

	public Node deleteAll() {
		throw new UnsupportedOperationException();
	}
}