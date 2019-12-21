public class coordinate{

	private double x;
	private double y;

	public void coordinate(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setX(double a){
		x= a;
	}

	public void setY(double b){
		y= b;
    }

	public void set(coordinate a){
		this.x= a.x;
		this.y= b.y;
	}

 	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
	public void plus(coordinate v){
		x += v.x;
		y += v.y;
	}

	public void flopX(){
		x *= -1;
	}

	public void flopY(){
		y *= -1;
	}
	
	public Vector getFlopX(){
		return new coordinate(-x, y);

	public Vector getFlopY(){
		return new coordinate(x, -y);
	}
	
	public void matchDirection(coordinate v){
		set(getMatchDirection(v));
	}
	public Vector getMatchDirection(coordinate tv){
		coordinate v = tv.copy();
		v.setSize(getSize());
		return v;	
}

