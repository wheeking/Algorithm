import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1222_계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int len = sc.nextInt();
			String str = sc.next();
			
			ArrayList<Integer> stack = new ArrayList<Integer>();
			int top = -1;
			
			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				if (ch != '+') {
					stack.add(++top, ch - '0');
				}
			}
			
			int sum = 0;
			
			for (int i = 0; i < stack.size(); i++) {
				sum += stack.get(top--);
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}