import java.util.Arrays;
import java.util.Scanner;

public class SWEA6719_성수의프로그래밍강좌시청 {
	public static int[] nArr;
	public static int[] tArr;
	public static double ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			// N C K 조합
			int N = sc.nextInt();
			int K = sc.nextInt();
			nArr = new int[N];	// 강좌 어레이
			tArr = new int[K];	// 선택강좌 어레이
			
			for (int i = 0; i < N; i++) {
				nArr[i] = sc.nextInt();
			}
//			comb(N, K);
	
			Arrays.sort(nArr);
			
			for (int i = 0; i < tArr.length; i++) {
				tArr[i] = nArr[nArr.length-i-1];
			}
			Arrays.sort(tArr);
			double score = 0;	// 시작 점수
			for (int i = 0; i < tArr.length; i++) {
				score = (score + tArr[i]) / 2;
			}
			
			System.out.printf("#%d %.6f", test_case, score);
			System.out.println();
		}
	}
	
//	public static void comb(int N, int K) {
//		if (K == 0) {		// tArr 경우마다 완성 시 할 일.
//			int[] temp = new int[tArr.length];
//			temp = tArr.clone();
//			Arrays.sort(temp);
//			double score = 0;	// 시작 점수
//			for (int i = 0; i < tArr.length; i++) {
//				score = (score + temp[i]) / 2;
//			}
//			
//			if (score > ans)
//				ans = score;
//		} else if (N < K) {
//			return;
//		} else {
//			tArr[K-1] = nArr[N-1];
//			comb(N-1, K-1);
//			comb(N-1, K);
//		}
//	}
}
