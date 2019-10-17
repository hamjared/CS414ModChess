package modifiedChess;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessBoard {

	private ChessPiece[][] board;
	
	ChessBoard(){
		board = new ChessPiece[8][8];
		for( int i = 0 ; i < board.length; i++) 
			Arrays.fill(board[i], null);
		
	}
	
	public void initialize() {
		this.placeRooks();
		this.placeKnights();
		this.placeBishops();
		this.placeQueens();
		this.placeKings();
		this.placePawns();
	}
	
	public ChessPiece getPiece(String position) throws IllegalPositionException{
		this.validatePosition(position);
		int column = position.charAt(0) - 'a';
		int row = position.charAt(1) - '1';
		return board[row][column];
		
	}
	
	private void validatePosition(String position) throws IllegalPositionException {
		if(!position.matches("[a-h][1-8]"))
			throw new IllegalPositionException();
		
	}
	
	private void removePieceFromPosition(String position) throws IllegalPositionException {
		this.validatePosition(position);
		int column = position.charAt(0) - 'a';
		int row = position.charAt(1) - '1';
		board[row][column] = null;
	}
	
	public boolean placePiece(ChessPiece piece, String position) {
		try {
			piece.setPosition(position);
			this.board[piece.row][piece.column] = piece;
			return true;
		} catch (IllegalPositionException e) {
			return false;
		}
		
	}
	
	public void move(String fromPosition, String toPosition) throws IllegalMoveException {
		try {
			ChessPiece piece = this.getPiece(fromPosition);
			ArrayList<String> legalMoves = piece.legalMoves();
			if(legalMoves.contains(toPosition)) {
				this.placePiece(piece, toPosition);
				this.removePieceFromPosition(fromPosition);
			}
			else {
				throw new IllegalMoveException();
			}
		} catch (IllegalPositionException e) {
			// TODO Auto-generated catch block
			throw new IllegalMoveException();
		}
	}
	
	private void placeRooks() {
		Rook blackRook1 = new Rook(this, ChessPiece.Color.Black);
		Rook blackRook2 = new Rook(this, ChessPiece.Color.Black);
		this.placePiece(blackRook1, "a8");
		this.placePiece(blackRook2, "h8");
		
		Rook whiteRook1 = new Rook(this, ChessPiece.Color.White);
		Rook whiteRook2 = new Rook(this, ChessPiece.Color.White);
		this.placePiece(whiteRook1, "a1");
		this.placePiece(whiteRook2, "h1");
	}
	
	private void placeKnights() {
		Knight blackKnight1 = new Knight(this, ChessPiece.Color.Black);
		Knight blackKnight2 = new Knight(this, ChessPiece.Color.Black);
		this.placePiece(blackKnight1, "b8");
		this.placePiece(blackKnight2, "g8");
		
		Knight whiteRook1 = new Knight(this, ChessPiece.Color.White);
		Knight whiteRook2 = new Knight(this, ChessPiece.Color.White);
		this.placePiece(whiteRook1, "b1");
		this.placePiece(whiteRook2, "g1");
	}
	
	private void placeBishops() {
		Bishop blackBishop1 = new Bishop(this, ChessPiece.Color.Black);
		Bishop blackBishop2 = new Bishop(this, ChessPiece.Color.Black);
		this.placePiece(blackBishop1, "c8");
		this.placePiece(blackBishop2, "f8");
		
		Bishop whiteBishop1 = new Bishop(this, ChessPiece.Color.White);
		Bishop whiteBishop2 = new Bishop(this, ChessPiece.Color.White);
		this.placePiece(whiteBishop1, "c1");
		this.placePiece(whiteBishop2, "f1");
	}
	
	private void placeQueens() {
		Queen blackQueen = new Queen(this, ChessPiece.Color.Black);
		this.placePiece(blackQueen, "d8");
		
		Queen whiteQueen = new Queen(this, ChessPiece.Color.White);
		this.placePiece(whiteQueen, "d1");
	}
	
	private void placeKings() {
		King blackKing = new King(this, ChessPiece.Color.Black);
		this.placePiece(blackKing, "e8");
		
		King whiteKing = new King(this, ChessPiece.Color.White);
		this.placePiece(whiteKing, "e1");
	}
	
	private void placePawns() {
		for (int i = 0 ; i < 8; i++) {
			this.placePiece(new Pawn(this, ChessPiece.Color.Black), "" + (char)('a'+i) + 7);
			this.placePiece(new Pawn(this, ChessPiece.Color.White), "" + (char)('a'+i) + 2);
		}
	}
	
	public String toString(){
	    String chess="";
	    String upperLeft = "\u250C";
	    String upperRight = "\u2510";
	    String horizontalLine = "\u2500";
	    String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
	    String verticalLine = "\u2502";
	    String upperT = "\u252C";
	    String bottomLeft = "\u2514";
	    String bottomRight = "\u2518";
	    String bottomT = "\u2534";
	    String plus = "\u253C";
	    String leftT = "\u251C";
	    String rightT = "\u2524";

	    String topLine = upperLeft;
	    for (int i = 0; i<7; i++){
	        topLine += horizontal3 + upperT;
	    }
	    topLine += horizontal3 + upperRight;

	    String bottomLine = bottomLeft;
	    for (int i = 0; i<7; i++){
	        bottomLine += horizontal3 + bottomT;
	    }
	    bottomLine += horizontal3 + bottomRight;
	    chess+=topLine + "\n";

	    for (int row = 7; row >=0; row--){
	        String midLine = "";
	        for (int col = 0; col < 8; col++){
	            if(board[row][col]==null) {
	                midLine += verticalLine + " \u3000 ";
	            } else {midLine += verticalLine + " "+board[row][col]+" ";}
	        }
	        midLine += verticalLine;
	        String midLine2 = leftT;
	        for (int i = 0; i<7; i++){
	            midLine2 += horizontal3 + plus;
	        }
	        midLine2 += horizontal3 + rightT;
	        chess+=midLine+ "\n";
	        if(row>=1)
	            chess+=midLine2+ "\n";
	    }

	    chess+=bottomLine;
	    return chess;
	}
	
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.initialize();
		System.out.println(board);
		try {
			board.move("c2", "c4");
		} catch (IllegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(board);
	}

}
