import java.util.Scanner;

public class SWEA1494_사랑의카운슬러 {
	public static int[] visited;
	public static long[][] snake;
	public static long min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			visited = new int[N];
			snake = new long[N][2]; // 0은 x 1은 y
			min = Long.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				long x = sc.nextLong();
				long y = sc.nextLong();
				
				snake[i][0] = x;
				snake[i][1] = y;
			}
			
			dfs(0, 0);
			
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	public static void dfs(int p, int cnt) {
		if (cnt == visited.length/2)	{	// 종료 조건
			long xSum = 0;
			long ySum = 0;
			
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == 1) {
					xSum += snake[i][0];
					ySum += snake[i][1];
				} else {
					xSum -= snake[i][0];
					ySum -= snake[i][1];
				}				
			}
			long v = xSum*xSum + ySum*ySum;
			if (v < min)
				min = v;
			
			return;		// 종료 조건이니
		}
		
		// 수행
		for (int i = p; i < visited.length; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				dfs(i+1, cnt+1);
				visited[i]=0;
			}
		}
	}
}