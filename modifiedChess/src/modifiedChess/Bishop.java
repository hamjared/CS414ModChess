package modifiedChess;

import java.util.ArrayList;



public class Bishop extends ChessPiece {
	
	private enum Direction {UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT};

	public Bishop(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(super.color == super.color.Black)
			return "\u265D";
		else
			return "\u2657";
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		ArrayList<String> legalMovesArray = new ArrayList<>();
		
		this.move(legalMovesArray, Direction.UPLEFT);
		this.move(legalMovesArray, Direction.UPRIGHT);
		this.move(legalMovesArray, Direction.DOWNLEFT);
		this.move(legalMovesArray, Direction.DOWNRIGHT);
		
		return legalMovesArray;
	}
	
	private void move(ArrayList<String> legalMoveArray, Direction direction) {
		int rowIncrement = 0;
		int rowChange = 0;
		int colIncrement = 0;
		int colChange = 0;
		
		switch (direction) {
		case UPLEFT:
			rowIncrement = 1;
			rowChange = 1;
			colIncrement = -1;
			colChange = -1;
			break;
			
		case DOWNLEFT:
			rowIncrement = -1;
			rowChange = -1;
			colIncrement = -1;
			colChange = -1;
			break;
		case UPRIGHT:
			rowIncrement = 1;
			rowChange = 1;
			colIncrement = 1;
			colChange = 1;
			break;
		case DOWNRIGHT:
			rowIncrement = -1;
			rowChange = -1;
			colIncrement = 1;
			colChange = 1;
			break;
		}
		
		
		while(true) {
			try {
				String newPosition = this.newPositionStringForm(rowIncrement, colIncrement);
				if (this.board.getPiece(newPosition) != null) {
					if(this.checkCapture(newPosition)) {
						legalMoveArray.add(newPosition);
					}
					break;
				}
				legalMoveArray.add(newPosition);
			} catch (IllegalPositionException e) {
				// TODO Auto-generated catch block
				break;
			}
			rowIncrement += rowChange;
			colIncrement += colChange;
		}
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
	
	private boolean checkCapture(String newPosition) throws IllegalPositionException {
		return this.board.getPiece(newPosition).getColor() != this.getColor();
	}

}
