import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 출발점 0, 도착점 99 
public class SWEA1219_길찾기 {
	// 전역변수로 사용할 때 인접 리스트와 체크행렬은 선언만 할것. 본문에서 초기화 진행
	static ArrayList<Integer>[] a;  // 인접 리스트
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 100;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			ans = 0;
			sc.nextInt();
			
			a = (ArrayList<Integer>[]) new ArrayList[100];
			// 각 정점에 따른 인접리스트 생성
			for (int i = 0; i < len; i++) {
				a[i] = new ArrayList<Integer>();
			}
			
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				a[x].add(y);
			}
			// 정점에 따른 간선 리스트 각각 정렬
			for (int i = 0; i < len; i++) {
				Collections.sort(a[i]);
			}

			// 체크행렬 초기화
//			visited = new boolean[len];
//			visited[0] = true;
//			dfs(0);
			
			visited = new boolean[len];
			visited[0] = true;
			bfs(0);
			
			System.out.println("#" + test_case + " " + ans);
		}
	} // end of main

	public static void dfs(int x) {
		// 도착하면
		if (x == 99) {
			ans = 1;
			return;
		}
		
		int v = x;		// 시작 정점
		// 방문체크
		// 할일 x
		
		for (int i = 0; i < a[v].size(); i++) {
			int w = a[v].get(i);	// 다음 정점
			if (visited[w] == false) {
				visited[w] = true;	// 방문 체크
				dfs(w);
			}
		}	
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		int w = -1;	// 다음 정점
		
		q.offer(x);
		int temp;	// q에서 뺀 값 저장
		while(!q.isEmpty()) {
			temp = q.poll();
			if (temp == 99) {
				ans = 1;
				break;
			}
			for (int i = 0; i < a[temp].size(); i++) {
				w = a[temp].get(i);
				if (visited[w] == false) {
					q.offer(w);
					visited[w] = true;	// 방문체크
				}
			}
		}
	}
}