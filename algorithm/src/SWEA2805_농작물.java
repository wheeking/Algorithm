import java.util.Scanner;

public class SWEA2805_농작물 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			
			int half = N/2;
			// 가운데 줄
			for (int i = 0; i < N; i++) {
				sum += map[half][i];
			}
			
			// 위 삼각형
			for (int i = 0; i < half; i++) {
				for (int j = half - i; j <= half + i; j++) {
					sum += map[i][j];
				}
			}
			
			// 아래 삼각형
			for (int i = half+1; i < N; i++) {
				for (int j = half - (N-i-1); j <= half + (N-i-1); j++) {
					sum += map[i][j];
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}
}