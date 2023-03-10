package model;

public class PlayerList {
	private Node root;
	private Node tail;

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void addPlayer() {
		throw new UnsupportedOperationException();
	}

	public String getPlayerID() {
		throw new UnsupportedOperationException();
	}

	public Node deleteAll() {
		throw new UnsupportedOperationException();
	}

	public Node getTail() {
		return this.tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
}