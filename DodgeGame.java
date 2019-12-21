import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DodgeGame {
	public static void main(String[] args) {
		Runnable dodge = new DodgeFrame();
		Thread t = new Thread(dodge);
		t.start();//thread 사용법이고 구현이유는 점수집계와 초시계 때문
			}
}

class DodgeFrame extends Frame implements Runnable {
	public static final int WIDTH = 800, HEIGHT = 800;
	private final int INITIAL_ATTACKERS =200;
	private final long DT = 20;
	private final double Character_SPEED = 4, ATTACKER_SPEED = 2;
	private ArrayList<Attacker> attackers;
	private ArrayList<Assign> pilots, deads;
	
	public DodgeFrame(){
		super("2019009870 김정우");
		initFrame();
	}
	
	public void initFrame(){
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		for(Assign ap: pilots) ap.drawSelf(g);//원 그리기 
		for(Attacker at: attackers) at.drawSelf(g);//원 그리기 
		
	}
	public void initVariables(){
		attackers = new ArrayList<Attacker>();
		pilots = new ArrayList<Assign>();
		deads = new ArrayList<Assign>();
		
		keyControl player = new keyControl();
		addKeyListener(player);
		addAssign(player);

	}
	
	private void addAssign(Assign ap){
		Character a = new Character(WIDTH/2, HEIGHT/2);//Character 처음위치  
		a.setSpeed(Character_SPEED);//Character 속도 설정 
		ap.setCharacter(a);//a로 Character 설정 
		ap.setAttackers(attackers);// attackers를 array로 설정 
		pilots.add(ap);// pilots array에 ap를 추가 
		
	}
	
	public void run(){//쓰레드의 run 메소드이며 array를 초기화하며 게임 실행을한다. 
		while(true){
			initVariables();
			runGame();
		}
	}
	
	private void runGame(){
		double wgap = 4*WIDTH/(INITIAL_ATTACKERS); //width*(개수/4)
		double hgap = 4*HEIGHT/(INITIAL_ATTACKERS);
		
		for(int i=1;i<=INITIAL_ATTACKERS/4;i++){// 배열 4개로 이루어져 있어서 attackers를 4부류로 나누어서 배정 
			Attacker[] as = new Attacker[4];
			as[0] = new Attacker(wgap*i, 0); //pos coordinate (wgap*i, 0) , 반지름 5 , velocity coordinate (1,0)
			as[1] = new Attacker(wgap*i, HEIGHT);//아래쪽에서 나옴 
			as[2] = new Attacker(0, hgap*i);//0, 왼쪽에서 나옴 
			as[3] = new Attacker(WIDTH, hgap*i); //오른쪽에서 나옴 
			for(Attacker a: as){ // as 배열속에 있는 원소를 Attacker클래스 a에 넣으면서 속도 설정 
				a.setSpeed(ATTACKER_SPEED); //attacker 클래스 a에 스피드 2로 설정  
				a.setDirection(Math.random());//velocity = (1, 0) -> velocity.setsize(2), org = 1, rate= 2, ( x=2 y=0  ) (x=cos(random), y=0 )
				attackers.add(a);//attacker array에 추가 
			}
		}
		while(true){
			for(Assign ap: pilots){
				if(!ap.stillAlive()) deads.add(ap);//ap가 죽었을때 dead어레이에 추가한다.
				ap.moveCharacter(); //queue
			}
			for(Assign ap: deads){
				pilots.remove(ap);//죽으면 배열에서 제거 
			}
			if(pilots.size()==0) break;//배열에 아무것도 없으면 break 
			for(Attacker at: attackers) at.moveSelf();// 배열 속 모든 attackers 스스로 움직임 구현 튕겨나가기 
			
			
			try{
				Thread.sleep(DT);//쓰레드가 일정시간동안 실행을 중지 
			}catch(Exception ex){
				ex.printStackTrace();
			}//예외처리 및 천천히 하기 
			repaint();
		}
		
	}
	
	
}
