import java.util.Scanner;

public class SWE1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 0; test_case < 10; test_case++) {
			int[][] map = new int[100][100];
			int testNum = sc.nextInt();
			int r2 = 0;		// 도착지점 열 좌표
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				if (map[map.length-1][i] == 2) {
					r2 = i;
				}
			}
			
			int x = map.length - 1;
			int y = r2;				// 도착점 좌표
			int dirFlag = 0;		// 위 or 사이드 방향 위 = 0, 왼쪽 -1, 오른쪽 1
			int ans = 0;
			
			while(true) {
				if (x == 0) {
					ans = y;
					break;
				}
				// 위로 올라가고 있을 때  (y의 range 주의, 비교해야함 ) 
				if (dirFlag == 0) {
					if (y != 0 && map[x][y-1] == 1) {
						y--;
						dirFlag = -1;
					} else if (y != 99 && map[x][y+1] == 1) {
						y++;
						dirFlag = 1;
					} else {
						x--;
					}
					continue;
				}
				// 왼쪽으로 가고 있을 때
				if (dirFlag == -1) {
					if (map[x-1][y] == 1) {
						x--;
						dirFlag = 0;
					} else if (map[x][y-1] == 1) {
						y--;
					}
					continue;
				}
				// 오른쪽으로 가고 있을 때
				if (dirFlag == 1) {
					if (map[x-1][y] == 1) {
						x--;
						dirFlag = 0;
					} else if (map[x][y+1] == 1) {
						y++;
					}
					continue;
				}
			}
			System.out.println("#" + testNum + " " + ans);
		}
	}
}
