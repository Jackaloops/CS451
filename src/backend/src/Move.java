package checkers;

public abstract class Move {

	
	// Constructor
	public Move(Piece piece, Position Destination) {}
	
	//
	public Piece getPiece() {}
	
	//
	Position getDestination() {}
	
	//
	public abstract boolean isJump() {}
	
	//
	@Override
	public boolean equals(Object other) {}
}
