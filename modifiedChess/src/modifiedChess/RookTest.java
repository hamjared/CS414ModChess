package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modifiedChess.ChessPiece.Color;

class RookTest {

	static Rook blackRook;
	static Rook whiteRook;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		whiteRook = new Rook(new ChessBoard(), ChessPiece.Color.White);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		String expected = "\u265C";
		String actual = blackRook.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringWhite() {
		String expected = "\u2656";
		String actual = whiteRook.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToString() throws IllegalPositionException {
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessPiece rook = board.getPiece("a8");
		assert( rook instanceof Rook);
		assertEquals(ChessPiece.Color.Black, rook.getColor());
		assertEquals("\u265C", rook.toString());
		
	}

	@Test
	void testLegalMoves1() {
		// Place a white rook on a1, with no other pieces on board. Valid moves should be:
		// a2 a3 a4 a5 a6 a7 a8 b1 c1 d1 e1 f1 g1 h1
		
		ChessBoard board = new ChessBoard();
		Rook rook = new Rook(board, Color.White);
		board.placePiece(rook, "a1");
		String[] expectedArray = {"a2","a3","a4","a5","a6", "a7", "a8", "b1", "c1", "d1", "e1", "f1", "g1", "h1"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assert(rook.legalMoves().containsAll(expected));
		assert(rook.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMoves2() {
		// Place a  Black rook on e4, with no other pieces on board. Valid moves should be:
		// e1 e2 e3 e5 e6 e7 e8 a4 b4 c4 d4 f4 g4 h4
		
		ChessBoard board = new ChessBoard();
		Rook rook = new Rook(board, Color.Black);
		board.placePiece(rook, "e4");
		String[] expectedArray = {"e1","e2","e3","e5","e6", "e7", "e8", "a4", "b4", "c4", "d4", "f4", "g4", "h4"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assert(rook.legalMoves().containsAll(expected));
		assert(rook.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMoves3() {
		// Place a Black rook on h8, with no other pieces on board. Valid moves should be:
		// h7 h6 h5 h4 h3 h2 h1 g8 f8 e8 d8 c8 b8 a8
		
		ChessBoard board = new ChessBoard();
		Rook rook = new Rook(board, Color.Black);
		board.placePiece(rook, "h8");
		String[] expectedArray = {"h7","h6","h5","h4","h4", "h2", "h1", "g8", "f8", "e8", "d8", "c8", "b8", "a8"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assert(rook.legalMoves().containsAll(expected));
		assert(rook.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMoves4() throws IllegalPositionException {
		// Initialize chess board -> ensure all rooks have no valid moves
		
		
		ChessBoard board = new ChessBoard();
		board.initialize();
		String[] rookLocations = {"a1", "a8", "h8", "h1"};
		for(int i = 0 ; i < rookLocations.length; i++) {
			ChessPiece rook = board.getPiece(rookLocations[i]);
			assert(rook instanceof Rook); //double check
			assert(rook.legalMoves().isEmpty());
			
		}
		
	}
	
	@Test
	void testLegalMoves5() {
		// Place a Black rook on h6, white piece at e6, white piece on h2, black piece on h8. Valid moves should be:
		// g6 f6 e6 h5 h4 h3 h2 h7
		
		ChessBoard board = new ChessBoard();
		Rook rook = new Rook(board, Color.Black);
		board.placePiece(rook, "h6");
		Pawn pawn = new Pawn(board, Color.White);
		board.placePiece(pawn, "e6");
		Bishop bishop = new Bishop(board, Color.White);
		board.placePiece(bishop, "h2");
		King king = new King(board, Color.Black);
		board.placePiece(king, "h8");
		String[] expectedArray = {"g6","f6","e6","h5","h4", "h3", "h2", "h7"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assert(rook.legalMoves().containsAll(expected));
		assert(rook.legalMoves().size() == expected.size());
		
	}



}
