import java.util.Scanner;

public class SWEA2001_파리퇴치 {
	public static int[][] map;
	public static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			map = new int[N][N];
			max = 0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i <= map.length - M; i++) {
				for (int j = 0; j <= map[i].length - M; j++) {
					int temp = killFF(i, j, M);
					if (temp > max)
						max = temp;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	public static int killFF(int i, int j, int k) {
		int ans = 0;
		
		for (int l = i; l < i + k; l++) {
			for (int l2 = j; l2 < j + k;l2++) {
				ans += map[l][l2];
			}
		}
		
		return ans;
	}
}
