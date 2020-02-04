import java.util.Scanner;

public class SWEA5549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			
			String ans;
			int last = str.charAt(str.length()-1) - '0';
			if (last%2 == 1) {
				ans = "Odd";
			} else ans = "Even";
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}