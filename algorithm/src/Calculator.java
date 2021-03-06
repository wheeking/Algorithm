import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		
//		char[] operator = {'(', '+', '-', '*', '/', ')'};
//		int[] opIsp = {0, 1, 1, 2, 2, -1};	// in-stack
//		int[] opIcp = {3, 1, 1, 2, 2, -1};	// in-coming
//		
		char[] stack = new char[20];
		int top = -1;
		String[] str = sc.nextLine().split(" ");
		
		for (int i = 0; i < str.length; i++) {
			char c = str[i].charAt(0);
			
			switch(c) {		
			case '(' :	
				stack[++top] = c;
				break;
			case '*' :	
			case '/' :	
				while(top >= 0 && (stack[top] == '*' || stack[top] == '/')) {
					// pop
					System.out.print(stack[top--] + " ");
				}
				stack[++top] = c;
				break;
			case '+' :
			case '-' :
				while(top >= 0 && (stack[top] == '*' || stack[top] == '/'
									|| stack[top] == '+' || stack[top] == '-')) {
					// pop
					System.out.print(stack[top--] + " ");
				}
				stack[++top] = c;
				break;
			case ')' :
				while(top >= 0 && stack[top] != '(') {
					System.out.print(stack[top--] + " ");
				}
				if (stack[top] == '(') {	
					top--;
				}
				break;
			default : 
				System.out.print(str[i] + " ");
				break;
			}
		}
		
		while(top >= 0) {
			System.out.print(stack[top--] + " ");
		}
	}
}