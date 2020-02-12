import java.util.Scanner;

public class SWEA1873_상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			
			for (int i = 0; i < map.length; i++) {
				String temp = sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			
			int N = sc.nextInt();
			String orderTemp = sc.next();
			char[] order = new char[N];
			for (int i = 0; i < N; i++) {
				order[i] = orderTemp.charAt(i);
			}
			
			execution(map, order);
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static void execution (char[][] map, char[] order) {
		int[] loc = new int[2]; // 0번지 x 1번지 y
		int dir;
		// 전차 위치 찾기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				dir = dirOfTank(map[i][j]);
				if (dir != 0) {
					loc[0] = i;
					loc[1] = j;
				}
			}
		}
		// 현재 탱크 위치, (x, y) 방향 dir
		
		for (int i = 0; i < order.length; i++) {
			char temp = order[i];
			switch (temp) {
			case 'S':
				shoot(map, loc);
				break;
			default:
				move(map, temp, loc);
				break;
			}
		}
	}
	
	// 슛! 탱크 방향. 1:상 2:하 3:좌 4:우
	public static void shoot(char[][] map, int[] loc) {
		int x = loc[0];
		int y = loc[1];
		// 탱크 방향
		int dir = dirOfTank(map[x][y]);
		
		switch (dir) {
			case 1:
				for (int i = x-1; i >= 0; i--) {
					if (map[i][y] == '#')
						break;
					if (map[i][y] == '*') {
						map[i][y] = '.';
						break;
					}
				}
				break;
			case 2:
				for (int i = x+1; i < map.length; i++) {
					if (map[i][y] == '#')
						break;
					if (map[i][y] == '*') {
						map[i][y] = '.';
						break;
					}
				}
				break;
			case 3:
				for (int i = y-1; i >= 0; i--) {
					if (map[x][i] == '#')
						break;
					if (map[x][i] == '*') {
						map[x][i] = '.';
						break;
					}
				}
				break;
			case 4:
				for (int i = y+1; i < map[0].length; i++) {
					if (map[x][i] == '#')
						break;
					if (map[x][i] == '*') {
						map[x][i] = '.';
						break;
					}
				}
				break;
		}
	}
	
	// 탱크 이동
	public static void move(char[][] map, char ch, int[] loc) {
		// 탱크 위치
		int x = loc[0];
		int y = loc[1];
		
		switch (ch) {
			case 'U':
				map[x][y] = '^';
				// 위로 이동할 수 있는 평지일 때
				if (x-1 >= 0 && map[x-1][y] == '.') {
					map[x-1][y] = '^';
					map[x][y] = '.';
					loc[0] = x-1;
				}
				break;
			case 'D':
				map[x][y] = 'v';
				if (x+1 < map.length && map[x+1][y] == '.') {
					map[x+1][y] = 'v';
					map[x][y] = '.';
					loc[0] = x+1;
				}
				break;
			case 'L':
				map[x][y] = '<';
				if (y-1 >= 0 && map[x][y-1] == '.') {
					map[x][y-1] = '<';
					map[x][y] = '.';
					loc[1] = y-1;
				}
				break;
			case 'R':
				map[x][y] = '>';
				if (y+1 < map[0].length && map[x][y+1] == '.') {
					map[x][y+1] = '>';
					map[x][y] = '.';
					loc[1] = y+1;
				}
				break;
		}
	}
	
	public static int dirOfTank(char ch) {
		switch (ch) {
			case '^':
			
				return 1;
			case 'v':
			
				return 2;
			case '<':
				
				return 3;
			case '>':
				
				return 4;
			default:
				return 0;
		}
	}
}
