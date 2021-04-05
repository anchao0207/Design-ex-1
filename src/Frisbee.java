import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Frisbee {
	private List<Player> VerticalStack;
	private Player handler1;
	private Player handler2;
	private int reset = 0;
	//we assume that the number of players will be right and either 1 of the handler have the disk
	public Frisbee(Player handler1,Player handler2,List<Player> VerticalStack) {
		this.handler1=handler1;
		this.handler2=handler2;
		this.VerticalStack = new LinkedList<Player>();
		for(Player i:VerticalStack) {
			this.VerticalStack.add(i);
		}
	}
	//we assume that player here is either handler2 or the last cutters from the VerticalStack
	
	public void pass(Player player) {
		//if the reset number is 7, the program stop
		if(!player.getRole().equals(Role.HANDLER)&&!player.equals(VerticalStack.get(0))) {
			throw new ArithmeticException("Can't pass");
		}
		
		if(reset<7) {
			//we don't know who has the disk at first
			if(handler1.disk==true) {
				//if the player who get pass to is a handler, we assume that the stack won't change
				if(player.getRole().equals(Role.HANDLER)) {
					handler1.disk=false;
					player.disk=true;
				}
				else {
					//here we don't know if the handler will pass it to the player
					//from the VerticalStack or not
					//because even when the handler want to pass it to the cutter
					//if the chance that cutter could get the disk is too low,
					//the handler will hold the disk and wait for next pass.
					Random rand = new Random();
					//here I use random from 0 to 1,
					//if we get 0, the pass will either failed and handler keep the disk
					//or the pass success then the cutter dump it back to the same handler
					//these 2 scenario have the same result.
					if(rand.nextInt(2)==0) {
						VerticalStack.add(VerticalStack.get(0));
						VerticalStack.remove(0);
						reset++;
					}
					//if we get 1, the pass will success
					//and the cutter dumb the disk to the other handler.
					else {
						VerticalStack.add(VerticalStack.get(0));
						VerticalStack.remove(0);
						handler1.disk=false;
						handler2.disk=true;
						reset++;
					}
				}
			}
			//quite same as above but this time handler2 have the disk instead.
			else {
				if(player.getRole().equals(Role.HANDLER)) {
					handler2.disk=false;
					player.disk=true;
				}
				else {
					Random rand = new Random();
					if(rand.nextInt(2)==0) {
						VerticalStack.add(VerticalStack.get(0));
						VerticalStack.remove(0);
						reset++;
					}
					VerticalStack.add(VerticalStack.get(0));
					VerticalStack.remove(0);
					handler1.disk=false;
					handler2.disk=true;
					reset++;
				}
			}
		}
	}
	
	public String toString() {
		return String.format("handler=%s %s, cutter=%s", handler1,handler2,VerticalStack);
	}
}
