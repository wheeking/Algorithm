import java.util.Scanner;

public class SWEA1231_중위순회 {
	public static String[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			tree = new String[N+1];
			
			// 1. tree 배열에 차곡차곡 다 넣고
			for (int i = 0; i < N; i++) {
				String temp = sc.nextLine();
				String[] arr = temp.split(" ");
				int node = Integer.parseInt(arr[0]);
				String alphabet = arr[1]; 
				
				tree[node] = alphabet;		
			}
			
			// 2. 중위 순회
			System.out.print("#" + test_case + " ");
			inOrder(1);
			System.out.println();
		}
	}
	
	public static void inOrder(int index) {
		if (index >= tree.length || tree[index] == null) {	// 배열 범위를 벗어나거나, 자식이 없을 때 리턴
			return;
		}
		inOrder(index*2);
		System.out.print(tree[index]);
		inOrder(index*2+1);
	}
}
