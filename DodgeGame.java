import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DodgeGame {
	public static void main(String[] args) {
		Runnable dodge = new GameFrame();
		Thread t = new Thread(dodge);
		t.start();
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
		for(AvoiderPilot ap: pilots ) ap.drawSelf(g);
		for(Attacker at: attackers) at.drawSelf(g);
	}
 
	public void addAvoiderPilot(AvoiderPilot ap){
		Character a = new Character(Width/2, Height/2);
		a.setSpeed(AVOIDER_SPEED);
		ap.setAvoider(a);
		ap.setAttackers(attackers);
		pilots.add(ap);
		
}

	public void run(){

		while(true){
			initVaariables();
			runGame();
		}
	}


	private void rungame(){
		double wgap = 4*Width/(INITIAL_ATTACKERS);

		double hgap = 4*Height/(INITIAL_ATTACKERS);


		for(int i=1; i<INITIAL_ATTACKERS/4; i++){

			Attacker[] as =new Attacker[4];
			as[0] = new Attacker(wgap*i, Height);

			as[2] = new Attacker(0, hgap*i);

			as[3]= new Attacker(Width, hgaap*i);

			for(Attacker a: as){
				
				a.setSpeed(ATTACKER_SPEED);
				a.setDirction(Math.random());
				attackers.add(a);
			}
		}


		while(true){
			for(AvoiderPilot ap: pilots){
				if(!ap.stillAlive()) deads.add(ap);

				ap.moveAvoider();

			}

			for(AvoiderPilot ap: deads){
					pilots.remove(ap);
				}
			if(pilots.size()==0) break;

			for(Attacker at: attackers) at.moveSelf();

			try{

				 Thread.sleep(DT);

				}
			catch(Exception ex){
				ex.printStackTrace();
			}

			repaint();

		}

}

