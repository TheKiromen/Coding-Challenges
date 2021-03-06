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
			System.out.println("Check digit is: "+calculateCheckDigit(input));
			input+=calculateCheckDigit(input);
			System.out.println("\nThe full barcode is: "+input);
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
		int odd = 0;
		int even = 0;
		inputdigits=barcode.toCharArray();
		for(int i=0;i<inputdigits.length;i++) {
			if(i%2==0) {
				odd+=(int)inputdigits[i]-48;
			}else {
				even+=(int)inputdigits[i]-48;
			}
			
		}
		odd=odd*3;
		result=odd+even;
		result=result%10;
		if(result>0) {
			result=10-result;
		}
		return result;
	}
}
