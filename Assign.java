import java.util.ArrayList;
import java.awt.Graphics;
public abstract class Assign {
	protected Character character;
	protected ArrayList<Attacker> attackers;

	public Assign(Character a, ArrayList<Attacker> b){
		 character = a;
		 attackers = b;
	}

	public boolean stillAlive(){
		for(Attacker attacker: attackers){
				if(Object.collide(character, attacker))
					return false;
		}
		return true;
   }
	public Character getCharacter(){
		return character;
	}
	
	public void setCharacter(Character a){
		character = a;
	}

	public void setAttackers(ArrayList<Attacker> b){
		 attackers = b;

	}
	
	public void drawSelf(Graphics g){
		avoider.drawSelf(g);
	}
