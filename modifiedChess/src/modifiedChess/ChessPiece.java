package modifiedChess;

import java.util.ArrayList;


public abstract class ChessPiece {
	public enum Color { White, Black};
	protected ChessBoard board = null;
	protected int row;
	protected int column;
	protected Color color;
	
	ChessPiece(ChessBoard board, Color color){
		this.board = board;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getPosition() {
		return "" + (char)(column + 'a') + (char)(row + '1');
		
	}
	
	public void setPosition(String position) throws IllegalPositionException{
		this.validatePosition(position);
		column = position.charAt(0) - 'a';
		row = position.charAt(1) - '1';
	
	}
	
	

	
	private void validatePosition(String position) throws IllegalPositionException {
		if(!position.matches("[a-h][1-8]"))
			throw new IllegalPositionException();
		
	}
	

	abstract public String toString();
	
	abstract public ArrayList<String> legalMoves();

}
