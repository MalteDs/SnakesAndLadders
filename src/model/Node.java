package model;

public class Node {
	private Node x;
	private Node y;
	private Player player;
	private int id;

	public Node getX() {
		return this.x;
	}

	public void setX(Node x) {
		this.x = x;
	}

	public Node getY() {
		return this.y;
	}

	public void setY(Node y) {
		this.y = y;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player Player) {
		this.player = Player;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerID() {
		throw new UnsupportedOperationException();
	}
}