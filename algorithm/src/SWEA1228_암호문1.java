import java.util.LinkedList;
import java.util.Scanner;

public class SWEA1228_암호문1 {
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
				sc.next();		// I 받을 스캐너
				int loc = sc.nextInt();
				int quan = sc.nextInt();
				int newLoc = loc;
				for (int k = 0; k < quan; k++) {
					cryptogram.add(newLoc++, sc.nextInt());
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