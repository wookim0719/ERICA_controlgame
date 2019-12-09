public class Attacker extends Object{
	private coordinate velocity;

	public Attacker(double x, double y){
		super(x,y,5);
		velocity = new coordinate(1,0);
	}

	public void setDirection(double angle){
		velocity.setSize(speed);
		velocity.setAngle(angle);
	}

	public void moveSelf(){
			pos.plus(velocity);
			if(pos.getX()<0 || pos.getX()>DodgeFrame.WIDTH){
				velocity.changex();
				pos.plus(new coordinate(velocity.getX()*2, 0));
			}

			if(pos.getY()<0 || pos.getY()>Di=odgeFrame.Height){
				velocity.changeY();
				pos.plus(new coordinate(0, velocity.getY()*2));
			}
	}
