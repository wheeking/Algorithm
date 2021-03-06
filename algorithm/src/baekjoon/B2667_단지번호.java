package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B2667_단지번호 {
	static int[][] map;
	static int[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int cnt = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans[] = new int[N*N];
		map = new int[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					Pair p = new Pair(i, j);
					ans[cnt++] = bfs(p);
				}
			}
		}
		System.out.println(cnt);
		int[] newAns = new int[cnt];
		
		for (int i = 0; i < cnt; i++) {
			newAns[i] = ans[i];
		}
		
		Arrays.sort(newAns);
		for (int i : newAns) {
			System.out.println(i);
		}
		
	} // end of main
	
	public static int bfs(Pair p) {
		int ans = 1;	// 단지에 속한 집의 수
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.add(p);
		visited[p.x][p.y] = cnt;
		
		while(!q.isEmpty()) {
			Pair temp = q.remove();
			
			for (int i = 0; i < dx.length; i++) {
				int newX = temp.x + dx[i];
				int newY = temp.y + dy[i];
				if (newX >= 0 && newX < map.length && newY >= 0 && newY < map.length) {
					if (visited[newX][newY] == 0 && map[newX][newY] != 0) {
						ans++;
						Pair newP = new Pair(newX, newY);
						q.add(newP);
						visited[newP.x][newP.y] = cnt;
					}
				}
			}
			
		}
		cnt++;
		
		return ans;
	}
}
