package checkers;

/**
 * This class represents a location on the board of a single cell.
 * Every location(cell) is represented by a row and a column on the board.
 *
 * @author Ilanit Izrailov
 * @version 1
 */

public abstract class Piece {

	// Constructor
	public Piece(CheckersColor color, Position position) {}

	public boolean inPosition(Position position) {}

	// Return color of piece
	public CheckersColor getColor() {}

	//
	public void setPosition(Position position) {}
	
	//
	public abstract Position[] getAdjacentPositions() {}
	
	//
	public Position getAfterJumpPosition(Piece other) {}
	
	//
	public Position getJumpedOverPosition(Position jumpDestination) {}
	
	//
	public abstract boolean isKing() {}
	
	//
	public boolean inRow(int row) {}
	


}
