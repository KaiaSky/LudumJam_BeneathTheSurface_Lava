package keon.ldtest.helpers;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public final class GraphicsHelper {

	public static void drawLocationCenteredString(String s, float cx, float cy,
			Graphics g) {
		Font f = g.getFont();
		g.drawString(s, cx-f.getWidth(s), cy-f.getHeight(s));
	}
}
