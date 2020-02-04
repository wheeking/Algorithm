
import java.util.Scanner;

public class SWE6730 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] blocks = new int[N];
			int[] dUp = new int[N];
			int[] dDown = new int[N];
			
			for (int i = 0; i < N; i++) {
				blocks[i] = sc.nextInt();
			}
			
			for (int i = 0; i < blocks.length - 1; i++) {
				if (blocks[i+1] > blocks[i]) {
					dUp[i] = blocks[i+1] - blocks[i];
				} 
				if (blocks[i+1] < blocks[i]) {
					dDown[i] = blocks[i] - blocks[i+1];
				}
			}

			int max = 0;
			int min = 0;
			for (int i = 0; i < N; i++) {
				if (dUp[i] > max) {
					max = dUp[i];
				}
				if (dDown[i] > min) {
					min = dDown[i];
				}
			}
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}
