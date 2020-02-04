import java.util.Scanner;

public class SWE1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int a = sc.nextInt();
			int[] intArray = new int[1000];
			int[] check = new int[1000];
			int[] score = new int[101];
			for (int i = 0; i < 1000; i++) {
				intArray[i] = sc.nextInt();
			}
			
			for (int i = 0; i < 1000; i++) {
				int count = 0;
				for (int j = 0; j < 1000; j++) {
					if (check[i] == 0 && intArray[i] == intArray[j]) {
						check[j] = 1;
						count++;
						score[intArray[i]] = count;
					}
				}
			}
			int max = 0;
			int ans = 0;
			for (int i = 0; i < 101; i++) {
				
				if (score[i] >= max) {
					max = score[i];
					ans = i;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
