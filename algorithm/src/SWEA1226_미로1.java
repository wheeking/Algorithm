import java.util.Scanner;

class Pair3 {
	int x, y;
	
	Pair3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class SWEA1226_미로1 {
	public static int[][] map = new int[16][16];
	public static int[][] visited = new int[16][16];
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			ans = 0;
			visited = new int[16][16];
			sc.nextInt();
			Pair3 start = new Pair3(0, 0);
			Pair3 end = new Pair3(0, 0);
			// 입력
			for (int i = 0; i < 16; i++) {
				String temp = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = temp.charAt(j) - '0';
					if (map[i][j] == 2) {
						start = new Pair3(i, j);
					}
				}
			}
			// 탐색
			dfs(start);
			System.out.println("#" + test_case + " " + ans);
		}
	} // end of main
	
	public static void dfs(Pair3 start) {
		visited[start.x][start.y] = 1; 
		// 길 있으면 1 없으면 0
		if (map[start.x][start.y] == 3) {
			ans = 1;
			return;
		}
		for (int i = 0; i < dx.length; i++) {
			int newX = start.x + dx[i];
			int newY = start.y + dy[i];
			if (newX >= 0 && newY >= 0 && newX < 16 && newY < 16) {
				if (visited[newX][newY] == 0 && map[newX][newY] != 1) {
					visited[newX][newY] = 1;
					Pair3 newP = new Pair3(newX, newY);
					dfs(newP);
				}
			}
		}
	}
}