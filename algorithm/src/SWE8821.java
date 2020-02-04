import java.util.Scanner;

public class SWE8821 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String numbers = sc.next();
			int count = 0;
			
			int[] check = new int[10];
			
			//numbers.charAt(i) 는 캐릭터. int 로 변환 필요
			for (int i = 0; i < numbers.length(); i++) {
				// char -> int
				int temp = (int)numbers.charAt(i) - 48;
				//System.out.println(temp);
				if (check[temp] == 0) {
					check[temp]++;
				} else if (check[temp] != 0) {
					check[temp]--;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				if (check[i] == 1) {
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
