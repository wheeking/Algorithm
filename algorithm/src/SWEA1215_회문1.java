import java.util.Scanner;

public class SWEA1215_회문1 {
	public static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		for (int test_case = 1; test_case <= 10; test_case++) {
			ans = 0;
			int len = sc.nextInt();
			char[][] map = new char[8][8];
			for (int i = 0; i < map.length; i++) {
				String temp = sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j <= map.length-len; j++) {
					checkUnder(map, i, j, len);
				}
			}
			
			for (int i = 0; i <= map.length-len; i++) {
				for (int j = 0; j < map.length; j++) {
					checkRight(map, i, j, len);
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		
		
	} // end of main
	
	public static void checkRight(char[][] map, int x, int y, int len) {
		int flag = 1;	// 회문이면 flag 1
		for (int i = 0; i < len/2; i++) {
			if (map[x+i][y] != map[x+len-i-1][y]) {
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			ans++;
		
		
	}
	
	public static void checkUnder(char[][] map, int x, int y, int len) {
		int flag = 1;
		
		for (int i = 0; i < len/2; i++) {
			if (map[x][y+i] != map[x][y+len-i-1]) {
				flag = 0;
				break;
			}
		}
		
		if (flag == 1)
			ans++;
	}
}	// end of class
