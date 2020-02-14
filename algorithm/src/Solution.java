import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int distance = 0;
			int nowSpeed = 0;
			
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				if (command == 0) {
					distance += nowSpeed*1;
					continue;
				}
				int speed = sc.nextInt();
				
				if (command == 1) {
					nowSpeed += speed;
				} else {
					nowSpeed -= speed;
					if (nowSpeed < 0)
						nowSpeed = 0;
				}
				
				distance += nowSpeed*1;
			}
			
			
				
			System.out.println("#" + test_case + " " + distance);
		}
	}
}

