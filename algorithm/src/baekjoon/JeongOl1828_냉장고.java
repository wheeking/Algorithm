package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class JeongOl1828_냉장고 {
	public static void main(String[] args) {
		ArrayList<Temp> list = new ArrayList<Temp>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Temp[] tArr = new Temp[N];
		
		for (int i = 0; i < N; i++) {
			tArr[i] = new Temp(sc.nextInt(), sc.nextInt());
		}
		
		list.add(tArr[0]);
		for (int i = 1; i < N; i++) {
			// 전 페어의 최고온도보다 지금 페어의 최저온도가 높거나,
			// 전 페어의 최저온도보다 지금 페어의 최고온도가 낮을때
			
		}
	}
}

class Temp {
	int low;
	int high;
	
	Temp(int low, int high) {
		this.low = low;
		this.high = high;
	}
}