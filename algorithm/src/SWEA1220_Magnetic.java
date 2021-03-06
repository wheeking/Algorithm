import java.util.Scanner;

public class SWEA1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			int[][] map = new int[len][len];
			
			// 입력. 1:N,  2:S  위:N 아래:S
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			int flag = 0;	// N 찾았을 때 플래그 1
			
			for (int i = 0; i < len; i++) {
				ans += check(map, i);
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	public static int check(int[][] arr, int i) {
		int sum = 0;
		boolean flag = false;
		
		for (int j = 0; j < arr.length; j++) {
			if(arr[j][i] == 1) {
				flag = true;
			} else if(flag && arr[j][i] == 2) {
				sum++;
				flag = false;
			}
		}
		return sum;
	}
		
}

