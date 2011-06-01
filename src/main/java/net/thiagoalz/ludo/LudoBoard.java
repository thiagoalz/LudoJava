package net.thiagoalz.ludo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LudoBoard extends Canvas implements MouseListener, Runnable {
	private static final long serialVersionUID = -5842140465609340872L;

	private BufferedImage board;

	private BufferedImage bluePiece;

	Thread animation;

	int x = 0, y = 0;

	public LudoBoard() {
		try {
			board = ImageIO.read(new File(
					"src/main/resources/net/thiagoalz/ludo/ludoboard.png"));
			bluePiece = ImageIO.read(new File(
					"src/main/resources/net/thiagoalz/ludo/bluePiece.png"));
			// board =
			// ImageIO.read(this.getClass().getResourceAsStream(TABLEBOARD));
		} catch (IOException e) {
			try {
				board = ImageIO.read(new File(
						"src/main/resources/net/thiagoalz/ludo/ludoboard.png"));

			} catch (IOException e1) {
				File file = new File(
						"/home/guto/turnover/ludo/src/main/resources/net/thiagoalz/ludo/ludoboard.png");
				System.out.println(file.getAbsolutePath() + "asdfa");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		addMouseListener(this);
	}

	BufferStrategy buffer;

	public void addNotify() {
		super.addNotify();
		this.createBufferStrategy(3);
		buffer = this.getBufferStrategy();
	}

	public void start() {
		animation = new Thread(this);
		animation.start();
	}

	public void drawHouse(Graphics g, Square square) {
		g.drawRect(square.screenX, square.screenY, Square.HOUSE_SIZE,
				Square.HOUSE_SIZE);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(board, 0, 0, null);
		graphics.setColor(new Color(120, 0, 0));
		for (Square s : Square.values())
			drawHouse(graphics, s);
	}

	@Override
	public void update(Graphics graphics) {
		BufferStrategy buffer = getBufferStrategy();
		Graphics g = buffer.getDrawGraphics();
		// paint(g);
		g.drawImage(board, 0, 0, null);
		g.drawImage(bluePiece, x, y, null);
		buffer.show();
	}

	public void move(int xOrigen, int yOrigen) {
		xOrigen = 13;
		yOrigen = 165;
		while (xOrigen != x && yOrigen != y) {
			if (xOrigen != x)
				x = (x < xOrigen) ? x + 1 : x - 1;
			if (yOrigen != y)
				y = (y < yOrigen) ? y + 1 : y - 1;
			try {
				repaint();
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	Square getSquare(int x, int y) {
		for (Square s : Square.values()) {
			if (s.isClickedInside(x, y))
				return s;
		}
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Square s = getSquare(e.getX(), e.getY());
		if (s != null)
			System.out.println(s.ordinal());
		//start();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		int xOrigen = 13;
		int yOrigen = 165;
		while (xOrigen != x && yOrigen != y) {
			if (xOrigen != x) {
				x = (x < xOrigen) ? x + 1 : x - 1;
			}
			if (yOrigen != y) {
				y = (y < yOrigen) ? y + 1 : y - 1;
			}
			// invalidate();
			try {
				repaint();
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// repaint();
			// getGraphics().drawImage(bluePiece, x, y, null);
		}

	}

}
