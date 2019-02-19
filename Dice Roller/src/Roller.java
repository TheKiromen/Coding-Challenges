import java.util.ArrayList;
import java.util.Scanner;

public class Roller {

	public static void main(String[] args) {
		Roller r = new Roller();
		r.roll();
	}

	private void roll() {
		Scanner read = new Scanner (System.in);
		String input,result="";
		int num_of_rolls;
		int sides,sum=0;
		Double roll;
		
		//Without validation
		input = read.nextLine();
		num_of_rolls=Integer.parseInt(input.substring(0,input.indexOf('d')));
		sides=Integer.parseInt(input.substring(input.indexOf('d')+1,input.length()));
		read.close();
		
		if((num_of_rolls>=1&&num_of_rolls<=100)
			&&(sides>=2&&sides<=100)) {
			
			for(int i=0;i<num_of_rolls;i++) {
				roll=Math.random()*sides+1;
				sum+=roll.intValue();
				result+=(Integer.toString(roll.intValue())+" ");
			}
			result=Integer.toString(sum)+": "+result;

		}else {
			return;
		}
		
		
		System.out.println(result);
		
	}
	
}
