import java.util.Arrays;
import java.util.Scanner;

public class IM1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			
			for (int i = 1; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int[] compare = new int[N+1];
			
			int cnt = 0;
			int flag = 0;
				
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != compare[i]) {
					led(compare, i);
					cnt++;
					if (Arrays.equals(arr, compare)) {
						flag = 1;
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	public static void led(int[] arr, int x) {
		for (int j = x; j < arr.length; j++) {
			if (j%x == 0) {
				if (arr[j] == 1)
					arr[j] = 0;
				else
					arr[j] = 1;
			}
		}
	}
}
