import java.util.ArrayList;
import java.util.Arrays;

public class Balancer {

	public static void main(String[] args) {
		Balancer b = new Balancer();
		b.start();
	}
	
	private void start() {
		System.out.println(balanced("xxxyyy"));
		System.out.println(balanced("yyyxxx"));
		System.out.println(balanced("xxxyyyy"));
		System.out.println(balanced("yyxyxxyxxyyyyxxxyxyx"));
		System.out.println(balanced("xyxxxxyyyxyxxyxxyy"));
		System.out.println(balanced(""));
		System.out.println(balanced("x"));
		System.out.println(balanced_bonus("xxxyyyzzz"));
		System.out.println(balanced_bonus("abccbaabccba"));
		System.out.println(balanced_bonus("xxxyyyzzzz"));
		System.out.println(balanced_bonus("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(balanced_bonus("pqq"));
		System.out.println(balanced_bonus("fdedfdeffeddefeeeefddf"));
		System.out.println(balanced_bonus("www"));
		System.out.println(balanced_bonus("x"));
		System.out.println(balanced_bonus(""));
	}
	
	private boolean balanced(String input) {
		int x=0,y=0;
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='x') {
				x++;
			}else {
				y++;
			}
		}
		
		return x==y;
	}
	
	
	private boolean balanced_bonus(String input) {
		//---TODO---//
		
		return false;
	}
}
