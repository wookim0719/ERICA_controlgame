import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Assign {
	protected Character character;
	protected ArrayList<Attacker> attackers;
	
	public Assign(Character a, ArrayList<Attacker> as){
		character = a;
		attackers = as;
	}
	
	public boolean stillAlive(){
		for(Attacker attacker: attackers){
			if(Object.collide(character, attacker)) return false;
		}
		return true;
	}
	public Character getCharacter(){
		return character;
	}
	public void setCharacter(Character a){
		character = a;
	}
	public void setAttackers(ArrayList<Attacker> as){
		attackers = as;
	}
	public abstract void moveCharacter();
	public void drawSelf(Graphics g){
		character.drawSelf(g);
	}
}
