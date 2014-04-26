package keon.ldtest.helpers;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationFactory {

	/**
	 * Used when animations are of the form apple0.png apple1.png, apple2.png, ..., apple[num-1].png, etc
	 * @param baseName The base file name
	 * @param num The number of files to import
	 * @param fileType the extension of the file, eg .png. Anything after number
	 * @param duration length of each img
	 * @return The animation constructed
	 * @throws SlickException Generic Slick Exception thrown if file cannot be loaded.
	 */
	public static Animation makeAnim(String baseName, int num, String fileType, int duration)
	{
		Image[] images = new Image[num];
		for (int i = 0 ; i < num; i++)
		{
			try {
				images[i] = new Image(baseName+num+fileType);
			} catch (SlickException e) {
				e.printStackTrace();
				return new Animation();
			}
		}
		return new Animation(images, duration);
	}
	
	/**
	 * Used when animations are of the form apple0.png apple1.png, apple2.png, ..., apple[num-1].png, etc but have different durations
	  @param baseName The base file name
	 * @param num The number of files to import
	 * @param fileType the extension of the file, eg .png. Anything after number
	 * @param durations length of each img passed as array
	 * @return The animation constructed
	 * @throws SlickException Generic Slick Exception thrown if file cannot be loaded.
	 */
	public static Animation makeAnim(String baseName, int num, String fileType, int durations[])
	{
		Image[] images = new Image[num];
		for (int i = 0 ; i < num; i++)
		{
			try {
				images[i] = new Image(baseName+num+fileType);
			} catch (SlickException e) {
				e.printStackTrace();
				return new Animation();
			}
		}
		return new Animation(images, durations);
	}
	
	/**
	 * Used when animations can be loaded from a sprite sheet vertically downwards and the animation is the only one in the sheet
	 * @param spriteSheet the string of the spritesheet to be loaded
	 * @param xLen The length of an individual image
	 * @param yLen The height of an individual image
	 * @param duration length to display each image for
	 * @return The animation created
	 * @throws SlickException Image isn't found
	 */
	public static Animation makeAnim(String spriteSheet, int xLen, int yLen, int duration)
	{
		try {
			return new Animation(new SpriteSheet(spriteSheet, xLen, yLen), duration);
		} catch (SlickException e) {
			e.printStackTrace();
			return new Animation();
			
		}
	}
	
	/**
	 * Used when animations can be loaded from a sprite sheet vertically downwards and the animation is one of many in sheet.
	 * @param spriteSheet the string of the spritesheet to be loaded
	 * @param num number of frames
	 * @param xLen The length of an individual image
	 * @param yLen The height of an individual image
	 * @param x1 First position of the animation
	 * @param y1 First position of the animation
	 * @param duration length to display each image for
	 * @return The animation created
	 * @throws SlickException Image isn't found
	 */
	public static Animation makeAnim(String spriteSheet, int num, int xLen, int yLen, int x1, int y1, int duration)
	{
		try {
			return new Animation(new SpriteSheet(spriteSheet, xLen, yLen), x1, y1, x1, y1+num,false, duration, false);
		} catch (SlickException e) {
			e.printStackTrace();
			return new Animation();
			
		}
	}
	
	/**
	 * Used when animations can be loaded from a previously loaded spritesheet vertically downwards and the animation is one of many in sheet.
	 * @param spriteSheet The already loaded spritesheet
	 * @param num number of frames
	 * @param x1 First position of the animation
	 * @param y1 First position of the animation
	 * @param duration length to display each image for
	 * @return The animation created
	 * @throws SlickException Image isn't found
	 */
	public static Animation makeAnim(SpriteSheet spriteSheet, int num, int x1, int y1, int duration)
	{
		return new Animation(spriteSheet, x1, y1, x1, y1+num,false, duration, false);
	}
}
