import java.util.Scanner;

public class SWE3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] intArray = new int[N];
			for (int i = 0; i < N; i++) {
				intArray[i] = sc.nextInt();
			}
			
			int max = 0;
			int[] dArray = new int[N];
			for (int i = 0; i < N; i++) {
				if (dArray[i] == 0) dArray[i] = 1;
				for (int j = 0; j < i; j++) {
					if (intArray[i] >= intArray[j]) {
						if (dArray[i] <= dArray[j] + 1) {
							dArray[i] = dArray[j] + 1;
						}	
					}
				}
				// 이 부분을 놓쳐서 실패함. 마지막값이 가장 큰게 아님.
				if (dArray[i] > max) {
					max = dArray[i];
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}