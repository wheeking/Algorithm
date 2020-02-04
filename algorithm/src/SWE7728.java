import java.util.Scanner;

// 7728 다양성 측정
public class SWE7728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String num = sc.next();
			int[] check = new int[10];
			
			for (int i = 0; i < num.length(); i++) {
				int intNum = (int)num.charAt(i) - 48;
				if (check[intNum] != 1) {
					check[intNum] = 1;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				if (check[i] == 1) {
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
