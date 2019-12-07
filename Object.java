public abstract class Object {
	protected double radius, speed;
	protected coordinate pos;

	public Object(coordinate c){
		this(c.getX(), c.getY(), 10);
	public Object(coordinate C, double r){
		this(c.getX(), c.getY(), r);
	public Object(double x, double y, double r){
		pos = new coordinate(x,y);
		setRadius(r);
		speed=0;
	}



	public double getCenterX(){
		return pos.getX();
	}

	public double getCenterY(){
		return pos.getY();
	}

	public double getCoordinate(){
		return pos;
	}
	
	public double getRadius(){
		return radius;
	}

	public double getSpeed(){
		return speed;
 	}

	public void setCenterX(double x){
		pos.setX(x);

	public void setCenterY(double y){
		pos.setY(y);
	}

	public void setCoordinate(coordinate c){
		pos.set(c);

	}

	public void setSpeed(double s){
		speed = s;
	}

	public void setRadius(double r){
		radius = r;

	}













