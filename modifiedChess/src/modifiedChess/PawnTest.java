package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modifiedChess.ChessPiece.Color;

class PawnTest {

	static Pawn blackPawn;
	static Pawn whitePawn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackPawn = new Pawn(new ChessBoard(), ChessPiece.Color.Black);
		whitePawn = new Pawn(new ChessBoard(), ChessPiece.Color.White);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		String expected = "\u265F";
		String actual = blackPawn.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringWhite() {
		String expected = "\u2659";
		String actual = whitePawn.toString();
		assertEquals(expected, actual);
		
	}

	@Test
	void testLegalMovesWhite1() throws IllegalPositionException {
		//assume pawns in starting locations and check legal move array of a white pawn is @ d2 is d3 d4
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessPiece pawn = board.getPiece("d2");
		assert(pawn instanceof Pawn); //double check
		assert( pawn.getColor() == ChessPiece.Color.White); //double check
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d3");
		expected.add("d4");
		
		
		assertTrue(pawn.legalMoves().containsAll(expected));
		
		
	}
	
	@Test
	void testLegalMovesWhite2() throws IllegalPositionException {
		//place white pawn at d2 and black piece at c3, valid moves for white pawn should be c3 d3 d4
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board,Color.White);
		Queen queen = new Queen(board, Color.Black);
		board.placePiece(pawn, "d2");
		board.placePiece(queen, "c3");
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("c3");
		expected.add("d3");
		expected.add("d4");

		
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == 3);
		
		// add a black piece to e3, expected now is c3 d3 d4 e3
		Rook rook = new Rook(board, Color.Black);
		board.placePiece(rook, "e3");
		expected.add("e3");
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == expected.size());
		
		//change black piece at e3 to white, expected now c3 d3 d4
		Rook rook2 = new Rook(board, Color.White);
		board.placePiece(rook2, "e3");
		expected.remove("e3");
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == expected.size());
		
	}
	
	@Test
	void testLegalMovesWhite3() throws IllegalPositionException {
		//test move with pawn not in starting location. Place white pawn at d3 with no other pieces on board
		// legal moves should be d4
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(pawn, "d3");

		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d4");

		
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == 1);
		
		
	}
	
	@Test
	void testLegalMovesWhite4() throws IllegalPositionException {
		//test move with pawn in starting location. Place white pawn at d2 with black piece at d3 on board
		// legal moves should be empty
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(pawn, "d2");
		Pawn pawn2 = new Pawn(board, ChessPiece.Color.Black);
		board.placePiece(pawn2, "d3");
		
		assert(pawn.legalMoves().isEmpty());

		
		
	}
	
	@Test
	void testLegalMovesWhite5() throws IllegalPositionException {
		//test move with pawn in starting location. Place white pawn at d2 with black piece at d4 on board
		// legal moves should be d3
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(pawn, "d2");
		Pawn pawn2 = new Pawn(board, ChessPiece.Color.Black);
		board.placePiece(pawn2, "d4");
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d3");

		
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == 1);

		
		
	}
	
	@Test
	void testLegalMovesBlack1() throws IllegalPositionException {
		//assume pawns in starting locations and check legal move array of a black pawn @ d7 is d6 d5
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessPiece pawn = board.getPiece("d7");
		assert(pawn instanceof Pawn); //double check
		assert( pawn.getColor() == ChessPiece.Color.Black); //double check
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d6");
		expected.add("d5");
		
		assertTrue(pawn.legalMoves().containsAll(expected));
		
		
	}
	
	@Test
	void testLegalMovesBlack2() throws IllegalPositionException {
		//diagonal move
		ChessBoard board = new ChessBoard();
		board.initialize();
		ChessPiece pawn = board.getPiece("d2");
		assert(pawn instanceof Pawn); //double check
		assert( pawn.getColor() == ChessPiece.Color.Black); //double check
		
		ArrayList<String> expected = new ArrayList<>();
		// TODO
		
		assert(false);
		
		
	}
	
	@Test
	void testLegalMovesBlack3() throws IllegalPositionException {
		//test move with pawn not in starting location. Place black pawn at d6 with no other pieces on board
		// legal moves should be d5
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.Black);
		board.placePiece(pawn, "d6");

		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d5");

		
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == 1);
		
		
	}
	
	@Test
	void testLegalMovesBlack4() throws IllegalPositionException {
		//test move with pawn in starting location. Place black pawn at d7 with white piece at d6 on board
		// legal moves should be empty
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.Black);
		board.placePiece(pawn, "d7");
		Pawn pawn2 = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(pawn2, "d6");
		
		assert(pawn.legalMoves().isEmpty());

		
		
	}
	
	@Test
	void testLegalMovesBlack5() throws IllegalPositionException {
		//test move with pawn in starting location. Place black pawn at d7 with white piece at d5 on board
		// legal moves should be d6
		ChessBoard board = new ChessBoard();
		
		Pawn pawn = new Pawn(board, ChessPiece.Color.Black);
		board.placePiece(pawn, "d7");
		Pawn pawn2 = new Pawn(board, ChessPiece.Color.White);
		board.placePiece(pawn2, "d5");
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("d6");

		
		assert(pawn.legalMoves().containsAll(expected));
		assert(pawn.legalMoves().size() == 1);

		
		
	}



}
