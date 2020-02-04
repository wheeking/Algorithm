import java.util.Scanner;

public class SWE9317 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					ans++;
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}