package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14502_연구소 {
	public static int[][] map;
	public static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = 0;
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}
	
	
}
