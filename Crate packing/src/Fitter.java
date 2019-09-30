
public class Fitter {

	public static void main(String[] args) {
		
		Fitter f = new Fitter();
		
		f.fit1(25, 18, 6, 5);
		f.fit1(10, 10, 1, 1);
		f.fit1(12, 34, 5, 6);
		f.fit1(12345, 678910, 1112, 1314);
		f.fit1(5, 100, 6, 1);
		
		System.out.println();
		
		f.fit2(25, 18, 6, 5);
		f.fit2(12, 34, 5, 6);
		f.fit2(12345, 678910, 1112, 1314);
		f.fit2(5, 5, 3, 2);
		f.fit2(5, 100, 6, 1);
		f.fit2(5, 5, 6, 1);
		
		System.out.println();
		
		f.fit3(10, 10, 10, 1, 1, 1);
		f.fit3(12, 34, 56, 7, 8, 9);
		f.fit3(123, 456, 789, 10, 11, 12);
		f.fit3(1234567, 89101112, 13141516, 171819, 202122, 232425);

	}
	
	private void fit1(int containerX, int containerY, int boxX, int boxY) {
		int result = 0;
		result = Math.floorDiv(containerX, boxX) * Math.floorDiv(containerY, boxY);
		System.out.println(result);
	}
	
	
	//Could be done using fit1, just sawp boxX, boxY and make it return result
	private void fit2(int containerX, int containerY, int boxX, int boxY) {
		int result = 0;
		int tmp;
		
		result = Math.floorDiv(containerX, boxX) * Math.floorDiv(containerY, boxY);
		tmp=Math.floorDiv(containerX, boxY) * Math.floorDiv(containerY, boxX);
		if(tmp>result) {
			result = tmp;
		}
		System.out.println(result);
	}
	
	
	private void fit3(int containerX, int containerY, int containerZ, int boxX, int boxY, int boxZ) {
		int result = 0;
		int tmp;
		
		result = Math.floorDiv(containerX, boxX) * Math.floorDiv(containerY, boxY) * Math.floorDiv(containerZ, boxZ);
		tmp = Math.floorDiv(containerX, boxZ) * Math.floorDiv(containerY, boxX) * Math.floorDiv(containerZ, boxY);
		if(tmp > result) {
			result=tmp;
		}
		tmp=Math.floorDiv(containerX, boxY) * Math.floorDiv(containerY, boxZ) * Math.floorDiv(containerZ, boxX);
		if(tmp > result) {
			result=tmp;
		}
		
		System.out.println(result);
	}
	

}
