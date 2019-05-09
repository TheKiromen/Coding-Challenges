public class MyChar {

	private char chr;
	private int apperances;
	
	public MyChar(char c) {
		chr=c;
		apperances=1;
	}
	
	public char getChar() {
		return chr;
	}
	
	public int getApperances() {
		return apperances;
	}
	
	public void increment() {
		apperances++;
	}
	
}
