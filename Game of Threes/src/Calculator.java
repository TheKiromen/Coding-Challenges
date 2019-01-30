import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.start();
	}

	public void start() {
		Scanner input = new Scanner(System.in);
		int data = input.nextInt();
		calculate(data);
	}
	
	void calculate(int number) {
		int mod;
		while(number>1) {
			mod=number%3;
			if(mod==0) {
				System.out.println(number+" 0");
				number/=3;
			}else if(mod==1) {
				System.out.println(number+" -1");
				number--;
			}else{
				System.out.println(number+" +1");
				number++;
			}
		}
		System.out.println(number);
	}
}
