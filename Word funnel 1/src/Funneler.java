import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
		} catch (IOException ex) {
			System.out.println("Missing File");
		}
	}
	
	//--TODO--//
	private void bonus2() {
		return;
	}
}
