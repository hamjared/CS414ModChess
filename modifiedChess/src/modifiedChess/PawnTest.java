package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	void testLegalMoves() {
		fail("Not yet implemented");
	}

	@Test
	void testPawn() {
		fail("Not yet implemented");
	}

}
