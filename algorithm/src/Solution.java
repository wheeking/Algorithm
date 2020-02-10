import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String date = sc.next();
			String ans = "";
			
			String year = date.substring(0, 4);
			
			String month = date.substring(4, 6);
			int temp = Integer.parseInt(month);
			if (temp%100 > 12 || temp%100 == 0) {
				ans = "-1";
				System.out.println("#" + test_case + " " + ans);
				continue;
			}
			
			String day = date.substring(6, 8);
			int iDay = Integer.parseInt(day);
			if (temp == 2 && (iDay == 0 || iDay > 28)) {
				ans = "-1";
				System.out.println("#" + test_case + " " + ans);
				continue;
			}
			
			if ((temp == 1 || temp == 3 || temp == 5 || temp == 7 || temp == 8 || temp == 10 || temp ==12) && (iDay==0 || iDay>31)) {
				ans = "-1";
				System.out.println("#" + test_case + " " + ans);
				continue;
			}
			
			if ((temp == 9 || temp == 11 || temp == 4 || temp == 6) && (iDay == 0 || iDay > 30)) {
				ans = "-1";
				System.out.println("#" + test_case + " " + ans);
				continue;
			}
			
			System.out.println("#" + test_case + " " + year + "/" + month + "/" + day);
		}
	}
}

