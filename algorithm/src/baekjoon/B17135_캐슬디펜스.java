package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// visited 초기화를 잘하자......................................................................

public class B17135_캐슬디펜스 {
	public static int[][] map;
	public static int[][] temp;
	public static int[][] visited;	// 같은 적 비교 판단
	public static int N;
	public static int M;
	public static int D;
	public static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());		// 행의 개수 N
		M = Integer.parseInt(st.nextToken());		// 행의 개수 N
		D = Integer.parseInt(st.nextToken());		// 행의 개수 N
		
		map = new int[N+1][M];
		temp = new int[N+1][M];
		visited = new int[N+1][M];
		
		for (int i = 0; i < map.length - 1; i++) {
			String str = br.readLine();
			for (int j = 0, index = 0; j < map[i].length; j++, index += 2) {
				map[i][j] = str.charAt(index) - '0';
			}
		}
		max = 0;
		game(0, 0);
		
		System.out.println(max);
	}
	// 궁수의 위치는 (N, xx), 조합 수 MC3
	public static void game(int start, int cnt) {
		if (cnt == 3)	{	// 종료 조건. 궁수 세명
			copy();
			
			int killCount = 0;
			// 궁수 배치 후에 할 일.
			while (true) {
				// visited는 move할 때마다 초기화
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[0].length; j++) {
						visited[i][j] = 0;
					}
				}
				if (checkMap(temp) == 1)
					break;
				
				// 궁수 배치된 곳. 3 곳
				//killCount = 0;
				for (int k = 0; k < map[0].length; k++) {
					// 궁수 위치
					int breakF = 0;
					if (temp[map.length - 1][k] == 1) {
ex:						for (int d = 1; d <= D; d++) {
							for (int i = 0; i < map[0].length; i++) {
								for (int j = map.length-2; j >= 0; j--) {
									if (measure(map.length-1, k, j, i) == d && temp[j][i] == 1) {
//										System.out.println(j + " " + i + " " + d);
										if (visited[j][i] != 0) {
											breakF = 1;
											break;
										}
										visited[j][i] = 1;
										breakF = 1;
										break;
									}
								}
								if (breakF == 1)
									break;
							}
							if (breakF == 1)
								break;
						}
					}	// 궁수 한 놈 끝
				}
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[0].length; j++) {
						if (visited[i][j] == 1) {
							temp[i][j] = 0;
							killCount++;
						}
					}
				}
				move(temp);
			}
			if (killCount > max)
				max = killCount;
		}
		
		for (int i = start; i < map[0].length; i++) {
			if (map[map.length - 1][i] == 0) {
				map[map.length - 1][i] = 1;
				game(i+1, cnt+1);
				map[map.length - 1][i] = 0;
			}
		}
	}
	
	public static void copy() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	
	// 게임 끝나면(모두 0) 1 리턴
	public static int checkMap(int[][] temp) {
		int flag = 1;
		int bflag = 1;
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (temp[i][j] == 1) {
					flag = 0;
					bflag = 0;
					break;
				}
			}
			if (bflag == 0)
				break;
		}
		
		if (flag == 0)
			return 0;
		else
			return 1;
	}
	// 적 이동
	public static void move(int[][] temp) {
		for (int i = map.length-2; i > 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				temp[i][j] = temp[i-1][j];
			}
		}
		
		for (int i = 0; i < map[0].length; i++) {
			temp[0][i] = 0;
		}
	}
	
	public static int measure(int x1, int y1, int x2, int y2) {
		int distance = Math.abs(x1-x2) + Math.abs(y1-y2);
		
		return distance;
	}
	
	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}




