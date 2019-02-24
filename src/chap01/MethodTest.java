package chap01;

public class MethodTest {
	
	public static void main(String[] args) {
		
		System.out.println(average(1.3, 1.7, 3.0));
		
	}
	
	// public static double average(double x, double y) {
	// 	double sum = x + y;
	// 	return sum / 2;
	// }
	
	public static double average(double... values) {
		double sum = 0;
		for(double v : values) {
			sum+=v;
		}
		return values.length == 0 ? 0 : sum / values.length;
	}
	
	public static double max(double first, double... rest) {
		double result = first;
		for(double v : rest)
			result = Math.max(v, result);
		return result;
	}

}
