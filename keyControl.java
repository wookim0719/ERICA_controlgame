import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class keyControl extends Assign implements KeyListener{
	private Queue events;
	private boolean int UP=0, Down=1, Left=2, Right=3;
	private final int
		K_UP=KeyEvent.VK_UP,
		K_Down=KeyEvent.VK_Down,
		K_Left=KeyEvent.VK_Left,
		K_Right=KeyEvent.VK_Right;

	public keyControl(){
		this(null, null);
	}

	public keyControl(Character a, ArrayList<Character> b)
		super(a,b);
	events = new Queue(200);
		pressed = new boolean[4];



	@override
	public void keyTyped(KeyEvent e) {
	}

	@override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
			case K_UP:
			case K_Down:
			case K_Left:
			case K_Right:
				events.push(code);
			}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		switch(code){
			case K_UP:
			case K_Down:
			case K_Left:
			case K_Right:
				events.push(-code);
			}
	}


	@override
	public void moveAvoider() {
		int event, xdir=0, ydir=0;

		while(!events.isEmpty()){
			event = events.pop();

			switch(Math.abs(event)){
				case K_UP:
					pressed[UP] = event >0;
					break;
				case K_Down:
					pressed[Down = event >0;
					break;
				case K_Left:
					pressed[Left] = event >0;
				case K_Right:
					pressed[Right] = event >0;
					break;
				}
		}


		if(pressed[UP]) ydir--;
		if(pressed[Down]) ydir++;
		if(pressed[Left]) xdir--;
		if(pressed[Right]) xdir++;
		avoider.move(xdir, ydir);
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







