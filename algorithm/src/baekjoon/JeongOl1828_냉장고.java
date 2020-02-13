package baekjoon;

import java.util.Scanner;

public class JeongOl1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] xArr = new int[N];
		int[] yArr = new int[N];
		int minX = 10000;
		int maxY = 0;
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			xArr[i] = x;
			yArr[i] = y;
			if (x < minX) 
				minX = x;
			if (y > maxY)
				maxY = y;
		}
		
		if (minX < 0)
			minX *= -1;
		
		if (maxY < 0)
			maxY *= -1;
		
		for (int i = 0; i < N; i++) {
			xArr[i] += minX;
			yArr[i] += minX;
		}
		
		int[] check = new int[minX + maxY + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = xArr[i]; j <= yArr[i]; j++) {
				if (check[j] == 2)
					continue;
				
				check[j] += 1;
			}
		}
		
		int max = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i] > max)
				max = check[i];
		}
		
		System.out.println(max-1);
	}
}