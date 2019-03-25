import java.util.Arrays;

public class Solver {

	public static void main(String[] args) {
		Solver s = new Solver();
		s.run();
	}
	
	private void run() {
		int input[][] = {{1,5,7,9,9},{1,2,1,2,1,0},{10,12,41,62,31,50},{10,12,41,62,31}};
		solve(input[0]);
		solve(input[1]);
		solve(input[2]);
		solve(input[3]);
	}
	
	private void solve(int numbers[]) {
		int num_of_zeros=0,steps=-1,tmp,infinite_check=0;
		while(num_of_zeros!=numbers.length&&infinite_check<100) {
			infinite_check++;
			System.out.println(Arrays.toString(numbers));
			num_of_zeros=0;
			steps++;
			tmp=numbers[0];
			for(int i=0;i<numbers.length-1;i++) {
				numbers[i]=Math.abs(numbers[i]-numbers[i+1]);
				
				if(numbers[i]==0) {
					num_of_zeros++;
				}
			}
			numbers[numbers.length-1]=Math.abs(numbers[numbers.length-1]-tmp);
			if(numbers[numbers.length-1]==0) {
				num_of_zeros++;
			}
			steps++;
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(steps+" steps");
	}

}
