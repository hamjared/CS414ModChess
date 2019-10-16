package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KnightTest {
	
	static Knight blackKnight;
	static Knight whiteKnight;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		blackKnight = new Knight(new ChessBoard(), ChessPiece.Color.Black);
		whiteKnight = new Knight(new ChessBoard(), ChessPiece.Color.White);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testToStringBlack() {
		String expected = "\u265E";
		String actual = blackKnight.toString();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringWhite() {
		String expected = "\u2658";
		String actual = whiteKnight.toString();
		assertEquals(expected, actual);
		
	}

	@Test
	void testLegalMoves() {
		fail("Not yet implemented");
	}

	@Test
	void testKnight() {
		fail("Not yet implemented");
	}

}
