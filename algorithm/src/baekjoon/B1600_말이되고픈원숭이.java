package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1600_말이되고픈원숭이 {
	public static int[][] map;
	public static int[][][] d;
	public static int dMin = Integer.MAX_VALUE;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	public static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		map = new int[H][W];
		d = new int[H][W][K+1];	// 0번지는 옆 이동, 1부터는 K번 말처럼 이동한 횟수대로 따로 저장 
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[H][W] = sc.nextInt();
			}
		}
		
		bfs(new hInfo(0, 0, 0));
		
		int flag = 1;
		for (int i = 0; i < K; i++) {
			if (d[H-1][W-1][i] != 0)
				flag = 0;
		}
		if (flag == 0)
			dMin = -1;
		
		System.out.println(dMin);
	} // end of main
	
	public static void bfs(hInfo h) {
		Queue<hInfo> q = new LinkedList<hInfo>();
		q.offer(h);
		d[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			hInfo temp = q.poll();
			// 정답 최소값 체크
			if (temp.x == map.length-1 && temp.y == map[0].length-1) {
				if (d[temp.x][temp.y][temp.cnt] < dMin) {
					dMin = d[temp.x][temp.y][temp.cnt];
				}
			}
			
			
		}
	}
}

class hInfo {
	int x;
	int y;
	int cnt;	// 말처럼 이동한 횟수
	
	hInfo(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
