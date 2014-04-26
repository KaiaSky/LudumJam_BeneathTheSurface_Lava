package keon.ldtest.entity;

import keon.ldtest.render.Camera;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Entity{

	Rectangle rect;
	
	private float dx;
	private float dy;
	
	private float xLen;
	private float yLen;
	
	private Animation anim;
	
	public Entity(Animation newAnim, float newx, float newy)
	{
		anim = newAnim;
		rect = new Rectangle(newx, newy, anim.getWidth(), anim.getHeight());
		dx = 0;
		dy = 0;
		xLen = anim.getWidth();
		yLen = anim.getHeight();
	}
	
	public void update(double delta, World w)
	{
		rect.setX(rect.getX() + dx);
		rect.setY(rect.getY() + dy);
	}
	
	public void draw(Graphics g, Camera c)
	{
		System.out.println(this.getX());
		
		//if(this.collide(c)) // camera bounding box is screen. Nice how it all works.
		if(true)
		{
			System.out.println("hai");
			g.drawAnimation(anim, rect.getX()-c.getX(), rect.getY()-c.getY());
		}
	}
	
	public boolean collide(Entity e)
	{
		return this.rect.intersects(e.rect);
	}

	public float getX() {
		return rect.getX();
	}

	public void setX(float x) {
		this.rect.setX(x);
	}

	public float getY() {
		return rect.getX();
	}

	public void setY(float y) {
		this.rect.setY(y);;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public float getxLen() {
		return xLen;
	}

	public void setxLen(float xLen) {
		this.xLen = xLen;
	}

	public float getyLen() {
		return yLen;
	}

	public void setyLen(float yLen) {
		this.yLen = yLen;
	}

	public Animation getAnim() {
		return anim;
	}

	public void setAnim(Animation anim) {
		this.anim = anim;
	}
	
}
