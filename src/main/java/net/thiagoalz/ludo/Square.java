package net.thiagoalz.ludo;

public enum Square {
	h1(0, 0), h2(1, 0), h3(2, 0), h4(3, 0), h5(4, 0), h6(4, -1), h7(5, -1), h8(
			5, -2), h9(5, -3), h10(5, -4), h11(5, -5), h12(6, -5), h13(7, -5), h14(
			7, -4), h15(7, -3), h16(7, -2), h17(7, -1);

	public static final int SCREEN_X = 12;
	public static final int SCREEN_Y = 164;

	public static final int HOUSE_SIZE = 29;
	public static final int HOUSE_PADDING = 3;

	public int x;
	public int y;
	public int screenX;
	public int screenY;

	public boolean crown;

	Square(int x, int y) {
		this.x = x;
		this.y = y;
		crown = false;
		init();
	}

	Square(int x, int y, boolean crown) {
		this.x = x;
		this.y = y;
		this.crown = crown;
		init();
	}

	public void init(){
		int deltaX = x * (HOUSE_SIZE + HOUSE_PADDING);
		screenX = SCREEN_X + deltaX;

		int deltaY = y * (HOUSE_SIZE + HOUSE_PADDING);
		screenY = SCREEN_Y + deltaY;
	}

	boolean isClickedInside(int x, int y) {
		return ((x >= screenX && x <= (screenX + HOUSE_SIZE)) && 
				(y >= screenY && y <= (screenY + HOUSE_SIZE)));
	}

}
