package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListTest {
	
	public static void main(String[] args) {
		
		// List of는 자바 9이상
		//ArrayList<String> friends = new ArrayList<>(List.of("Peter", "Paul"));
		ArrayList<String> friends = new ArrayList<>(Arrays.asList("Peter", "Paul"));
		
		friends.remove(1);
		friends.add(0, "Paul");
		
		friends.set(1, "Mary");
		
		
		for(String s : friends) {
			System.out.println(s);
		}
		
		int [] primes = new int[] {99,2,6,3,5,10,7,11,42};
		int [] numbers = primes;
		
		// primes, numbers 배열 모두 같은 값을 공유함
		System.out.println("배열  이전 : " + primes[5]);
		numbers[5] = 50;
		System.out.println("배열  수정 : " + numbers[5]);
		System.out.println("배열  수정 : " + primes[5]);
		// 값 다시 복구
		primes[5] = 10; 
		System.out.println("다시 복구 : " + primes[5]);
		System.out.println("다시 복구 : " + numbers[5]);
		
		numbers = Arrays.copyOf(primes, primes.length);
		numbers[5] = 50;
		System.out.println("Arrays.copyOf 사본 공유 안함: " + primes[5]);
		System.out.println("Arrays.copyOf 사본 공유 안함: " + numbers[5]);
		
		System.out.println("------------------ 리스트 -------------------");
		
		for(String s : friends) {
			System.out.println(s);
		}
		ArrayList<String> people = friends;
		people.set(0, "Paul2");
		for(String s : friends) {
			System.out.println(s);
		}
		for(String s : people) {
			System.out.println(s);
		}
		// 복구
		people.set(0, "Paul");
		
		people = new ArrayList<String>(friends);
		people.set(0, "Paul2");
		for(String s : friends) {
			System.out.println(s);
		}
		for(String s : people) {
			System.out.println(s);
		}
		
		System.out.println("---- List.of 사용 ----");
		//people = new ArrayList<String>(List.of(new String[] {"Paul3","Mary"}));
		people = new ArrayList<String>(Arrays.asList(new String[] {"Paul3","Mary"}));
		for(String s : friends) {
			System.out.println(s);
		}
		for(String s : people) {
			System.out.println(s);
		}
		
		System.out.println("---- toArray 배열 사용 ----");
		String[] names = friends.toArray(new String[0]);
		for(String s : names) {   
			System.out.println(s);
		}
		
		
		System.out.println(Arrays.toString(primes));
		Arrays.parallelSort(primes);
		System.out.println(Arrays.toString(primes));
		
		
		System.out.println("----- 정렬 전 -----");
		friends.add("C3");
		friends.add("A1");
		friends.add("B2");
		System.out.println(friends.toString());
			
		System.out.println("----- 정렬 후 -----");
		Collections.sort(friends);
		System.out.println(friends.toString());
		
		System.out.println("----- reverse -----");
		Collections.reverse(friends);
		System.out.println(friends.toString());
		
		System.out.println("----- suffle -----");
		Collections.shuffle(friends);
		System.out.println(friends.toString());
		
		
		int n = 7;
		int[][] triangle = new int[n][];
		for(int i=0; i < n; i++) {
			triangle[i] = new int[i+1];
			triangle[i][0] = 1; // 1차원 배열 시작
			triangle[i][i] = 1; // 1차원 배열 끝
			for(int j = 1; j < i; j++) {
				// 1차배열 시작과 끝을 제외한 중앙 값
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			}
		}
		
		System.out.println(Arrays.deepToString(triangle));
		// for(int r = 0; r < triangle.length; r++) {
		// 	for(int c = 0; c < triangle[r].length; c++) {
		// 		System.out.printf("%4d", triangle[r][c]);
		// 	}
		// 	System.out.println();
		// }
		// for(int[] row : triangle) {
		// 	for(int element : row) {
		// 		System.out.printf("%4d", element);
		// 	}
		// 	System.out.println();
		// }
		
	}

}
