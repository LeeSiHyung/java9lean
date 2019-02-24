package chap01;

public class StringTest {
	
	public static void main(String[] args) {
		
		int n = 42;
		String str = Integer.toString(n);
		System.out.println(str);
		
		// 기수변환 10진수를 2진수로
		String str2 = Integer.toString(n, 2);
		System.out.println(str2);
		
		str = "101010";
		n = Integer.parseInt(str);
		System.out.println(n);
		
		// 기수변환 2진수를 10진수로
		int n2 = Integer.parseInt(str, 2);
		System.out.println(n2);
		
		str = Double.toString(3.14);
		System.out.println(str);
		
		double x = Double.parseDouble(str);
		System.out.println(x);
		
		// 8은 총 8자리(.포함) .2f는 고정 부동소수점 두자리
		System.out.printf("%8.2f", 1000.0 / 3.0);
		
		System.out.println();
		
		System.out.printf("%,+.2f", 100000.0 / 3.0);
		
	}

}
