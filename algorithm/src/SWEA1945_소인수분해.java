import java.util.Scanner;

public class SWEA1945_소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] nArray = new int[5];
			int num = sc.nextInt();
			
			while(true) {
				if (num == 1) {
					break;
				}
				
				if (num % 2 == 0) {
					num = num / 2;
					nArray[0]++;
					continue;
				} else if (num % 3 == 0) {
					num = num / 3;
					nArray[1]++;
					continue;
				} else if (num % 5 == 0) {
					num = num / 5;
					nArray[2]++;
					continue;
				} else if (num % 7 == 0) {
					num = num / 7;
					nArray[3]++;
					continue;
				} else if (num % 11 == 0) {
					num = num / 11;
					nArray[4]++;
					continue;
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < nArray.length; i++) {
				System.out.print(nArray[i] + " ");
			}
			System.out.println();
		}		
	}
}