
import java.util.Scanner;

public class SWE5215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 재료의 수
			int L = sc.nextInt(); // 제한 칼로리
			int[] score = new int[N];
			int[] cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
		}
		sc.close();
	}
}
