import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr1 = new int[N][N];
			int[][] arr2 = new int[N][N];
			int[][] arr3 = new int[N][N];
			int[][] arr4 = new int[N][N];
			
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr1.length; j++) {
					arr1[i][j] = sc.nextInt();
				}
			}
			
			arr2 = rotate(arr1);
			arr3 = rotate(arr2);
			arr4 = rotate(arr3);
			
			System.out.println("#" + test_case + " ");
			for (int i = 0; i < arr4.length; i++) {
				printOneLine(arr2[i]);
				System.out.print(" ");
				printOneLine(arr3[i]);
				System.out.print(" ");
				printOneLine(arr4[i]);
				System.out.println();
			}
		}
	}
	
	public static void printOneLine(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] rotate(int[][] arr) {
		int len = arr.length;
		int[][] newArr = new int[len][len];
		
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr.length; j++) {
				newArr[i][j] = arr[len - j - 1][i];
			}
		}
		
		return newArr;
	}
}

