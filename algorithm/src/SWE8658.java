import java.io.IOException;
import java.util.Scanner;

public class SWE8658 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] sArr = new String[10];
			int[] sumArr = new int[10];
			int max = 0;
			int min = 0;
			
			for (int i = 0; i < sArr.length; i++) {
				sArr[i] = sc.next();
				for (int j = 0; j < sArr[i].length(); j++) {
					sumArr[i] += (sArr[i].charAt(j) - '0');
				}
			}
			
			min = sumArr[0];
			for (int i = 0; i < sumArr.length; i++) {
				if (sumArr[i] > max) {
					max = sumArr[i];
				}
				if (sumArr[i] < min) {
					min = sumArr[i];
				}
			}
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}