package keon.ldtest.entity.tile.manmade;

import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.tile.BasicTile;
import keon.ldtest.entity.tiledata.TileData;

public class TileHQ extends BasicTile{

	@Override
	public void update(int x, int y, TileWorld w, TileData data)
	{
		doFloodfill(x,y,w,8);
	}
	
	private static void doFloodfill(int x, int y, TileWorld w, int length)
	{
		for(int i = x-1; i <=x+1; i++){
			for(int j = y-1; j <=y+1; j++)
			{
				if(i>=0 && i<w.getXLen() && j>=0 && j< w.getYLen())
				{
					w.getTileDataAt(i, j).visible = true;
				}
			}
		}// set all 3x3 around this visible.
		if(length > 0)
		{
			for(int i = x-1; i <= x+1; i++){
				for(int j = y-1; j <= y+1; j++)
				{
					if(i>=0 && i<w.getXLen() && j>=0 && j< w.getYLen())
					{
						if(!(i==x && j == y) && w.getTileAt(i, j)==(char)0)
						{
							doFloodfill(i,j,w,length-1);
						}
					}			
				}
			}
		}
		
	}
}
