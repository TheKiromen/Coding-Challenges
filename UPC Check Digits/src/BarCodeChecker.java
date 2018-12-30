import java.util.Scanner;

public class BarCodeChecker {
	Scanner read;
	String input;
	char[] inputdigits;

	
	public static void main(String[] args) {
		BarCodeChecker bcc = new BarCodeChecker();
		bcc.start();
	}
	

	private void start() {
		read=new Scanner(System.in);
		input=read.nextLine();
		read.close();
		if(validate(input)) {
			input=fillCode(input);
			//CALCULATE CHECK DIGIT HERE
		}else {
			System.out.println("Wrong barcode format.");
		}
	}
	
	
	private boolean validate(String barcode) {
		inputdigits=barcode.toCharArray();
		if(inputdigits.length<12) {
			for(char c : inputdigits) {
				if(c<48||c>57) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	private String fillCode(String barcode) {
		String result=barcode;
		while(result.length()<11) {
			result="0"+result;
		}
		return result;
	}
	
	
	private int calculateCheckDigit(String barcode) {
		int result = 0;
		return result;
	}
}
