import java.util.Scanner;

public class SWEA1244_최대상금 {
	public static int max = 0;
	public static char[] arr;
	public static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			String N = sc.next();
			K = sc.nextInt();
			arr = new char[N.length()];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = N.charAt(i);
			}
			
			dfs(0, 0);
			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	// n : 바꿀 인덱스
	public static void dfs(int n, int k) {
		if (k == K) {
			String str = new String(arr);
			int com = Integer.parseInt(str);
			
			if (com > max)
				max = com;
			
			return;
		} else {
			for (int i = n; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) {
					swap(i, j);
					dfs(i, k+1);
					swap(i, j);
				}
			}
		}
	}
	
	public static void swap(int x, int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
