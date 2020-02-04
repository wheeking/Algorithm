import java.util.Scanner;

// 5601 쥬스 나누기
public class SWE5601 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			String Nstr = Integer.toString(N);
			String str = "1/" + Nstr;
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}