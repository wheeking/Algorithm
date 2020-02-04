import java.util.LinkedList;
import java.util.Scanner;

public class SWEA1229_암호문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();	// 원본 암호문의 길이 N
			LinkedList<Integer> cryptogram = new LinkedList<Integer>();
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				cryptogram.offer(temp);
			}
			// 명령어의 개수
			int numOfOrder = sc.nextInt();
			for (int j = 0; j < numOfOrder; j++) {
				char order = sc.next().charAt(0);
				switch (order) {
					case 'I':
						int loc = sc.nextInt();
						int quan = sc.nextInt();
						int newLoc = loc;
						for (int k = 0; k < quan; k++) {
							cryptogram.add(newLoc++, sc.nextInt());
						}
						break;
					case 'D':
						loc = sc.nextInt();
						quan = sc.nextInt();
						for (int k = 0; k < quan; k++) {
							cryptogram.remove(loc);
						}
						break;
				}
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(cryptogram.pollFirst() + " ");
			}
			System.out.println();
		}
	}
}