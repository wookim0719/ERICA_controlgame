import java.awt.color;
import java.awt.Graphics;


public class Character extends Object{
	private Color color = Color.RED;
	
	public Character(double x, double y){
		super(x,y,6);
	}

	@Override
	public void drawSelf(Graphics g) {
		g.setColor(color);
		g,fillOval((int)getX(), (int)getY(), (int)(GetRadius(), (int)getRadius()*2);
	}

}
