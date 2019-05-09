import java.util.ArrayList;
import java.util.Arrays;

public class Balancer {

	public static void main(String[] args) {
		Balancer b = new Balancer();
		b.start();
	}
	
	private void start() {
		System.out.println("---BASIC CHALLENGE---");
		System.out.println(balanced("xxxyyy"));
		System.out.println(balanced("yyyxxx"));
		System.out.println(balanced("xxxyyyy"));
		System.out.println(balanced("yyxyxxyxxyyyyxxxyxyx"));
		System.out.println(balanced("xyxxxxyyyxyxxyxxyy"));
		System.out.println(balanced(""));
		System.out.println(balanced("x"));
		System.out.println("---BONUS CHALLENGE---");
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
		ArrayList<MyChar> apperances = new ArrayList<MyChar>();
		char [] chars=input.toCharArray();
		int index=0;

		if(input.length()<2) {
			return true;
		}else {
			Arrays.parallelSort(chars);
			apperances.add(new MyChar(chars[0]));
			for(int i=0;i<chars.length-1;i++) {
				if(chars[i]==chars[i+1]) {
					apperances.get(index).increment();
				}else {
					apperances.add(new MyChar(chars[i+1]));
					index++;
				}
			}
			
			for(int i=1;i<apperances.size();i++) {
				if(apperances.get(0).getApperances()!=apperances.get(i).getApperances()) {
					return false;
				}
			}
			
			return true;
		}
	}
}
