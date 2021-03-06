import java.util.Scanner;

public class SWEA1233_사칙연산유효성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			int flag = 1;
			
			for (int i = 0; i < N; i++) {
				String temp = sc.nextLine();
				String[] arr = temp.split(" ");
				
				// 자식이 있는데 노드값이 숫자일 때
				if (arr.length > 2 && arr[1].charAt(0) - '0' >= 0 && arr[1].charAt(0) - '0' <= 9) {
					flag = 0;
				}
				// 리프노드인데 노드값이 숫자가 아닐 때
				if (arr.length <= 2 && (arr[1].charAt(0)- '0' < 0 || arr[1].charAt(0) - '0' > 9)) {
					flag = 0;
				}
			}
			
			System.out.println("#" + test_case + " " + flag);
		}
	}
}
