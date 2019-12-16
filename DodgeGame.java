import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DodgeGame {
	public static void main(String[] args) {
	GameFrame g = new GameFrame();
	}


static  class GameFrame extends Frame implements Runnable{
	 public static final int Width = 400, Height = 400;
	 private final int INITIAL_ATTACKERS = 200;
	 private final long DT = 20;
	 private final double AVOIDER_SPEED = 4, ATTACK_SPEED =2;
	 private ArrayList<Attacker> attackers;
	 private ArrayList<Character> polots, deads;
	 public GameFrame(){
		 super("2019009870 김정우");
		 initFrame();
	}
	public DodgeFrame(){
		super("Our Own Dodge");
		initFrame();
	}


	public void initFrame(){
		setSize(Width,Height);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent a){
			 	    dispose();
					System.exit(0);
			}
		});
	}

	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Width,Height);
	}
 }
	public void addAvoiderPilot(AvoiderPilot ap){
		Character a = new Character(Width/2, Height/2);
		a.setSpeed(AVOIDER_SPEED);
		ap.setAvoider(a);
		ap.setAttackers(attackers);
		pilots.add(ap);
		
}
}
