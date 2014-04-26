package keon.ldtest.render;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import keon.ldtest.entity.Entity;
import keon.ldtest.entity.World;
import keon.ldtest.gameloop.WeekendGame;
import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;

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
		return;
	}
	
	public void update(double delta, World w)
	{
		super.update(delta, w);
		if(follow!= null)
		{
			System.out.println(this.getDx());
			System.out.println(this.getDy());
			System.out.println(this.getY());
			System.out.println(this.getX());
			this.setDx(((follow.getX()+follow.getxLen()/2)-(this.getX()+this.cameraWidth/2))/200);
			this.setDy(((follow.getY()+follow.getyLen()/2)-(this.getY()+this.cameraHeight/2))/200);
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
