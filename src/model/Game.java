package model;

import java.util.Random;

public class Game {

	private Board<TileNode> board;
	private Player player;
	private GameObject gameObject;
	private Random rand;
	private ScoreTree<TreeNode> scoreTree;
	private TurnSystem turnSystem;

	public Game(int rows, int columns) {
		board = new Board<TileNode>(rows, columns);
		scoreTree = new ScoreTree<TreeNode>();
		turnSystem = new TurnSystem();
	}

	public String displayBoard() {
		StringBuilder sb = new StringBuilder();

		TileNode currentNode = board.getRoot();
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				sb.append("[ ");
				if (currentNode.hasPlayers()) {
					sb.append(currentNode.getTileNumber());
					sb.append(" ");
					for (Player player : currentNode.getPlayers()) {
						sb.append(player.getSymbol());
						sb.append(" ");
					}
				} else {
					sb.append("  ");
				}
				sb.append("] ");
				currentNode = (TileNode) currentNode.getNext();
			}
			sb.append("\n");
		}

		return sb.toString();
	}



	public void deleteAll() {
	}

	public boolean checkOverlap() {
		return false; // TODO write this method
	}

	public void addPlayer() {
	}

	public void addGameObject() {
	}

	public void deleteGameObject() {
	}

	public void deletePlayer() {
	}

	public void movePlayer(int n) {
	}

	public int throwDice() {
		return rand.nextInt(6) + 1;
	}
}

