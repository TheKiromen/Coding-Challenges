
public class Player {
	String name;
	int score;
	Player(String name){
		this.name=name;
		score=0;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public void increase() {
		score++;
	}
	
	public void decrease() {
		score--;
	}
}
