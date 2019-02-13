
public class Solver {

	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve(13));
		System.out.println(s.solve(1234));
		System.out.println(s.solve(9876));
		System.out.println(s.solve(199));
	}

	//Solution without using strings (bonus)
	private int solve(int number) {
		int steps=0;
		int tmp=number;
		while(tmp/10!=0) {
			tmp=0;
			//Sums digits
			while(number!=0) {
				tmp+=number%10;
				number/=10;
			}
			number=tmp;
			steps++;
		}
		return steps;
	}
	
}
