package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class rPoint implements Comparable {
	int x;
	int y;
	int cost;
	rPoint(int x, int y, int cost){
		this.x = x;
		this.y = y; 
		this.cost = cost; 
	}
	
	public int compareTo(rPoint o) {
		return this.cost - o.cost;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class B4485_젤다 {
	public static int[][] map;
	public static int[][] dist;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int N;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int count = 1;
		while (true) { 
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			
			map = new int[N][N];
			dist =new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int index = 0;
				while(st.hasMoreTokens()) {
					map[i][index] = Integer.parseInt(st.nextToken());
					dist[i][index] = min;
					index++;
				}
			}
			
			int ans = bfs();
			
			sb.append("Problem "+ count + ": " + ans + "\n");
			count += 1;
		}
		
		System.out.println(sb.toString());
	}
	
	public static int bfs() {
		PriorityQueue<rPoint> pq = new PriorityQueue<rPoint>();
		dist[0][0] = map[0][0]; 
		pq.add(new rPoint(0, 0, map[0][0])); 
		
		while(!pq.isEmpty()) {
			rPoint n = pq.poll();
			int garo = n.x;
			int sero = n.y;
			int cost = n.cost;
			
			if(dist[garo][sero] < cost) {
				continue;
			}
	
			for(int k = 0; k < dx.length; k++) {
				int newX = dx[k] + garo;
				int newY = dy[k] + sero;
				if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
					if(dist[newX][newY] > dist[garo][sero] + map[newX][newY]) {
						dist[newX][newY] = dist[garo][sero] + map[newX][newY];
						pq.add(new rPoint(newX, newY, dist[newX][newY]));
					}
				}	
			}
		}
		
		return dist[N-1][N-1];
	}	
}