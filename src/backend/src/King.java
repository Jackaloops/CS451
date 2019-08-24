package checkers;

public class King extends Piece{

	
	
	// Constructor
	public King(CheckersColor color, Position position) {}
	
	//
	public King(Piece checker) {}
	
	public boolean inPosition(Position position) {}

	//
	public CheckersColor getColor() {}
	
	//
	public void setPosition(Position position) {}
	
	//
	public Position[] getAdjacentPositions() {}
	
	//
	public Position getAfterJumpPosition(Piece other) {}
	
	//
	public Position getJumpedOverPosition(Position jumpDestination) {}
	
	//
	public boolean isKing() {}
	
	//
	public boolean inRow(int row) {}
	
	//
	@Override
	public boolean equals(Object other) {}
	@Override
	public String toString() {}
}
