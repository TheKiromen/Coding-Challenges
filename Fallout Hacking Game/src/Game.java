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
		String answer,guess="";
		int difficulty,length=0,word_count=0,letters_matching=0,guess_count=4;
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
					System.out.println(answer);
					i++;
				}
			}
			answer=words[(int)(Math.random()*word_count)+1];
			input.nextLine();
			do{
				System.out.println("Guess? ("+guess_count+" left)");
				guess=input.nextLine();
				letters_matching=checkAnswer(guess,answer);
				System.out.println(letters_matching+"/"+length+" correct");
				guess_count--;
			}while(guess_count>0&&letters_matching!=answer.length());
			if(guess_count==0) {
				System.out.println("You lose!");
			}else {
				System.out.println("You win!");
			}
		} catch (Exception e) {
			System.out.println("Error occurred.");
		}
	}
	
	
	//outputs number of correct letters
	int checkAnswer(String guess,String answer) {
		int letters_matching=0;
		if(guess.length()==answer.length()) {
			for(int i=0;i<guess.length();i++) {
				if(guess.charAt(i)==answer.charAt(i)) {
					letters_matching++;
				}
			}
		}
		return letters_matching;
	}

}
