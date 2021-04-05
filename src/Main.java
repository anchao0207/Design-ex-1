import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Player c1=new Player("a",Role.CUTTER,false);	
		Player c2=new Player("b",Role.CUTTER,false);	
		Player c3=new Player("c",Role.CUTTER,false);	
		Player c4=new Player("d",Role.CUTTER,false);	
		Player c5=new Player("e",Role.CUTTER,false);	
		Player h1=new Player("f",Role.HANDLER,true);	
		Player h2=new Player("g",Role.HANDLER,false);
		List<Player> s = new LinkedList<Player>();
		s.add(c1);
		s.add(c2);
		s.add(c3);
		s.add(c4);
		s.add(c5);
		Frisbee f = new Frisbee(h1,h2,s);
		f.pass(c1);
		System.out.println(f.toString());
	}

}
