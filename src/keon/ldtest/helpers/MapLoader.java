package keon.ldtest.helpers;

import java.util.HashMap;

import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.World;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class MapLoader {
	
	
	private Color lava = new Color(255,0,0);
	private Color stone = new Color(255,0,0);

	public static void loadMapIntoWorld(Image map, TileWorld w)
	{
		HashMap<Color, Integer> colors = new HashMap<Color, Integer>();
		colors.put(new Color(255,255,255),0);//air
		colors.put(new Color(0,0,0),1);//stone
		colors.put(new Color(0,0,255),2);//water
		colors.put(new Color(255,0,0),3);//lava
		colors.put(new Color(137,93,0),4);//dirt
		colors.put(new Color(0,255,0),5);//grass
		for (int x = 0; x< map.getWidth(); x++)
		{
			for(int y = 0; y<map.getHeight(); y++)
			{
				w.setTileAt((char)(colors.get(map.getColor(x, y)).intValue()), x, y);
			}
		}
	}
	
}
