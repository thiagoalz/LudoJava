package net.thiagoalz.ludo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Token  extends Image {

	private static final int HOUSE_SIZE = 29;

	private BufferedImage texture;

	public Token() {
		try {
			texture = ImageIO.read(new File(
					"src/main/resources/net/thiagoalz/ludo/bluePiece.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Graphics getGraphics() {
		return texture.getGraphics();
	}

	@Override
	public int getHeight(ImageObserver observer) {
		return texture.getHeight(observer);
	}

	@Override
	public Object getProperty(String name, ImageObserver observer) {
		return texture.getProperty(name, observer);
	}

	@Override
	public ImageProducer getSource() {
		return texture.getSource();
	}

	@Override
	public int getWidth(ImageObserver observer) {
		// TODO Auto-generated method stub
		return texture.getHeight(observer);
	}

}
