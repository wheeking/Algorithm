package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JeongOl1828_냉장고 {
	// start, end
	public static class Chemical implements Comparable<Chemical> {
		int s;
		int e;

		public Chemical(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Chemical o) {
			return this.e - o.e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Chemical[] cArr = new Chemical[N];
		
		// 배열에 온도 입력까지
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cArr[i] = new Chemical(a, b);
		}
		
		// 최고보관온도를 기준으로 정렬
		Arrays.sort(cArr);
		
		int count = 1;
		Chemical c = cArr[0]; // 초기값 저장
		
		// 앞의 범위를 벗어나는지  계속 확인
		for (int i = 1; i < cArr.length; i++) {
			if (cArr[i].s > c.e) {
				count++;
				c = cArr[i];
			}
		}
		
		System.out.println(count);
	}
}