import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DodgeGame {
	public static void main(String[] args) {
	GameFrame g = new GameFrame();
	}


static  class GameFrame extends Frame{
	 public static final int Width = 400, Height = 400;
	 
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
	}
 }
}
