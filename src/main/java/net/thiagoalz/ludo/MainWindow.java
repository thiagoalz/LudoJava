package net.thiagoalz.ludo;

import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow {
	public static void main(String[] args) {
		try {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBackground(new Color(Color.TRANSLUCENT));
			frame.setResizable(false);
			frame.setSize(600, 480);
			LudoBoard board = new LudoBoard();
			frame.getContentPane().add(board);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
