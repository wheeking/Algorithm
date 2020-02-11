package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동 {
	public static int[][] map;
	public static int[][][] visited;
	public static final int[] dx = {1, -1, 0, 0};
	public static final int[] dy = {0, 0, 1, -1};
	public static int depMin;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		depMin = Integer.MAX_VALUE;
		visited = new int[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		bfs(new bInfo(0, 0, 0));
		
		if (visited[N-1][M-1][0] == 0 && visited[N-1][M-1][1] == 0) 
			depMin = -1;
		
		System.out.println(depMin);
		
		
		
	} // end of main
	
	public static void bfs(bInfo b) {
		Queue<bInfo> q = new LinkedList<bInfo>();
		
		q.offer(b);
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			bInfo temp = q.poll();
			if (temp.x == map.length-1 && temp.y == map[0].length-1) {
				if (visited[temp.x][temp.y][temp.check] < depMin) {
					depMin = visited[temp.x][temp.y][temp.check];
				}
			}
			
			for (int k = 0; k < 4; k++) {
				int newX = temp.x + dx[k];
				int newY = temp.y + dy[k];
				
				// newX, newY 가 0일 때, 그냥 갈 때 
				if (rangeCheck(newX, newY) == 1 && map[newX][newY] == 0 && visited[newX][newY][temp.check] == 0) {
					q.offer(new bInfo(newX, newY, temp.check));
					visited[newX][newY][temp.check] = visited[temp.x][temp.y][temp.check] + 1;
				}
				
				// newX, newY 가 1일 때
				if (rangeCheck(newX, newY) == 1 && map[newX][newY] == 1 && visited[newX][newY][1] == 0) {
					if (temp.check == 0) {
						q.offer(new bInfo(newX, newY, 1));
						visited[newX][newY][1] = visited[temp.x][temp.y][temp.check] + 1;
					}
				}
			}
		}
	}
	
	// 리턴값 1이면 범위 넘어가지 않는 것.
	public static int rangeCheck(int x, int y) {
		int flag = 0;
		
		if (x >= 0 && y >= 0 && x < map.length && y < map[0].length)
			flag = 1;
		
		return flag;
	}
}

class bInfo {
	int x;
	int y;
	int check;
	
	bInfo(int x, int y, int check) {
		this.x = x;
		this.y = y;
		this.check = check;
	}
}