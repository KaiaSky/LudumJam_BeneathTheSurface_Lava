package keon.ldtest.entity.tile;

import keon.ldtest.entity.TileWorld;
import keon.ldtest.helpers.RandomHolder;
import keon.ldtest.entity.tiledata.*;

public class TileWater extends BasicTile{

	public int id = 2;
	
	@Override
	public void update(int x, int y, TileWorld w, TileData data)
	{
		if(y<w.getYLen()-1 && w.getTileAt(x, y+1)==(char)0) // drop down 1
		{
			w.setTileAt((char)0, x, y);
			w.setTileAt((char)7, x, y+1);
			return;
		}
		if(y<w.getYLen()-1 && x>0 && w.getTileAt(x-1, y+1)==(char)0) // drop down 1 left 1
		{
			w.setTileAt((char)0, x, y);
			w.setTileAt((char)7, x-1, y+1);
			return;
		}
		if(y<w.getYLen()-1 &&  x<w.getXLen()-1 &&w.getTileAt(x+1, y+1)==(char)0) // drop down 1 right 1
		{
			w.setTileAt((char)0, x, y);
			w.setTileAt((char)7, x+1, y+1);
			return;
		}
		if(x>0 && x<w.getXLen()-1 &&w.getTileAt(x-1, y)==(char)0 && w.getTileAt(x+1, y)!=(char)0) // slide left
		{
			w.setTileAt((char)0, x, y);
			w.setTileAt((char)7, x-1, y);
			return;
		}
		if(x>0 && x<w.getXLen()-1 && w.getTileAt(x+1, y)==(char)0 && w.getTileAt(x-1, y)!=(char)0) // slide right
		{
			w.setTileAt((char)0, x, y);
			w.setTileAt((char)7, x+1, y);
			return;
		}
		if(x>0 && x<w.getXLen()-1 && w.getTileAt(x+1, y)==(char)0 && w.getTileAt(x-1, y)==(char)0)
		{
			if(RandomHolder.RANDOM.nextBoolean())
			{
				w.setTileAt((char)0, x, y);
				w.setTileAt((char)7, x+1, y);
				return;
			}else{
				w.setTileAt((char)0, x, y);
				w.setTileAt((char)7, x-1, y);
				return;
			}
		}
		return;
	}	
}