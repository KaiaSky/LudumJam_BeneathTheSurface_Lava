package keon.ldtest.entity.tile;

import keon.ldtest.helpers.RandomHolder;

public class TileLava extends BasicTile{

	public int id = 3;
	
	public void update(int x, int y, char[][] tiles)
	{
		if(y<tiles[0].length-1 && tiles[x][y+1]==(char)0) // drop down 1
		{
			tiles[x][y] = (char)0;
			tiles[x][y+1] = (char)6;
			return;
		}
		if(y<tiles[0].length-1 && x>0 && tiles[x-1][y+1]==(char)0) // drop down 1
		{
			tiles[x][y] = (char)0;
			tiles[x-1][y+1] = (char)6;
			return;
		}
		if(y<tiles[0].length-1 &&  x<tiles.length-1 &&tiles[x+1][y+1]==(char)0) // drop down 1
		{
			tiles[x][y] = (char)0;
			tiles[x+1][y+1] = (char)6;
			return;
		}
		if(x>0 && x<tiles.length-1 &&tiles[x-1][y]==(char)0 && tiles[x+1][y]!=(char)0) // slide left
		{
			tiles[x][y] = (char)0;
			tiles[x-1][y] = (char)6;
			return;
		}
		if(x>0 && x<tiles.length-1 && tiles[x+1][y]==(char)0 && tiles[x-1][y]!=(char)0) // slide right
		{
			tiles[x][y] = (char)0;
			tiles[x+1][y] = (char)6;
			return;
		}
		if(x>0 && x<tiles.length-1 && tiles[x+1][y]==(char)0 && tiles[x-1][y]==(char)0)
		{
			if(RandomHolder.RANDOM.nextBoolean())
			{
				tiles[x][y] = (char)0;
				tiles[x+1][y] = (char)6;
				return;
			}else{
				tiles[x][y] = (char)0;
				tiles[x-1][y] = (char)6;
				return;
			}
		}
		return;
	}
	
}
