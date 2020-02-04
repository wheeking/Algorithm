import java.util.Scanner;

public class SWEA2369_Theater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] gap = new int[N];
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				gap[i] = end - start + 1;
			}
			
			int sum = 0;
			for (int i = 0; i < gap.length; i++) {
				sum += gap[i];
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
