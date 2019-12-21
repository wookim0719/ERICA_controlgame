import java.awt.Graphics;

public abstract class Object {
	protected double r, speed;
	protected coordinate pos;
	
	public Object(){
		this(10);
	}
	public Object(double r){
		this(0, 0, r);
	}
	public Object(double x, double y){
		this(x, y, 10);
	}
	public Object(coordinate v){
		this(v.getX(), v.getY(), 10);
	}
	public Object(coordinate v, double r){
		this(v.getX(), v.getY(), r);
	}
	public Object(double x, double y, double r){
		pos = new coordinate(x, y);
		setRadius(r);
		speed = 0;
	} //여기까지 모두 생성자 함수로 초기화 해주는 역할을 함 

	public double getX(){
		return pos.getX()-r; // 중심에서 반지름을 뺐으므로 원의 제일 왼쪽 좌표 반환 
	}
	public double getY(){
		return pos.getY()-r;// 중심에서 반지름을 뻈으므로 원의 제일 위쪽 좌표 반환 
	}
	public double getCenterX(){
		return pos.getX();
	}//중심의x좌표 
	public double getCenterY(){
		return pos.getY();
	}//중심의 y좌표 
	public coordinate getcoordinate(){
		return pos;
	}//중심의 위치벡터 
	public double getRadius(){
		return r;
	}//반지름 반
	public double getSpeed(){
		return speed;
	} //속도 반
	public void setX(double x){
		pos.setX(x + r);
	}	//중심좌표중 x좌표에  반지름만큼 더해준다.
	public void setY(double y){
		pos.setY(y + r);
	}   //중심좌표중 y좌표에 반지름만큼 더해준다.
	public void setCenterX(double x){
		pos.setX(x);
	} //중심좌표 지정해주기 
	public void setCenterY(double y){
		pos.setY(y);
	} //중심좌표 지정해주기 
	public void setcoordinate(coordinate v){
		pos.set(v);
	} //벡터 지정 
	public void setRadius(double r){
		this.r = r;
	} //반지름 지정 
	public void setSpeed(double s){
		speed =  s;
	} //속도 지정 

	public void move(int xdir, int ydir){
		coordinate v = new coordinate(xdir,  ydir);
		v.setSize(speed);//v벡터의 크기를 구하고 speed값에 크기를 나누어서 비율을 구한 후 각각 x, y에 비율을 곱한다.
		pos.plus(v); //중심좌표에 위의 값을 더해준다 
		if(invalidPos()){
			makeValidPos();//위치가 잘못 되어 False가 반환되었을때 올바르게 고쳐준다. 
		}//xdir, ydir 방향으로 속력만큼 이동 
	}
	
	public static double distance(Object a, Object b){
		return a.getcoordinate().getMinus(b.getcoordinate()).getSize(); //b의 위치를 알아온 후 a의 위치를 알아와서 두 위치를 빼서 사이즈를 측정한다.
	}
	public static boolean collide(Object a, Object b){//a의 반지름과 b의 반지름의 합이 거리보다 클때 true 접촉해있으면 False를 반환 
		return a.getRadius()+b.getRadius() > distance(a, b);
	}
	
	abstract public void drawSelf(Graphics g);//추상메소드 
	
	protected boolean invalidPos(){
		return
			pos.getX()<0 || pos.getX()>DodgeFrame.WIDTH
		||	pos.getY()<0 || pos.getY()>DodgeFrame.HEIGHT;//위치가 창안쪽에 위치하지않을때 true를반환 
	}
	protected void makeValidPos(){
		if(pos.getX()<0) pos.setX(0); //다 올바르게 바꿔줌 
		else if(pos.getX()>DodgeFrame.WIDTH) pos.setX(DodgeFrame.WIDTH);// x좌표가 frmae의 크기를벗어날떄 frame의 값을 반환해준다. 
		if(pos.getY()<0) pos.setY(0);
		else if(pos.getY()>DodgeFrame.HEIGHT) pos.setY(DodgeFrame.HEIGHT);
	}
}
