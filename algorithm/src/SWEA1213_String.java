import java.util.Scanner;

public class SWEA1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			sc.nextInt();
			String word = sc.next();
			String str = sc.next();
			char[] ch = new char[str.length()];
			
			for (int i = 0; i < ch.length; i++) {
				ch[i] = str.charAt(i);
			}
			int ans = 0;

			int flag = 0;
			for (int i = 0; i < ch.length; i++) {
				if (word.charAt(0) == ch[i]) {
					for (int j = 1; j < word.length(); j++) {
						if ((i+j) < ch.length && word.charAt(j) != ch[i+j]) {	// 같지 않음 break;
							flag = 0;
							break;
						}
						if (j == word.length()-1 && (i+j) < ch.length) flag = 1;
					}

					if (flag == 1) {
						ans++;
						i = i+word.length() - 1;
					}
					flag = 0;
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
