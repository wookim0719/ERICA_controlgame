import java.awt.Color;
import java.awt.Graphics;

public class Attacker extends Object{
	private Color color = Color.CYAN;
	private coordinate velocity;
	
	public Attacker(double x, double y){
		super(x, y, 5);
		velocity = new coordinate(1, 0);
	}
	
	public void setDirection(double angle){
		velocity.setSize(speed);//속도벡터의 속력을 지정 
		velocity.setAngle(angle);//속도벡터의 각도를 지정 
		
	}
	public void moveSelf(){
		pos.plus(velocity);//pos(x+velocity.x, y+v.y)
		if(pos.getX()<0 || pos.getX()>DodgeFrame.WIDTH){
			velocity.flopX();//x좌표가 창밖이면 방향을 바꾼다. 
			pos.plus(new coordinate(velocity.getX()*2, 0));//pos(x+velocity.x,y+0) 튕겨나오는거 구현 
		}
		if(pos.getY()<0 || pos.getY()>DodgeFrame.HEIGHT){
			velocity.flopY();
			pos.plus(new coordinate(0, velocity.getY()*2));// 튕겨나오는거 구현 공의 위치 
		}
	}
		
	@Override
	public void drawSelf(Graphics g) {
		g.setColor(color);
		g.fillOval((int)getX(), (int)getY(), (int)(getRadius()*2), (int)(getRadius()*2));
	}

}
