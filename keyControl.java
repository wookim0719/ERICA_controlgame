import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class keyControl extends Assign implements KeyListener{
	private Queue events;
	private boolean[] pressed;
	private final int UP=0, DOWN=1, LEFT=2, RIGHT=3;
	private final int 
		K_UP=KeyEvent.VK_UP,
		K_DOWN=KeyEvent.VK_DOWN,
		K_LEFT=KeyEvent.VK_LEFT,
		K_RIGHT=KeyEvent.VK_RIGHT;
	
	public keyControl(){
		this(null, null);
	}
	public keyControl(Character a, ArrayList<Attacker> as) {
		super(a, as);
	 events = new Queue(200);
		pressed = new boolean[4];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//키보드의 키가 눌렀을때 실행된
		int code = e.getKeyCode();
		switch(code){
		case K_UP:
		case K_DOWN:
		case K_LEFT:
		case K_RIGHT:
			events.push(code);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {//키보드의 키가 눌렀다 때었을때 실행된다
		int code = e.getKeyCode();
		switch(code){
		case K_UP:
		case K_DOWN:
		case K_LEFT:
		case K_RIGHT:
			events.push(-code);
		}
	}

	@Override
	public void moveCharacter() {
		int event, xdir=0, ydir=0;
		
		while(!events.isEmpty()){//queue가 비지않을때 동안   
			event = events.pop();//even에 r반환 pop+=1
			
			switch(Math.abs(event)){
			case K_UP:
				pressed[UP] = event>0; 
				break;
			case K_DOWN:
				pressed[DOWN] = event>0;
				break;
			case K_LEFT:
				pressed[LEFT] = event>0;
				break;
			case K_RIGHT:
				pressed[RIGHT] = event>0;
				break;
			}
		}
		
		if(pressed[UP])		ydir--;//방향 
		if(pressed[DOWN])	ydir++;
		if(pressed[LEFT])	xdir--;
		if(pressed[RIGHT])	xdir++;
		
		character.move(xdir, ydir);
	}

}

class Queue {
	int size, push, pop;
	int[] queue;
	
	public Queue(int n){
		size = n;
		push = 0;
		pop = 0;
		queue = new int[n];
	}
	
	public void push(int item){
		queue[push] = item;
		push = (push+1)%size;
	}
	public int pop(){
		int r = queue[pop];
		pop = (pop+1)%size;
		return r;
	}
	
	public boolean isEmpty(){
		return push == pop;
	}
}
