import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
	
	private void play() {
		BufferedReader data;
		Scanner input;
		String[] words;
		String answer;
		int difficulty,length=0,word_count=0;
		try {
			data = new BufferedReader(new FileReader("enable1.txt"));
			input = new Scanner(System.in);
			System.out.println("Difficulty (1-5)?");
			difficulty=input.nextInt();
			switch(difficulty) {
				case 1:
					length=(int)(Math.random()*3+4);
					word_count=(int)(Math.random()*3+4);
				break;
				case 2:
					length=(int)(Math.random()*2+7);
					word_count=(int)(Math.random()*2+7);
				break;
				case 3:
					length=(int)(Math.random()*3+9);
					word_count=(int)(Math.random()*3+9);
				break;
				case 4:
					length=(int)(Math.random()*2+13);
					word_count=(int)(Math.random()*2+13);
				break;
				case 5:
					length=(int)(Math.random()*2+15);
					word_count=(int)(Math.random()*2+15);
				break;
			}
			words=new String[word_count];
			for(int i=0;i<word_count;) {
				answer=data.readLine();
				if(answer.length()==length) {
					words[i]=answer;
					i++;
				}
			}
			answer=words[(int)(Math.random()*10)+1];
		} catch (Exception e) {
			System.out.println("Error occurred.");
		}
	}
	
	boolean checkAnswer(String s) {
		return false;
	}

}
