package checkers;

public abstract class Player{

	// Constructor
	public Player(String name, CheckersColor color) {}
	
	public String getName() {}
	
	// return color of player - BLACK/RED
	public CheckersColor getColor() {}
	
	// return the move chosen by the player from a list of possible moves
	public abstract Move getMove(GameState state);

}	