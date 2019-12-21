public class coordinate {
	private double x, y;
	
	public coordinate(){
		this(0, 0);
	}
	public coordinate(double x, double y){
		this.x = x;
		this.y = y;
	}
	public coordinate copy(){
		return new coordinate(x, y);
	}
	
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void set(coordinate v){
		x = v.x;
		y = v.y;
	}
	
	public void setSize(double size){
		double org, rate;
		
		org = getSize();
		if(org==0) return;
		rate = size/org;
		
		x *= rate;
		y *= rate;
	}
	public double getSize(){
		return Math.sqrt(x*x+y*y);
	}
	public void setAngle(double a){
		double size = getSize();
		x = size*Math.cos(a);
		y = size*Math.sin(a);
	}
	/*public double getAngle(){
		return Math.atan2(y, x);
	}*/
	
	public void plus(coordinate v){
		x += v.x;
		y += v.y;
	}
	public coordinate getPlus(coordinate v){
		return new coordinate(x+v.x, y+v.y);
	}
	public void minus(coordinate v){
		x -= v.x;
		y -= v.y;
	}
	public coordinate getMinus(coordinate v){
		return new coordinate(x-v.x, y-v.y);
	}
	/*public void times(double d){
		x += d;
		y += d;
	}
	public coordinate getTimes(double d){
		return new coordinate(x*d, y*d);
	}*/
	public void flopX(){
		x *= -1;
	}
	public coordinate getFlopX(){
		return new coordinate(-x, y);
	}
	public void flopY(){
		y *= -1;
	}
	public coordinate getFlopY(){
		return new coordinate(x, -y);
	}
	
	public void matchDirection(coordinate v){
		set(getMatchDirection(v));
	}
	public coordinate getMatchDirection(coordinate tv){
		coordinate v = tv.copy();
		v.setSize(getSize());
		return v;
	}
}
