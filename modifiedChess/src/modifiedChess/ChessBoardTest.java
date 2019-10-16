package modifiedChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ChessBoardTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}



	@Test
	void testInitialize() throws IllegalPositionException {
		ChessBoard board = new ChessBoard();
		board.initialize();
		
		assert(board.getPiece("a8") instanceof Rook);
		assert(board.getPiece("b8") instanceof Knight);
		assert(board.getPiece("c8") instanceof Bishop);
		assert(board.getPiece("d8") instanceof Queen);
		assert(board.getPiece("e8") instanceof King);
		assert(board.getPiece("f8") instanceof Bishop);
		assert(board.getPiece("g8") instanceof Knight);
		assert(board.getPiece("h8") instanceof Rook);
		
		assert(board.getPiece("a1") instanceof Rook);
		assert(board.getPiece("b1") instanceof Knight);
		assert(board.getPiece("c1") instanceof Bishop);
		assert(board.getPiece("d1") instanceof Queen);
		assert(board.getPiece("e1") instanceof King);
		assert(board.getPiece("f1") instanceof Bishop);
		assert(board.getPiece("g1") instanceof Knight);
		assert(board.getPiece("h1") instanceof Rook);
		assertThrows(IllegalPositionException.class, () -> {
		      board.getPiece("a9");
		    });
		
		
	}


	@Test
	void testPlacePiece() {
		ChessBoard board = new ChessBoard();
		board.initialize();
		assertEquals(board.placePiece(new Rook(board, ChessPiece.Color.Black), "a9"), false);
		
	}

}
