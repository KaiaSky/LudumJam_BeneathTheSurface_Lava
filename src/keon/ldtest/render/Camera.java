package keon.ldtest.render;

import keon.ldtest.entity.Entity;
import keon.ldtest.entity.World;
import keon.ldtest.gameloop.WeekendGame;
import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;

import org.newdawn.slick.Graphics;

public class Camera extends Entity{
	
	private Entity follow;
	public int cameraWidth = WeekendGame.WIDTH;
	public int cameraHeight = WeekendGame.HEIGHT;

	public Camera(float newx, float newy) {
		super(AnimationFactory.makeAnim(Config.airUnused, 32, 32, 100000), newx, newy);
		this.setxLen(cameraWidth);
		this.setyLen(cameraHeight);
	}
	
	public void draw(Graphics g)
	{
	}
	
	@Override
	public void update(double delta, World w)
	{
		super.update(delta, w);
		if(follow!= null)
		{
			this.setDx(((follow.getX()+follow.getxLen()/2)-(this.getX()+this.cameraWidth/2))/20);
			this.setDy(((follow.getY()+follow.getyLen()/2)-(this.getY()+this.cameraHeight/2))/20);
		}
	}
	
	public void setFollow(Entity e)
	{
		follow = e;
	}
	
	public Entity getFollow()
	{
		return follow;
	}
}
