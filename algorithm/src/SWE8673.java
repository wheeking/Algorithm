import java.util.Scanner;

// 8673 코딩 토너먼트
public class SWE8673 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			int e = (int) Math.pow(2, K);
			int[] Arr = new int[e];
			
			for (int i = 0; i < e; i++) {
				Arr[i] = sc.nextInt();
			}
			
			int sum = 0;
			for (int i = 0; i < e - 1; i++) {
				sum += Math.abs(Arr[i] - Arr[i+1]);
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
