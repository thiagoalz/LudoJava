package net.thiagoalz.ludo;

import java.util.Random;

public class LudoGameEngine {

	long player1pieces[] = { 0, 0, 0, 0 };
	long player2pieces[] = { 0, 0, 0, 0 };
	long player3pieces[] = { 0, 0, 0, 0 };
	long player4pieces[] = { 0, 0, 0, 0 };

	protected short playerTurn = 1;
	short dice = 1;
	
	

	Random random = new Random();

	public String[] getBoard() {
		return null;
	}

	public void rollDice() {
		dice = (short) (random.nextInt(6) + 1);
	}

	protected void setDice(int dice) {
		this.dice = (short) dice;

	}

	public int getDice() {
		return dice;
	}

	public void start() {
		
	}

	public void isMoveValid(int piece) {

	}

	public void move(int piece) {

		// int house_num =
	}

	public void switchPlayer() {
		playerTurn++;
		playerTurn = (playerTurn > 4) ? 1 : playerTurn;
	}

	public Object getNumberOfPlayerPieces(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
