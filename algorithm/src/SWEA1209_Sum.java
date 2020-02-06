import java.util.Arrays;
import java.util.Scanner;

public class SWEA1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 100;
		
		for (int tc = 1; tc <= 10; tc++ ) {
			sc.nextInt();
			int[] sumArr = new int[len+len+2];
			int[][] map = new int[len][len];
			
			// 입력
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 각 행 합계
			int sum = 0;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					sum += map[i][j];
					sumArr[i] = sum;
				}
			}
			
			// 각 열 합계
			sum = 0;
			for (int j = 0; j < len; j++) {
				for (int i = 0; i < len; i++) {
					sum += map[i][j];
					sumArr[j + len] = sum;
				}
			}
			
			// 대각선 합계
			sum = 0;
			for (int i = 0; i < len; i++) {
				sum += map[i][i];
				sumArr[sumArr.length-2] = sum;
			}
			sum = 0;
			for (int i = 0; i < len; i++) {
				sum += map[i][len-i-1];
				sumArr[sumArr.length-1] = sum;
			}
			
			System.out.println(Arrays.toString(sumArr));
			Arrays.sort(sumArr);
			
			System.out.println("#" + tc + " " + sumArr[1]);
		}
		
	}
}
