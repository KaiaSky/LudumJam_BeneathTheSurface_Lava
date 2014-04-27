package keon.ldtest.entity.tile;

import keon.ldtest.helpers.RandomHolder;

public class TileWater extends BasicTile{

	public int id = 2;
	
	public void update(int x, int y, char[][] tileList)
	{
		if(y<tileList[0].length-1 && tileList[x][y+1]==(char)0) // drop down 1
		{
			tileList[x][y] = (char)0;
			tileList[x][y+1] = (char)7;
			return;
		}
		if(y<tileList[0].length-1 && x>0 && tileList[x-1][y+1]==(char)0) // drop down 1
		{
			tileList[x][y] = (char)0;
			tileList[x-1][y+1] = (char)7;
			return;
		}
		if(y<tileList[0].length-1 &&  x<tileList.length-1 &&tileList[x+1][y+1]==(char)0) // drop down 1
		{
			tileList[x][y] = (char)0;
			tileList[x+1][y+1] = (char)7;
			return;
		}
		if(x>0 && x<tileList.length-1 &&tileList[x-1][y]==(char)0 && tileList[x+1][y]!=(char)0) // slide left
		{
			tileList[x][y] = (char)0;
			tileList[x-1][y] = (char)7;
			return;
		}
		if(x>0 && x<tileList.length-1 && tileList[x+1][y]==(char)0 && tileList[x-1][y]!=(char)0) // slide right
		{
			tileList[x][y] = (char)0;
			tileList[x+1][y] = (char)7;
			return;
		}
		if(x>0 && x<tileList.length-1 && tileList[x+1][y]==(char)0 && tileList[x-1][y]==(char)0)
		{
			if(RandomHolder.RANDOM.nextBoolean())
			{
				tileList[x][y] = (char)0;
				tileList[x+1][y] = (char)7;
				return;
			}else{
				tileList[x][y] = (char)0;
				tileList[x-1][y] = (char)7;
				return;
			}
		}
		return;
	}
	
}
