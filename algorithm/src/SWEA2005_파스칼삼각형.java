import java.util.Scanner;

public class SWEA2005_파스칼삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			arr[0][0] = 1;

			for (int i = 0; i <arr.length; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
			}
			
			for (int i = 2; i < arr.length; i++) {
				for (int j = 1; j <= i-1; j++) {		
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] != 0)
						System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
}
