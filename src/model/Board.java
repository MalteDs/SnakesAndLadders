package model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Board<T extends Node> implements Iterable<TileNode> {

	private TileNode root;
	private int size;
	private int rows;
	private int columns;

	public Board(int rows, int columns){
		root = new TileNode(0);
		this.rows = rows;
		this.columns = columns;
		size = rows * columns;
		generateBoard(rows, columns);
	}

	@Override
	public Iterator<TileNode> iterator() {
		return new Iterator<TileNode>() {
			private TileNode current = root;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public TileNode next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				TileNode next = current;
				current = (TileNode) current.getNext();
				return next;
			}
		};
	}

	public TileNode getRoot() {
		return this.root;
	}

	public void setRoot(TileNode root) {
		this.root = root;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void generateBoard(int rows, int columns) {
		TileNode current = null;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				TileNode tile = new TileNode(i * columns + j);
				if (root == null) {
					setRoot(tile);
				} else {
					assert current != null;
					current.setNext(tile);
				}
				current = tile;
			}
		}
	}

	public TileNode getTile(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}
		return getTileRecursive(root, index);
	}

	private TileNode getTileRecursive(TileNode currentTile, int index) {
		if (index == 0) {
			return currentTile;
		}
		if(currentTile.getNext() == null){
			return null;
		}
		else{
			return getTileRecursive((TileNode) currentTile.getNext(), index - 1);
		}
	}

	public TileNode searchTileByID(int index, int id){
		TileNode currentTile = getTile(index);

		if(currentTile.getTileNumber() == id){
			return currentTile;
		}
		else if(currentTile.getNext() == null){
			return null;
		}
		else{
			return getTile(index + 1);
		}
	}

	public void addSnakeOrLadder(int start, int end) {
		TileNode startTile = getTile(start);
		TileNode endTile = getTile(end);

		if (startTile == null || endTile == null) {
			throw new IllegalArgumentException("Invalid start or end position");
		}

		if (start < end) {
			endTile.setLadderDestination(startTile);
		} else {
			endTile.setSnakeDestination(startTile);
		}
	}

	public void movePlayer(Player player, int steps) {
		// Move the player forward by the given number of steps
		TileNode current = getTile(0);
		for (int i = 0; i < steps; i++) {
			current = (TileNode) current.getNext();
			if (current == null) {
				// Player has reached the end of the board
				return;
			}
			// Check for Snakes and Ladders and move the player accordingly
			TileNode snakeDest = current.getSnakeDestination();
			TileNode ladderDest = current.getLadderDestination();
			TileNode finalCurrent = current;
			player.setPosition(Objects.requireNonNullElseGet(snakeDest, () -> Objects.requireNonNullElse(ladderDest, finalCurrent)).getTileNumber());
		}
	}


	//TODO refine this method
	private void deleteAll(TileNode node) {
		if (node == null) {
			return;
		}
		deleteAll((TileNode) node.getNext());
		node.setNext(null);
	}