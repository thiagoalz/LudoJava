package net.thiagoalz.ludo;

import junit.framework.TestCase;


public class LudoGameEngineTest extends TestCase {

	String board[] = new String[87];
	LudoGameEngine game;

	private void initBoart() {

	}

	public void setUp() {
		initBoart();
		game = new LudoGameEngine();
	}

	public void tearDown() {
		board = null;
		game = null;
	}
	
	public void testStartBoard() {
/*		String actualBoard [];
		game.start();
		actualBoard = game.getBoard();
		assertEquals(board, actualBoard);
		
		assertEquals(1, game.playerTurn);
		game.setDice(2); //No piece was free
		assertEquals(0, game.getNumberOfPlayerPieces(1));
		
		assertEquals(2, game.playerTurn);
		game.setDice(1);
		assertEquals(1, game.getNumberOfPlayerPieces(2));
		//TODO: make board change
		assertEquals(board, actualBoard);
		
		assertEquals(3, game.playerTurn);
		game.setDice(6);
		assertEquals(1, game.getNumberOfPlayerPieces(3));
		//TODO: make board change
		assertEquals(board, actualBoard);
		
		assertEquals(4, game.playerTurn);
		game.setDice(3); //No piece was free
		assertEquals(0, game.getNumberOfPlayerPieces(4));
		
		//game.setDice(1);
		*/
	}

}
