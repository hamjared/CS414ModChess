package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modifiedChess.ChessPiece.Color;

class BishopTest {
	
	static Bishop blackBishop;
	static Bishop whiteBishop;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackBishop = new Bishop(new ChessBoard(), ChessPiece.Color.Black);
		whiteBishop = new Bishop(new ChessBoard(), ChessPiece.Color.White);
	}
	


	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		
		String expected = "\u265D";
		String actual = blackBishop.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	void testToStringWhite() {
		
		String expected = "\u2657";
		String actual = whiteBishop.toString();
		assertEquals(expected, actual);
	}

	@Test
	void testLegalMoves1() throws IllegalPositionException {
		//check all bishops in board starting state have no valid moves. 
		ChessBoard board = new ChessBoard();
		board.initialize();
		String[] bishopLocations = {"c1", "c8", "f8", "f1"};
		for(int i = 0 ; i < bishopLocations.length; i++) {
			ChessPiece bishop = board.getPiece(bishopLocations[i]);
			assert(bishop instanceof Bishop); //double check
			assert(bishop.legalMoves().isEmpty());
			
		}
		
		
		
	}
	
	@Test
	void testLegalMoves2() throws IllegalPositionException {
		//place white bishop at e4, with no other pieces on board. Expected moves are:
		// d5 c6 b7 a8 f3 g2 h1 d3 c2 b1 f5 g6 h7
		ChessBoard board = new ChessBoard();
		Bishop bishop = new Bishop(board, Color.White);
		board.placePiece(bishop, "e4");
		String[] expectedArray = {"d5","c6","b7","a8","f3", "g2", "h1", "d3", "c2", "b1", "f5", "g6", "h7"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assertTrue(bishop.legalMoves().containsAll(expected));
		assertTrue(bishop.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMoves3() throws IllegalPositionException {
		//place black bishop at e4, with no other pieces on board. Expected moves are:
		// d5 c6 b7 a8 f3 g2 h1 d3 c2 b1 f5 g6 h7
		ChessBoard board = new ChessBoard();
		Bishop bishop = new Bishop(board, Color.Black);
		board.placePiece(bishop, "e4");
		String[] expectedArray = {"d5","c6","b7","a8","f3", "g2", "h1", "d3", "c2", "b1", "f5", "g6", "h7"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assertTrue(bishop.legalMoves().containsAll(expected));
		assertTrue(bishop.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMoves4() throws IllegalPositionException {
		//place black bishop at e4, with white piece at c6, white piece at c2  black piece at g2 . Expected moves are:
		// d5 c6 d3 c2 f3 f5 g6 h7
		ChessBoard board = new ChessBoard();
		Bishop bishop = new Bishop(board, Color.Black);
		board.placePiece(bishop, "e4");
		Knight knight = new Knight(board, Color.White);
		board.placePiece(knight, "c6");
		Queen queen = new Queen(board, Color.White);
		board.placePiece(queen, "c2");
		Rook rook = new Rook(board, Color.Black);
		board.placePiece(rook, "g2");
		
		String[] expectedArray = {"d5","c6","d3","c2","f3", "f5", "g6", "h7"};
		ArrayList<String> expected = new ArrayList<>();
		Collections.addAll(expected, expectedArray);
		
		assertTrue(bishop.legalMoves().containsAll(expected));
		assertTrue(bishop.legalMoves().size() == expected.size());
		
	}
	



}
