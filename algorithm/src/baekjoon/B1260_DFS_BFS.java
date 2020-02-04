package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260_DFS_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int v = sc.nextInt();
	
		int[][] map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 양쪽 다 간선 삽입
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(map, v);
		System.out.println();
		bfs(map, v);
		
//		
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void bfs(int[][] map, int v) {
		int[] visited = new int[map.length];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(v);	// 시작정점 큐에 삽입
		visited[v] = 1;	// 방문한 것으로 표시
		while(!q.isEmpty()) {
			v = q.poll();		// 큐에서 꺼내기
			System.out.print(v + " ");	// 방문 처리(출력)
			
			for (int i = 1; i < map.length; i++) {
				if (map[v][i] == 1 && visited[i] == 0) {	// 반복 정접들 모두 큐에 넣기
					q.offer(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	public static void dfs(int[][] map, int v) {
		int[] visited = new int[map.length];
		int[] stack = new int[map.length +20];
		int top = -1;	// 스택 생성
		
		stack[++top] = v;	// 시작 정점 스택에 삽입
		visited[v] = 1; // 시작 정점 방문 체크
		System.out.print(v + " "); 	// 방문해서 할 일. 출력.
		while (top > -1) { // 스택이 비워질 때까지
			int w = -1;	// v 정점에 인접한 정점
			// 인접한 정점 중 미방문 정점 착기
			for (int i = 0; i < map.length; i++) {
				if (map[v][i] == 1 && visited[i] == 0) {
					w = i; // 다음 갈 정점을 저장
					stack[++top] = w;	// 스택에 넣기
					visited[w] = 1;	// 방문 체크
					
					System.out.print(w + " ");	// 방문해서 할 일.
					v = w;	// v에 w값(더 깊이 들어가게)
					break; // 나와서 다시
				}
			}
			
			if (w == -1) {	// 인접한 정점 중 미방문 정점 없을 때
				// 이전 갈림길로.
				v = stack[top--];
			}	
		}
	}
}
