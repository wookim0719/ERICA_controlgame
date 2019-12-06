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


