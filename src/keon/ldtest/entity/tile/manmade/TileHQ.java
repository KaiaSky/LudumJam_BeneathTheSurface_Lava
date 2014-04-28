package keon.ldtest.entity.tile.manmade;

import keon.ldtest.entity.tile.BasicTile;
import keon.ldtest.entity.tiledata.TileData;

public class TileHQ extends BasicTile{

	public void update(int x, int y, char[][] tileList, TileData data, TileData[][] dataList)
	{
		doFloodfill(x,y,tileList,dataList,8);
	}
	
	private static void doFloodfill(int x, int y, char[][] tiles, TileData[][] extra, int length)
	{
		for(int i = x-1; i <=x+1; i++){
			for(int j = y-1; j <=y+1; j++)
			{
				if(i>=0 && i<tiles.length && j>=0 && j< tiles[0].length)
				{
					extra[i][j].visible = true;
				}
			}
		}// set all 3x3 around this visible.
		if(length > 0)
		{
			for(int i = x-1; i <= x+1; i++){
				for(int j = y-1; j <= y+1; j++)
				{
					if(i>=0 && i<tiles.length && j>=0 && j< tiles[0].length)
					{
						if(!(i==x && j == y) && tiles[i][j]==(char)0)
						{
							doFloodfill(i,j,tiles,extra,length-1);
						}
					}			
				}
			}
		}
		
	}
}
