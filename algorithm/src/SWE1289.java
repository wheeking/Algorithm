import java.util.Scanner;

public class SWE1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			String bit = sc.next();
			
			int i;
			for (i = 0; i < bit.length(); i++) {
				if (bit.charAt(i) == '1') {
					ans++;
					break;
				}
			}
			
			for (int j = i; j < bit.length() - 1; j++) {
				if (bit.charAt(j) != bit.charAt(j + 1)) {
					ans++;
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		sc.close();
	}
}