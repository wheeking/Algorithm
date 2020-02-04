import java.util.Scanner;

public class SWEA1288_양세기{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String N = sc.next();
			int[] check = new int[10];
			int ans = 0;
			int temp = Integer.parseInt(N);
			int cnt = 1;
			int firstTemp = temp;
			while (true) {
				
				for (int i = 0; i < N.length(); i++) {
					char ch = N.charAt(i);
					if (check[ch-'0'] == 1) continue;
					else check[ch-'0'] = 1;
				}
				
				int sum = 0;
				for (int i = 0; i < check.length; i++) {
					sum += check[i];
				}
				if (sum == 10) {
					break;
				}			
				
				temp = cnt*firstTemp;
				cnt++;
				
				N = Integer.toString(temp);
				ans = temp;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}		
	}
}