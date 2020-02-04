import java.util.Scanner;

public class SWEA7102_준홍이카드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();		// 1번부터 N
			int M = sc.nextInt();		// 1번부터 M
			int[] nmSum = new int[N + M + 1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int sum = i + j;
					nmSum[sum]++;
				}
			}
			
			int max = 0;
			for (int i = 0; i < nmSum.length; i++) {
				if (nmSum[i] > max) {
					max = nmSum[i];
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < nmSum.length; i++) {
				if (nmSum[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}