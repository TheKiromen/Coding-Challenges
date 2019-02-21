import java.util.Scanner;

public class Counter {

	public static void main(String[] args) {
		Counter c = new Counter();
		c.count();
	}
	
	public void count() {
		Player[] players = new Player[5];
		players[0] = new Player("a");
		players[1] = new Player("b");
		players[2] = new Player("c");
		players[3] = new Player("d");
		players[4] = new Player("e");
		
		String input="EbAAdbBEaBaaBBdAccbeebaec";
		
		//No validation for input to make life easier
		int tmp;
		for(int i=0;i<input.length();i++) {
			tmp=input.charAt(i);
			if(tmp<97) {
				players[tmp-65].decrease();
			}else {
				players[tmp-97].increase();
			}
		}
		
		
		//sorting
		Player swp;
		for(int i=0;i<players.length-1;i++) {
			for(int j=0;j<players.length-1;j++)
			if(players[j+1].getScore()>players[j].getScore()) {
				swp=players[j];
				players[j]=players[j+1];
				players[j+1]=swp;
			}
		}
		
		
		//output
		for(Player p : players) {
			System.out.print(p.getName()+":"+p.getScore()+", ");
		}	
	}

}
