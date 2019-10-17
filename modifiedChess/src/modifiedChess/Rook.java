package modifiedChess;

import java.util.ArrayList;

public class Rook extends ChessPiece {
	
	private enum Direction {Up, Down, Right, Left};

	public Rook(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(super.color == super.color.Black)
			return "\u265C";
		else
			return "\u2656";
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		ArrayList<String> legalMovesArray = new ArrayList<String>();
		this.move(legalMovesArray, Direction.Up);
		this.move(legalMovesArray, Direction.Down);
		this.move(legalMovesArray, Direction.Right);
		this.move(legalMovesArray, Direction.Left);
		
		return legalMovesArray;
	}
	
	private void move(ArrayList<String> legalMoveArray, Direction direction) {
		int rowIncrement = 0;
		int rowChange = 0;
		int colIncrement = 0;
		int colChange = 0;
		
		switch (direction) {
		case Up:
			rowIncrement = 1;
			rowChange = 1;
			break;
			
		case Down:
			rowIncrement = -1;
			rowChange = -1;
			break;
		case Right:
			colIncrement = 1;
			colChange = 1;
			break;
		case Left:
			colIncrement = -1;
			colChange = -1;
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
