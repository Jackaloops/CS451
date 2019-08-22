package checkers;

public class Checker extends Piece{

	
	// Constructor
	public Checker(CheckersColor color, Position position) {}
	
	//
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
