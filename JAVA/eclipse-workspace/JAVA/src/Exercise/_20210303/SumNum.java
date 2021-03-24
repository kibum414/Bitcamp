package Exercise._20210303;

public class SumNum {
	private String str;
	private int strLen;
	
	private int num;
	
	private int sum;
	
	public SumNum(String str) {
		this.str = str;
		strLen = str.length();
		sum = 0;

		for (int i = 0; i < strLen; i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
	}

	public SumNum(int num) {
		this.num = num;
		sum = 0;
		
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
	}
	
	public void printSum() {
		System.out.println("총합 : " + sum);
	}
}
