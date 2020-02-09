import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1234_비밀번호 {
	public static int N = 0;
	public static ArrayList<Character> list = new ArrayList<Character>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt();
			String str = sc.next();
			list.clear();
			
			for (int i = 0; i < N; i++) {
				list.add(str.charAt(i));
			}
			
			delete(0);
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
	
	public static void delete(int s) {
		for (int i = s; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i+1)) {
				list.remove(i);
				//z 크기가 작아지니까 
				list.remove(i);
				// 종료 조건
				if (i==0)
					return;
				delete(i-1);
			}
		}
	}
}