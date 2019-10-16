package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	void testLegalMoves() {
		fail("Not yet implemented");
	}

	@Test
	void testBishop() {
		fail("Not yet implemented");
	}

}
