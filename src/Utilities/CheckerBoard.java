package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckerBoard {
	
	private Map<Integer,Symbol> checkerBoard;
	private Player currentPlayer;
	private Player opponentPlayer;
	
	public CheckerBoard(Player currentPlayer,Player opponentPlayer) {
		this.currentPlayer = currentPlayer;
		this.opponentPlayer= opponentPlayer;
		checkerBoard = initializeBoard();
	}
	
	public CheckerBoard(String player1,Symbol player1Symbol,String player2,Symbol player2Symbol) {
		this.currentPlayer = new Player(player1,player1Symbol);
		this.opponentPlayer= new Player(player2,player2Symbol);
		checkerBoard  = initializeBoard();
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public Player getOpponentPlayer() {
		return this.opponentPlayer;
	}
	
	@Override
	public String toString() {
		return checkerBoard.toString();
	}
	
	public Map<Integer,Symbol> initializeBoard() {
		Map<Integer,Symbol> tempBoard = new HashMap<>();
		for(int i=0;i<BoardUtils.NUM_TILE;i++) {
			tempBoard.put(i,Symbol.EMPTY);
		}
		return tempBoard;
	}
	
	public boolean isAlreadyDone(int i) {
		return !checkerBoard.get(i).isEmpty();
	}
	
	public CheckerBoard makeMove(int index) {
		CheckerBoard nextBoard = new CheckerBoard(this.opponentPlayer,this.currentPlayer);
		for(int i=0;i<checkerBoard.size();i++) {
			if(i!=index) {
				nextBoard.checkerBoard.put(i,this.checkerBoard.get(i));
			}
		}
		nextBoard.checkerBoard.put(index,this.currentPlayer.getSymbol());
		return nextBoard;
	}
	
	public Symbol getSymbol(int i) {
		return this.checkerBoard.get(i);
	}
	
	public boolean hasWinner() {
		boolean[] crosses = new boolean[BoardUtils.NUM_TILE];
		boolean[] noughts = new boolean[BoardUtils.NUM_TILE];
		for(int i=0;i<BoardUtils.NUM_TILE;i++) {
			if(checkerBoard.get(i).isCross()) {
				crosses[i]=true;
			}
			else if(checkerBoard.get(i).isNought()) {
				noughts[i]=true;
			}
		}
		return winningConfiguration(crosses)||winningConfiguration(noughts);
	}
	
	private boolean winningConfiguration(boolean[] list) {
		if(list[0]&&list[1]&&list[2]) {
			return true;
		}
		if(list[3]&&list[4]&&list[5]) {
			return true;
		}
		if(list[6]&&list[7]&&list[8]) {
			return true;
		}
		if(list[0]&&list[3]&&list[6]) {
			return true;
		}
		if(list[1]&&list[4]&&list[7]) {
			return true;
		}
		if(list[2]&&list[5]&&list[8]) {
			return true;
		}
		if(list[0]&&list[4]&&list[8]) {
			return true;
		}
		if(list[2]&&list[4]&&list[6]) {
			return true;
		}
		return false;
	}
}
