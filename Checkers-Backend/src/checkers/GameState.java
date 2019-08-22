package checkers;

public class GameState {

	// Constructor
	public GameState(Board board) {}
	
	// return color of current player
	public CheckersColor getCurrentPlayerColor() {}
	
	// return list of legal moves of current player in current situation
	public MovesCollection getLegalMovesCollection() {}
	
	//
	public void applyMove(Move move) {}
	
	//
	public boolean isGameOver() {}
	
	//
	public CheckersColor getWinnerColor() {}
	
	//
	public MovesCollection getJumpMoves(CheckersColor color) {}
	
	//
	public MovesCollection getSimpleMoves(CheckersColor color) {}
}
