package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	void testLegalMoves() {
		fail("Not yet implemented");
	}



}
