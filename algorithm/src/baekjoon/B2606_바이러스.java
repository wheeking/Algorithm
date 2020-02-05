package baekjoon;

import java.util.Scanner;

public class B2606_바이러스 {
	static int[][] map;
	static int[] visited;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 컴퓨터 수
		int M = sc.nextInt();	// 간선 수
		map = new int[N+1][N+1];
		
		//간선 입력
		for (int i = 0; i < M; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			map[m][n] = 1;
			map[n][m] = 1;
		}
		
		visited = new int[N+1];
		dfs(1);
		
		// 1번 컴퓨터 빼고 계산
		System.out.println(ans - 1);
	}
	
	// 항상 1번부터 시작. 문제에서. x는 정점
	public static void dfs(int x) {
		if (visited[x] == 1)
			return;
		
		visited[x] = 1;	// 방문 체크
		ans++;		// 할일
			
		for (int i = 0; i < map.length; i++) {
			if (map[x][i] == 1 && visited[i] == 0)
				dfs(i);
		}
		
	}
}
