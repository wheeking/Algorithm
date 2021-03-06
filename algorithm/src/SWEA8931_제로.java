import java.util.Scanner;

public class SWEA8931_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			
			for (int i = 0; i < K; i++) {
				arr[i] = sc.nextInt();
			}
			
			int top = -1;
			int[] stack = new int[K];
			
			for (int i = 0; i < K; i++) {
				if (arr[i] != 0) {
					stack[++top] = arr[i];
				} else {
					stack[top] = arr[i];
					top--;
				}
			}
			
			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += stack[i];
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}