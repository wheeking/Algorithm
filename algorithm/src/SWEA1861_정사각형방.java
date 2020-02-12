import java.util.Scanner;

public class SWEA1861_정사각형방 {
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int max = 1;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max = 0;
			int ans = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					count = 1;
					move(map, i, j);
					if (count > max) {
						max = count;
						ans = map[i][j];
					} else if (count == max) {
						if (map[i][j] < ans)
							ans = map[i][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + ans + " " + max);
		}
	}
	
	public static void move(int[][] map, int x, int y) {
		for (int k = 0; k < 4; k++) {
			int newX = x + dx[k];
			int newY = y + dy[k];
			if (newX >= 0 && newY >= 0 && newX < map.length && newY < map.length) {
				if (map[newX][newY] == map[x][y] + 1) {
					move(map, newX, newY);
					count++;
				}
			}
		}
	}
}