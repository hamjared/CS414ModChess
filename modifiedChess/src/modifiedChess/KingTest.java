package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KingTest {

	static King blackKing;
	static King whiteKing;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackKing = new King(new ChessBoard(), ChessPiece.Color.Black);
		whiteKing = new King(new ChessBoard(), ChessPiece.Color.White);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		String expected = "\u265A";
		String actual = blackKing.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringWhite() {
		String expected = "\u2654";
		String actual = whiteKing.toString();
		assertEquals(expected, actual);
		
	}

	@Test
	void testLegalMoves() throws IllegalPositionException {
		// Assume white king is at starting location e1 with no other pieces, and check valid moves are d2 e2 f2 d1 f1
		King king = new King( new ChessBoard(), ChessPiece.Color.White);
		king.setPosition("e1");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d2");
		expected.add("e2");
		expected.add("f2");
		expected.add("d1");
		expected.add("f1");
		
		assert(king.legalMoves().containsAll(expected));
		
	}
	
	@Test
	void testLegalMoves2() throws IllegalPositionException {
		// Assume white king is at starting location e1 with all other pieces in starting positions, and check valid moves array is empty
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessPiece king = board.getPiece("e1");
		assert(king instanceof King); //Double check that the piece is actually a King as it should be. 
		assertEquals("e1", king.getPosition()); //Double Check that piece is where the board thought it was
	
		assert(king.legalMoves().isEmpty());
		
	}
	
	@Test
	void testLegalMoves3() throws IllegalPositionException {
		// Assume white king is at  location e2 with no other pieces, and check valid moves are d2 f2 d1 e1 f1 d3 e3 f3
		King king = new King( new ChessBoard(), ChessPiece.Color.White);
		king.setPosition("e2");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d2");
		expected.add("f2");
		expected.add("d1");
		expected.add("e1");
		expected.add("f1");
		expected.add("d3");
		expected.add("e3");
		expected.add("f3");
		
		assert(king.legalMoves().containsAll(expected));
		
	}
	
	@Test
	void testLegalMoves4() throws IllegalPositionException {
		// Assume white king is at location a1 with white piece at a2 and a black piece at b1 -> check valid moves are b2 b1
		ChessBoard board = new ChessBoard();
		
		King whiteKing = new King(board, ChessPiece.Color.White);
		board.placePiece(whiteKing, "a1");
		Pawn whitePawn = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(whitePawn, "a2");
		Knight blackKnight = new Knight(board, ChessPiece.Color.Black);
		board.placePiece(blackKnight, "b1");
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("b2");
		expected.add("b1");
		
		
	
		assert(whiteKing.legalMoves().containsAll(expected));
		
	}




}
