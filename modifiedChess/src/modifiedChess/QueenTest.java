package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QueenTest {

	static Queen blackQueen;
	static Queen whiteQueen;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackQueen = new Queen(new ChessBoard(), ChessPiece.Color.Black);
		whiteQueen = new Queen(new ChessBoard(), ChessPiece.Color.White);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		String expected = "\u265B";
		String actual = blackQueen.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringWhite() {
		String expected = "\u2655";
		String actual = whiteQueen.toString();
		assertEquals(expected, actual);
		
	}

	@Test
	void testLegalMoves() throws IllegalPositionException {
		Queen queen = new Queen( new ChessBoard(), ChessPiece.Color.White);
		queen.setPosition("e2");
		
		
		assert(queen.legalMoves().isEmpty());
	}



}
