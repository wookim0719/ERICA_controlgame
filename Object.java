import java.awt.Graphics;

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


	public double getX(){
		return pos.getX-radius;
	}
	public double getY(){
		return pos.getY()-radius;
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

	public void move(int xdir, int ydir){
		Coordinate c = new Coordinate(xdir,  ydir);
		v.setSize(speed);//v벡터의 크기를 구하고 speed값에 크기를 나누어서 비율을 구한 후 각각 x, y에 비율을 곱한다.
		pos.plus(c); //중심좌표에 위의 값을 더해준다 
		if(invalidPos()){
			makeValidPos();//위치가 잘못 되어 False가 반환되었을때 올바르게 고쳐준다. 
		}//xdir, ydir 방향으로 속력만큼 이동 
	}
	
	public static double distance(Object a, Object b){
		return a.getCoordinate().getMinus(b.getCoordinate()).getSize(); //b의 위치를 알아온 후 a의 위치를 알아와서 두 위치를 빼서 사이즈를 측정한다.
	}
	public static boolean collide(Object a, Object b){//a의 반지름과 b의 반지름의 합이 거리보다 클때 true 접촉해있으면 False를 반환 
		return a.getRadius()+b.getRadius() > distance(a, b);
	}
	
	abstract public void drawSelf(Graphics g);//추상메소드 
	
	protected boolean invalidPos(){
		return
			pos.getX()<0 || pos.getX()>GameFrame.WIDTH
		||	pos.getY()<0 || pos.getY()>GameeFrame.HEIGHT;//위치가 창안쪽에 위치하지않을때 true를반환 
	}
	protected void makeValidPos(){
		if(pos.getX()<0) pos.setX(0); //다 올바르게 바꿔줌 
		else if(pos.getX()>GameFrame.WIDTH) pos.setX(GameFrame.WIDTH);// x좌표가 frmae의 크기를벗어날떄 frame의 값을 반환해준다. 
		if(pos.getY()<0) pos.setY(0);
		else if(pos.getY()>GameFrame.HEIGHT) pos.setY(GameFrame.HEIGHT);
	}
}










