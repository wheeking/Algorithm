import java.util.Scanner;

public class SWEA4408_자기방돌아가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] room = new int[200];
			int max = 0;
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				int x = revise(start);
				int y = revise(end);
				
				// 큰 숫자가 먼저 나올 수도 있음...
				if (x > y) {
					int temp = x;
					x = y;
					y = temp;
				}
				
				for (int j = x; j <= y; j++) {
					room[j] += 1;
				}
				
				for (int j = 0; j < room.length; j++) {
					if (room[j] > max) 
						max = room[j];
				}
			}
			
			System.out.println("#"+ test_case + " " + max);
		}
	}
	
	public static int revise(int k) {
		if (k%2 == 0)
			return k/2-1;
		else
			return (k+1)/2-1;
	}
}
