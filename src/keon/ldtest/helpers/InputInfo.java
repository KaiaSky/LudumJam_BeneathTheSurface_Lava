package keon.ldtest.helpers;

import org.newdawn.slick.Input;

public class InputInfo {

	public static float mouseX=0;
	public static float mouseY=0;
	public static boolean leftmouseDown=false;
	public static boolean rightmouseDown=false;
	public static Input input;
	
	public static void updateInfo(Input in)
	{
		input = in;
		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
		leftmouseDown = in.isMouseButtonDown(0);
		rightmouseDown = in.isMouseButtonDown(1);
	}
	
}
