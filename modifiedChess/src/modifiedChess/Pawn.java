package modifiedChess;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

	public Pawn(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(super.color == super.color.Black)
			return "\u265F";
		else
			return "\u2659";
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		ArrayList<String> legalMovesArray = new ArrayList<>();
		
		this.addForwardMove(legalMovesArray,1);
		this.addDiagonalMove(legalMovesArray);
		
		if ( ((this.row + 1) == 2 && this.color == ChessPiece.Color.White) || 
				((this.row + 1) == 7 && this.color == ChessPiece.Color.Black)) {
			//pawn is in its starting location so it can move two squares ahead. 
			ArrayList<String> garbage = new ArrayList<>();
			if (this.addForwardMove(garbage,1)) {
				this.addForwardMove(legalMovesArray, 2);
				
			}
			
		}
		
		
		
		return legalMovesArray;
	}
	

	
	private void validatePosition(String position) throws IllegalPositionException {
		if(!position.matches("[a-h][1-8]"))
			throw new IllegalPositionException();
		
	}
	
	private String newPositionStringForm(int incrementRow, int incrementColumn) throws IllegalPositionException {
		int newRow = row + incrementRow;
		int newColumn = column + incrementColumn;
		String newPosition = "" + (char)(newColumn + 'a') + (char)(newRow + '1');
		this.validatePosition(newPosition);
		return newPosition;
	}
	
	private boolean addForwardMove(ArrayList<String> legalMovesArray, int numSquares) {
		if (this.color == ChessPiece.Color.Black)
			numSquares = -1 * numSquares;
		
		try {
			if(this.board.getPiece(this.newPositionStringForm(numSquares, 0)) == null ) {
				legalMovesArray.add(this.newPositionStringForm(numSquares, 0));
				return true;
			}
			
		} catch (IllegalPositionException e) {
			
		}
		

		return false;
	}
	
	private void addDiagonalMoves(ArrayList<String> legalMovesArray) {
		
	}
	

}
