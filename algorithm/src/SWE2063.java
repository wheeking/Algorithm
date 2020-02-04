import java.util.Arrays;
import java.util.Scanner;

public class SWE2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int half = N / 2;
		int[] nArray = new int[N];
		
		// sort한 다음 nArray[half]
		for (int i = 0; i < N; i++) {
			nArray[i] = sc.nextInt();
		}
		Arrays.sort(nArray);
		
		System.out.println(nArray[half]);
	}
}