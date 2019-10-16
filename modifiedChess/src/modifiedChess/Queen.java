package modifiedChess;

import java.util.ArrayList;

public class Queen extends ChessPiece {

	public Queen(ChessBoard board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(super.color == super.color.Black)
			return "\u265B";
		else
			return "\u2655";
	}

	@Override
	public ArrayList<String> legalMoves() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

}
