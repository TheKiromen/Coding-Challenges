import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Funneler {

	public static void main(String[] args) {
		Funneler f = new Funneler();
		f.start();
	}
	
	private void start() {
		System.out.println(funnel("leave","eave"));
		System.out.println(funnel("reset","rest"));
		System.out.println(funnel("sleet","lets"));
		System.out.println(funnel("skiff","ski"));
		bonus1("dragoon");
		bonus1("boats");
		bonus1("affidavit");
		bonus2();
	}

	private boolean funnel(String s1,String s2) {
		String tmp;
		for(int i=1;i<=s1.length();i++) {
			tmp=s1.substring(0,i-1);
			tmp+=s1.substring(i);
			if(tmp.equals(s2)) {
				return true;
			}
		}
		return false;
	}
	
	private void bonus1(String word) {
		BufferedReader reader;
		String tmp;
		try {
			reader = new BufferedReader(new FileReader("enable1.txt"));
			System.out.print(word+" => [ ");
			while((tmp=reader.readLine())!=null) {
				if(funnel(word,tmp)) {
					System.out.print(tmp+" ");
				}
			}
			System.out.print("]\n");
			reader.close();
		}catch (IOException ex) {
			System.out.println("Missing File");
		}
	}
	
	//--TODO--//
	private void bonus2() {
		BufferedReader reader;
		//Holds arrays of words with same length
		ArrayList<ArrayList<String>> wordslist=new ArrayList<ArrayList<String>>();
		//holds words with the same length
		ArrayList<String> list;
		String tmp;
		//Im using them for counting how many words are there in total
		int counter=0;
		int words=0;
		
		int word_length=4;
		try {
			reader = new BufferedReader(new FileReader("enable1.txt"));
			//Big file so needs lots of memory, Bad solution but i dont know better one
			reader.mark(90000000);
			//This loop gets amount of words
			//We exclude words that are shorter than 4 letters since to create 5 "subwords" we will need word wich is atleast 5 letters
			//long and we will get five 4-letter subwords
			while((tmp=reader.readLine())!=null) {
				if(tmp.length()>=word_length) {
					words++;
				}
			}
			reader.reset();
			//This loop makes groups words into array by their length
			//First array is 4-letter words second 5-letter and so on.
			while(true) {
				if(counter==words) {
					break;
				}
				list = new ArrayList<String>();
				while((tmp=reader.readLine())!=null) {
					if(tmp.length()==word_length) {
						list.add(tmp);
						counter++;
					}
				}
				reader.reset();
				word_length++;
				wordslist.add(list);
			}
			reader.close();
			//This loop checks each word witch every word with length smaller by one if they are "funnelable"
			//if there are 5 words that match then that is our answer
			int number_of_words=0;
			for(int i=1;i<wordslist.size();i++) {
				//Loop for every n-letter word
				for(String s1 : wordslist.get(i)) {
					int number_of_matches=0;
					//loop to compare previous word with every n-1-letter word
					for(String s2 : wordslist.get(i-1)) {
						if(funnel(s1,s2)) {
							number_of_matches++;
							if(number_of_matches>=5) {
								System.out.println(s1);
								number_of_words++;
								break;
							}
						}
					}
				}
			}
			System.out.println(number_of_words);
		}catch (IOException ex) {
			System.out.println("Missing File");
		}
	}
}
