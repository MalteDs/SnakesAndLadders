package model;

public class Player {
	private char id;
	private int pos = 1;

	public Player(char id) {
		throw new UnsupportedOperationException();
	}

	public char getID() {
		throw new UnsupportedOperationException();
	}

	public void setID(char id) {
		throw new UnsupportedOperationException();
	}

	public int getPos() {
		return this.pos;
	}

	public void setPos(int aPos) {
		this.pos = aPos;
	}
}