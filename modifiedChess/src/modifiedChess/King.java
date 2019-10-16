package modifiedChess;

import java.util.ArrayList;

public class King extends ChessPiece {

	public King(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(super.color == Color.Black)
			return "\u265A";
		else
			return "\u2654";
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		ArrayList<String> legalMovesArray = new ArrayList<>();
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				try {
					String move = this.newPositionStringForm(r, c);
					if (this.validateMove(move)) {
						legalMovesArray.add(move);
					}
				} catch (IllegalPositionException e) {
					//not a valid position on the board, so do nothing
				}
			}
		}
		
		return legalMovesArray;
	}
	
	private boolean validateMove(String newPosition) throws IllegalPositionException {
		//this method checks for pieces of the same color in the new position
			if (this.board.getPiece(newPosition) == null )
				return true;
			if(this.board.getPiece(newPosition).getColor() == this.color)
				return false;
			
			return true;
			
		
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
	
	

}
