package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ChessPieceTest {
	
	@Test
	void testGetColor() {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		assertEquals(ChessPiece.Color.Black, blackRook.getColor());
	}


	@Test
	void testSetPositionValid() throws IllegalPositionException {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		blackRook.setPosition("a1");
		assertEquals("a1", blackRook.getPosition(), "Test set position with valid position");
		assertEquals(0, blackRook.column );
		assertEquals(0, blackRook.row);
		
	}
	
	@Test
	void testSetPositionValid2() throws IllegalPositionException {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		blackRook.setPosition("h8");
		assertEquals("h8", blackRook.getPosition(), "Test set position with valid position 2");
		assertEquals(7, blackRook.column );
		assertEquals(7, blackRook.row);
		
	}
	
	@Test
	void testSetPositionValid3() throws IllegalPositionException {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		blackRook.setPosition("h1");
		assertEquals("h1", blackRook.getPosition(), "Test set position with valid position 3");
		assertEquals(7, blackRook.column );
		assertEquals(0, blackRook.row);
		
	}
	
	@Test
	void testSetPositionValid4() throws IllegalPositionException {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		blackRook.setPosition("a8");
		assertEquals("a8", blackRook.getPosition(), "Test set position with valid position 4");
		assertEquals(0, blackRook.column );
		assertEquals(7, blackRook.row);
		
	}
	
	@Test
	void testSetPositionInvalid() {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		try {
			blackRook.setPosition("a9");
			assert(false);
		} catch (IllegalPositionException e) {
			assert(true);	
		}
	}
	
	@Test
	void testSetPositionInvalid2() {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		try {
			blackRook.setPosition("i2");
			assert(false);
		} catch (IllegalPositionException e) {
			assert(true);
		}
	}
	
	@Test
	void testSetPositionInvalid3() {
		Rook blackRook = new Rook(new ChessBoard(), ChessPiece.Color.Black);
		try {
			blackRook.setPosition("a94");
			assert(false);
		} catch (IllegalPositionException e) {
			assert(true);
		}
	}
	
	


}
