package Utilities;

public class Player {
	final private Symbol symbol;
	final private String name;
	
	public Player(final String name,final Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	public String getName() {
		return this.name;
	}
}
