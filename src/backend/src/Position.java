package checkers;

public class Position {

	protected int row;
	protected int col;

	// Constructor 
	public Position(int column, int row) {
		this.col = column;
		this.row = row;
	}

	// Copy data constructor
	public Position(Position other) {
		this.col = other.col;
		this.row = other.row;
	}
	
	public int getColumn() {
		return col;}
	
	public int getRow() {
		return row;}
	
	public Position[] getAdjacentPositions(int deltaRow) {
		return null;}
	
	public Position getJumpPosition(Position adjacentPosition) {
		return adjacentPosition;}
	
	public Position getAdjacentPosition(Position jumpPosition) {
		return jumpPosition;}
	
	@Override
	public Boolean equals() {}
	@Override
	public String toString() {}
}
