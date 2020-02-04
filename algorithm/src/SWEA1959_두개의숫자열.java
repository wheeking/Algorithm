import java.util.Scanner;

public class SWEA1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] nArr = new int[N];
			int[] mArr = new int[M];
			
			for (int i = 0; i < N; i++) {
				nArr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				mArr[i] = sc.nextInt();
			}
			
			int gap = 0;
			int[] sumN = new int[N];
			if (N < M) {
				gap = M-N;
				
				for (int i = 0; i < nArr.length; i++) {
					for (int j = i; j <= i + gap; j++) {
						
					}
				}
			} else {
				
			}
		}
	}
}
