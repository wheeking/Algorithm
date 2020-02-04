import java.util.Scanner;

public class SWEA6913_프로그래밍대회 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] proMap = new int[N][M];
			int[] pass = new int[N];
			
			for (int i = 0; i < proMap.length; i++) {
				int iSum = 0;	// 개개인 총합->pass배열에 저장
				for (int j = 0; j < proMap[i].length; j++) {
					proMap[i][j] = sc.nextInt();
					if (proMap[i][j] == 1) {
						iSum++;
					}
				}
				pass[i] = iSum;
			}
			
			int max = 0;		// 푼 문제 수
			int cnt = 0;		// 1등한 사람 수
			for (int i = 0; i < pass.length; i++) {
				if (pass[i] >= max) {
					max = pass[i];
				}
			}
			
			for (int i = 0; i < pass.length; i++) {
				if (pass[i] == max)
					cnt++;
			}
			
			System.out.println("#" + test_case + " " + cnt + " " + max);
		}		
	}
}